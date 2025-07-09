package com.example.Mietoru_Back.repository.screenDisplay;

import com.example.Mietoru_Back.entity.Setting;
import com.example.Mietoru_Back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 設定画面表示用のRepositoryインターフェース
 */
@Repository
public interface SettingDataRepository extends JpaRepository<User, String> {

    /**
     * ユーザーIDでユーザー情報を取得
     * 
     * @param userId ユーザーID
     * @return ユーザー情報
     */
    Optional<User> findByUserId(String userId);

    /**
     * ユーザーIDでユーザー情報と設定情報を結合して取得
     * 
     * @param userId ユーザーID
     * @return ユーザー情報
     */
    @Query("SELECT u FROM User u WHERE u.userId = :userId")
    Optional<User> findUserWithSettingsByUserId(@Param("userId") String userId);
}