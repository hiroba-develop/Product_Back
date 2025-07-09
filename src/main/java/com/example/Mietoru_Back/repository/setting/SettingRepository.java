package com.example.Mietoru_Back.repository.setting;

import com.example.Mietoru_Back.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 設定関連のRepositoryインターフェース
 */
@Repository
public interface SettingRepository extends JpaRepository<Setting, String> {

    /**
     * ユーザーIDで設定データを検索
     * 
     * @param userId ユーザーID
     * @return 設定データ（存在しない場合はOptional.empty()）
     */
    Optional<Setting> findByUserId(String userId);

    /**
     * ユーザーIDで設定データが存在するかチェック
     * 
     * @param userId ユーザーID
     * @return 存在する場合true
     */
    boolean existsByUserId(String userId);

    /**
     * ユーザーIDで設定データを削除
     * 
     * @param userId ユーザーID
     */
    void deleteByUserId(String userId);

    /**
     * 会社規模で設定データを検索
     * 
     * @param companySize 会社規模
     * @return 設定データのリスト
     */
    java.util.List<Setting> findByCompanySize(Integer companySize);

    /**
     * 業界で設定データを検索
     * 
     * @param industry 業界
     * @return 設定データのリスト
     */
    java.util.List<Setting> findByIndustry(Integer industry);
}