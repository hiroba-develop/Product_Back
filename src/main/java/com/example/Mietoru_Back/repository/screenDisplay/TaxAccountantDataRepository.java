package com.example.Mietoru_Back.repository.screenDisplay;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Map;

/**
 * 税理士画面用のRepositoryクラス
 * 税理士関連の統合データを取得する
 */
@Repository
public class TaxAccountantDataRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * ユーザーIDで税理士表示用の統合データを取得
     * ユーザー情報と税理士コメントを統合して取得
     * 
     * @param userId ユーザーID
     * @return 税理士表示用データのマップ
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findTaxAccountantDataByUserId(String userId) {
        String sql = """
                SELECT
                    u.USER_ID as userId,
                    u.NAME as userName,
                    u.COMPANY as company,
                    u.EMAIL as email,
                    u.TEL_NO as telNo,
                    t.YEAR as year,
                    t.MONTH as month,
                    t.TAX_ACCOUNTANT_COMMENT as taxAccountantComment,
                    t.TAX_ACCOUNTANT_COMMENT_FLG as taxAccountantCommentFlg,
                    t.CREATED_AT as commentCreatedAt,
                    t.UPDATED_AT as commentUpdatedAt
                FROM USERS u
                LEFT JOIN TAX_ACCOUNTANT_COMMENTS t ON u.USER_ID = t.USER_ID
                WHERE u.USER_ID = :userId
                AND u.DEL_FLG = '0'
                ORDER BY t.YEAR DESC, t.MONTH DESC
                """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("userId", userId);

        return query.getResultList();
    }

    /**
     * ユーザーIDと年度で税理士表示用データを取得
     * 
     * @param userId ユーザーID
     * @param year   年度
     * @return 税理士表示用データのマップ
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findTaxAccountantDataByUserIdAndYear(String userId, Integer year) {
        String sql = """
                SELECT
                    u.USER_ID as userId,
                    u.NAME as userName,
                    u.COMPANY as company,
                    t.YEAR as year,
                    t.MONTH as month,
                    t.TAX_ACCOUNTANT_COMMENT as taxAccountantComment,
                    t.TAX_ACCOUNTANT_COMMENT_FLG as taxAccountantCommentFlg,
                    s.SALE_TARGET as saleTarget,
                    s.SALE_RESULT as saleResult,
                    p.PROFIT_TARGET as profitTarget,
                    p.PROFIT_RESULT as profitResult
                FROM USERS u
                LEFT JOIN TAX_ACCOUNTANT_COMMENTS t ON u.USER_ID = t.USER_ID
                LEFT JOIN SALES s ON u.USER_ID = s.USER_ID AND t.YEAR = s.YEAR AND t.MONTH = s.MONTH
                LEFT JOIN PROFITS p ON u.USER_ID = p.USER_ID AND t.YEAR = p.YEAR AND t.MONTH = p.MONTH
                WHERE u.USER_ID = :userId
                AND t.YEAR = :year
                AND u.DEL_FLG = '0'
                ORDER BY t.MONTH ASC
                """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("year", year);

        return query.getResultList();
    }
}