package com.example.Mietoru_Back.repository.netAsset;

import com.example.Mietoru_Back.entity.NetAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 純資産関連のRepositoryインターフェース
 */
@Repository
public interface NetAssetRepository extends JpaRepository<NetAsset, String> {

    /**
     * ユーザーIDで純資産データを検索
     * 
     * @param userId ユーザーID
     * @return 純資産データのリスト
     */
    List<NetAsset> findByUserId(String userId);

    /**
     * ユーザーIDと年度で純資産データを検索
     * 
     * @param userId ユーザーID
     * @param year   年度
     * @return 純資産データ（存在しない場合はOptional.empty()）
     */
    Optional<NetAsset> findByUserIdAndYear(String userId, Integer year);

    /**
     * ユーザーIDで純資産データを年度の昇順で検索
     * 
     * @param userId ユーザーID
     * @return 純資産データのリスト（年度昇順）
     */
    List<NetAsset> findByUserIdOrderByYearAsc(String userId);

    /**
     * ユーザーIDで純資産データを年度の降順で検索
     * 
     * @param userId ユーザーID
     * @return 純資産データのリスト（年度降順）
     */
    List<NetAsset> findByUserIdOrderByYearDesc(String userId);

    /**
     * ユーザーIDと年度範囲で純資産データを検索
     * 
     * @param userId    ユーザーID
     * @param startYear 開始年度
     * @param endYear   終了年度
     * @return 純資産データのリスト
     */
    List<NetAsset> findByUserIdAndYearBetween(String userId, Integer startYear, Integer endYear);
}