package com.example.Mietoru_Back.repository.auth;

import com.example.Mietoru_Back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * ユーザー認証関連のRepositoryインターフェース
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * メールアドレスでユーザーを検索
     * 
     * @param email メールアドレス
     * @return ユーザー情報（存在しない場合はOptional.empty()）
     */
    Optional<User> findByEmail(String email);

    /**
     * Google IDでユーザーを検索
     * 
     * @param googleId Google ID
     * @return ユーザー情報（存在しない場合はOptional.empty()）
     */
    Optional<User> findByGoogleId(String googleId);

    /**
     * メールアドレスとパスワードハッシュでユーザーを検索
     * 
     * @param email        メールアドレス
     * @param passwordHash パスワードハッシュ
     * @return ユーザー情報（存在しない場合はOptional.empty()）
     */
    Optional<User> findByEmailAndPasswordHash(String email, String passwordHash);

    /**
     * メールアドレスが既に存在するかチェック
     * 
     * @param email メールアドレス
     * @return 存在する場合true
     */
    boolean existsByEmail(String email);

    /**
     * Google IDが既に存在するかチェック
     * 
     * @param googleId Google ID
     * @return 存在する場合true
     */
    boolean existsByGoogleId(String googleId);

    /**
     * ローカル登録用：メールアドレスとパスワードハッシュが設定されているユーザーが存在するかチェック
     * 
     * @param email メールアドレス
     * @return 存在する場合true
     */
    boolean existsByEmailAndPasswordHashIsNotNull(String email);

    /**
     * Google SSO登録用：メールアドレスとGoogle IDが設定されているユーザーが存在するかチェック
     * 
     * @param email メールアドレス
     * @return 存在する場合true
     */
    boolean existsByEmailAndGoogleIdIsNotNull(String email);

    /**
     * 削除フラグがfalseのユーザーをメールアドレスで検索
     * 
     * @param email  メールアドレス
     * @param delFlg 削除フラグ
     * @return ユーザー情報（存在しない場合はOptional.empty()）
     */
    Optional<User> findByEmailAndDelFlg(String email, String delFlg);
}