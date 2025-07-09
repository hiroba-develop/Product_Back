package com.example.Mietoru_Back.repository.screenDisplay;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Map;

/**
 * 予算実績画面用のRepositoryクラス
 * 複数のエンティティから統合データを取得する
 */
@Repository
public class BudgetActualDataRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * ユーザーIDと年度で予算実績データを取得
     * 売上、利益、純資産のデータを統合して取得
     * 
     * @param userId ユーザーID
     * @param year   年度
     * @return 予算実績データのマップ
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findBudgetActualDataByUserIdAndYear(String userId, Integer year) {
        String sql = """
                SELECT
                    COALESCE(s.MONTH, p.MONTH) as month,
                    s.SALE_TARGET as saleTarget,
                    s.SALE_RESULT as saleResult,
                    p.PROFIT_TARGET as profitTarget,
                    p.PROFIT_RESULT as profitResult
                FROM SALES s
                FULL OUTER JOIN PROFITS p ON s.USER_ID = p.USER_ID AND s.YEAR = p.YEAR AND s.MONTH = p.MONTH
                WHERE COALESCE(s.USER_ID, p.USER_ID) = :userId
                AND COALESCE(s.YEAR, p.YEAR) = :year
                ORDER BY COALESCE(s.MONTH, p.MONTH)
                """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("year", year);

        return query.getResultList();
    }
}