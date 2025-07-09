package com.example.Mietoru_Back.repository.screenDisplay;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Map;

/**
 * ダッシュボード画面用のRepositoryクラス
 * 複数のエンティティから統合データを取得する
 */
@Repository
public class DashboardDataRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * ユーザーIDでダッシュボード表示用の統合データを取得
     * 
     * @param userId ユーザーID
     * @return ダッシュボードデータのマップ
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findDashboardDataByUserId(String userId) {
        String sql = """
                SELECT
                    'sales' as dataType,
                    s.YEAR as year,
                    s.MONTH as month,
                    s.SALE_TARGET as target,
                    s.SALE_RESULT as result
                FROM SALES s
                WHERE s.USER_ID = :userId
                UNION ALL
                SELECT
                    'profits' as dataType,
                    p.YEAR as year,
                    p.MONTH as month,
                    p.PROFIT_TARGET as target,
                    p.PROFIT_RESULT as result
                FROM PROFITS p
                WHERE p.USER_ID = :userId
                ORDER BY year DESC, month DESC
                """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("userId", userId);

        return query.getResultList();
    }

    /**
     * ユーザーIDで最新の純資産データを取得
     * 
     * @param userId ユーザーID
     * @return 最新の純資産データ
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> findLatestNetAssetByUserId(String userId) {
        String sql = """
                SELECT
                    n.YEAR as year,
                    n.NET_ASSET_TARGET as netAssetTarget,
                    n.NET_ASSET_RESULT as netAssetResult
                FROM NET_ASSETS n
                WHERE n.USER_ID = :userId
                ORDER BY n.YEAR DESC
                LIMIT 1
                """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("userId", userId);
        query.setMaxResults(1);

        List<Map<String, Object>> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }
}