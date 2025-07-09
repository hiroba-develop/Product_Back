package com.example.Mietoru_Back.repository.sale;

import com.example.Mietoru_Back.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 売上関連のRepositoryインターフェース
 */
@Repository
public interface SaleRepository extends JpaRepository<Sale, String> {

    /**
     * ユーザーIDで売上データを検索
     * 
     * @param userId ユーザーID
     * @return 売上データのリスト
     */
    List<Sale> findByUserId(String userId);

    /**
     * ユーザーIDと年度で売上データを検索
     * 
     * @param userId ユーザーID
     * @param year   年度
     * @return 売上データのリスト
     */
    List<Sale> findByUserIdAndYear(String userId, Integer year);

    /**
     * ユーザーID、年度、月度で売上データを検索
     * 
     * @param userId ユーザーID
     * @param year   年度
     * @param month  月度
     * @return 売上データ（存在しない場合はOptional.empty()）
     */
    Optional<Sale> findByUserIdAndYearAndMonth(String userId, Integer year, Integer month);

    /**
     * ユーザーIDで売上データを年月順で検索
     * 
     * @param userId ユーザーID
     * @return 売上データのリスト（年月昇順）
     */
    List<Sale> findByUserIdOrderByYearAscMonthAsc(String userId);

    /**
     * ユーザーIDと年度範囲で売上データを検索
     * 
     * @param userId    ユーザーID
     * @param startYear 開始年度
     * @param endYear   終了年度
     * @return 売上データのリスト
     */
    List<Sale> findByUserIdAndYearBetween(String userId, Integer startYear, Integer endYear);

    /**
     * ユーザーIDと年度で売上データを月度の昇順で検索
     * 
     * @param userId ユーザーID
     * @param year   年度
     * @return 売上データのリスト（月度昇順）
     */
    List<Sale> findByUserIdAndYearOrderByMonthAsc(String userId, Integer year);
}