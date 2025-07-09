package com.example.Mietoru_Back.repository.screenDisplay;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Map;

/**
 * ロードマップ画面用のRepositoryクラス
 * 長期計画に関するデータを取得する
 */
@Repository
public class RoadmapDataRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * ユーザーIDでロードマップ表示用の年度別統合データを取得
     * 
     * @param userId ユーザーID
     * @return ロードマップデータのマップ
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findRoadmapDataByUserId(String userId) {
        String sql = """
                SELECT
                    n.YEAR as year,
                    n.NET_ASSET_TARGET as netAssetTarget,
                    n.NET_ASSET_RESULT as netAssetResult,
                    s.yearly_sale_target as yearlySaleTarget,
                    s.yearly_sale_result as yearlySaleResult,
                    p.yearly_profit_target as yearlyProfitTarget,
                    p.yearly_profit_result as yearlyProfitResult
                FROM NET_ASSETS n
                LEFT JOIN (
                    SELECT
                        USER_ID,
                        YEAR,
                        SUM(SALE_TARGET) as yearly_sale_target,
                        SUM(SALE_RESULT) as yearly_sale_result
                    FROM SALES
                    GROUP BY USER_ID, YEAR
                ) s ON n.USER_ID = s.USER_ID AND n.YEAR = s.YEAR
                LEFT JOIN (
                    SELECT
                        USER_ID,
                        YEAR,
                        SUM(PROFIT_TARGET) as yearly_profit_target,
                        SUM(PROFIT_RESULT) as yearly_profit_result
                    FROM PROFITS
                    GROUP BY USER_ID, YEAR
                ) p ON n.USER_ID = p.USER_ID AND n.YEAR = p.YEAR
                WHERE n.USER_ID = :userId
                ORDER BY n.YEAR ASC
                """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("userId", userId);

        return query.getResultList();
    }

    /**
     * ユーザーIDと年度範囲でロードマップデータを取得
     * 
     * @param userId    ユーザーID
     * @param startYear 開始年度
     * @param endYear   終了年度
     * @return ロードマップデータのマップ
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findRoadmapDataByUserIdAndYearRange(String userId, Integer startYear,
            Integer endYear) {
        String sql = """
                SELECT
                    n.YEAR as year,
                    n.NET_ASSET_TARGET as netAssetTarget,
                    n.NET_ASSET_RESULT as netAssetResult
                FROM NET_ASSETS n
                WHERE n.USER_ID = :userId
                AND n.YEAR BETWEEN :startYear AND :endYear
                ORDER BY n.YEAR ASC
                """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("startYear", startYear);
        query.setParameter("endYear", endYear);

        return query.getResultList();
    }
}