package com.example.Mietoru_Back.repository.profit;

import com.example.Mietoru_Back.entity.Profit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 利益関連のRepositoryインターフェース
 */
@Repository
public interface ProfitRepository extends JpaRepository<Profit, String> {

    /**
     * ユーザーIDで利益データを検索
     * 
     * @param userId ユーザーID
     * @return 利益データのリスト
     */
    List<Profit> findByUserId(String userId);

    /**
     * ユーザーIDと年度で利益データを検索
     * 
     * @param userId ユーザーID
     * @param year   年度
     * @return 利益データのリスト
     */
    List<Profit> findByUserIdAndYear(String userId, Integer year);

    /**
     * ユーザーID、年度、月度で利益データを検索
     * 
     * @param userId ユーザーID
     * @param year   年度
     * @param month  月度
     * @return 利益データ（存在しない場合はOptional.empty()）
     */
    Optional<Profit> findByUserIdAndYearAndMonth(String userId, Integer year, Integer month);

    /**
     * ユーザーIDで利益データを年月順で検索
     * 
     * @param userId ユーザーID
     * @return 利益データのリスト（年月昇順）
     */
    List<Profit> findByUserIdOrderByYearAscMonthAsc(String userId);

    /**
     * ユーザーIDと年度範囲で利益データを検索
     * 
     * @param userId    ユーザーID
     * @param startYear 開始年度
     * @param endYear   終了年度
     * @return 利益データのリスト
     */
    List<Profit> findByUserIdAndYearBetween(String userId, Integer startYear, Integer endYear);

    /**
     * ユーザーIDと年度で利益データを月度の昇順で検索
     * 
     * @param userId ユーザーID
     * @param year   年度
     * @return 利益データのリスト（月度昇順）
     */
    List<Profit> findByUserIdAndYearOrderByMonthAsc(String userId, Integer year);
}