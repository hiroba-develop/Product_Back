package com.example.Mietoru_Back.repository.taxAccountantComment;

import com.example.Mietoru_Back.entity.TaxAccountantComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 税理士コメント関連のRepositoryインターフェース
 */
@Repository
public interface TaxAccountantCommentRepository extends JpaRepository<TaxAccountantComment, String> {

    /**
     * ユーザーIDで税理士コメントを検索
     * 
     * @param userId ユーザーID
     * @return 税理士コメントのリスト
     */
    List<TaxAccountantComment> findByUserId(String userId);

    /**
     * ユーザーIDと年度で税理士コメントを検索
     * 
     * @param userId ユーザーID
     * @param year   年度
     * @return 税理士コメントのリスト
     */
    List<TaxAccountantComment> findByUserIdAndYear(String userId, Integer year);

    /**
     * ユーザーID、年度、月度で税理士コメントを検索
     * 
     * @param userId ユーザーID
     * @param year   年度
     * @param month  月度
     * @return 税理士コメント（存在しない場合はOptional.empty()）
     */
    Optional<TaxAccountantComment> findByUserIdAndYearAndMonth(String userId, Integer year, Integer month);

    /**
     * ユーザーIDで税理士コメントを年月順で検索
     * 
     * @param userId ユーザーID
     * @return 税理士コメントのリスト（年月昇順）
     */
    List<TaxAccountantComment> findByUserIdOrderByYearAscMonthAsc(String userId);

    /**
     * ユーザーIDと税理士コメントフラグで税理士コメントを検索
     * 
     * @param userId                  ユーザーID
     * @param taxAccountantCommentFlg 税理士コメントフラグ
     * @return 税理士コメントのリスト
     */
    List<TaxAccountantComment> findByUserIdAndTaxAccountantCommentFlg(String userId, String taxAccountantCommentFlg);

    /**
     * ユーザーIDと年度範囲で税理士コメントを検索
     * 
     * @param userId    ユーザーID
     * @param startYear 開始年度
     * @param endYear   終了年度
     * @return 税理士コメントのリスト
     */
    List<TaxAccountantComment> findByUserIdAndYearBetween(String userId, Integer startYear, Integer endYear);

    /**
     * ユーザーIDと年度で税理士コメントを月度の昇順で検索
     * 
     * @param userId ユーザーID
     * @param year   年度
     * @return 税理士コメントのリスト（月度昇順）
     */
    List<TaxAccountantComment> findByUserIdAndYearOrderByMonthAsc(String userId, Integer year);
}