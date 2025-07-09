package com.example.Mietoru_Back.service.auth;

import com.example.Mietoru_Back.entity.User;
import com.example.Mietoru_Back.model.ApiAuthLoginGet200Response;
import com.example.Mietoru_Back.repository.auth.UserRepository;
import com.example.Mietoru_Back.service.mail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ユーザーログイン処理を行うサービスクラス
 */
@Service
public class LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    /**
     * ユーザーログイン処理
     * 
     * @param email        メールアドレス
     * @param passwordHash パスワードハッシュ（ローカルログイン時のみ）
     * @param googleId     Google ID（Google SSOログイン時のみ）
     * @return ログイン結果
     */
    public ApiAuthLoginGet200Response login(String email, String passwordHash, String googleId) {
        ApiAuthLoginGet200Response response = new ApiAuthLoginGet200Response();

        try {
            Optional<User> user = Optional.empty();

            // Google SSO ログインの場合
            if (googleId != null && !googleId.isEmpty()) {
                user = userRepository.findByGoogleId(googleId);
            }
            // ローカルログインの場合
            else if (email != null && passwordHash != null) {
                user = userRepository.findByEmailAndPasswordHash(email, passwordHash);
            }

            // ユーザーが見つかった場合、削除フラグをチェック
            if (user.isPresent() && "1".equals(user.get().getDelFlg())) {
                // 削除されたユーザーの場合は認証失敗として扱う
                user = Optional.empty();
            }

            if (user.isPresent()) {
                // ログイン成功
                User userEntity = user.get();
                // ログイン通知メールの送信
                boolean isSent = sendLoginNotificationEmail(userEntity);
                if (!isSent) {
                    logger.warn("ログイン通知メール送信失敗: メールアドレスが設定されていません。 userId: {}", userEntity.getUserId());
                }

                response.setResponseStatus(1);

                // null チェックを追加
                String userId = userEntity.getUserId();
                String settingFlg = userEntity.getSettingFlg();

                // ログイン成功時のデータを設定
                if (userId != null) {
                    response.setUserId(userId);
                }
                if (settingFlg != null && !settingFlg.trim().isEmpty()) {
                    // 設定フラグを設定
                    response.setSettingFlg(settingFlg);
                } else {
                    // デフォルト値を設定する場合
                    response.setSettingFlg("0"); // 未設定として扱う
                }
                if (userEntity.getRole() != null) {
                    response.setRole(userEntity.getRole());
                }
            } else {
                // ログイン失敗
                response.setResponseStatus(0);
            }

        } catch (Exception e) {
            // エラー発生時
            logger.error("Login service error", e); // エラーの詳細をログに出力
            response.setResponseStatus(0);
        }

        return response;
    }

    /**
     * ログイン通知メールを送信する
     * 
     * @param user ログインしたユーザー情報
     */
    private boolean sendLoginNotificationEmail(User user) {
        try {
            // ユーザーのメールアドレスを取得
            logger.debug("ユーザーのメールアドレスを取得");
            String email = user.getEmail();
            if (email == null || email.isEmpty()) {
                logger.warn("ログイン通知メール送信失敗: メールアドレスが設定されていません。 userId: {}", user.getUserId());
                return false;
            }

            // 現在の日時を取得
            logger.debug("現在の日時を取得");
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分");
            String formattedDateTime = now.format(formatter);

            // メールの件名
            logger.debug("メールの件名を設定");
            String subject = "【ミエトル】ログイン通知";

            // メールの本文
            StringBuilder body = new StringBuilder();
            body.append(user.getName()).append(" 様\n\n");
            body.append("ミエトルへのログインがありました。\n\n");
            body.append("■ログイン日時: ").append(formattedDateTime).append("\n");
            body.append("\n");
            body.append("このログインに心当たりがない場合は、パスワードの変更をお願いいたします。\n");
            body.append("\n");
            body.append("※このメールは自動送信されています。返信はできませんのでご了承ください。");

            // メール送信
            logger.debug("メール送信");
            emailService.sendSimpleEmail(email, subject, body.toString());

            logger.info("ログイン通知メールを送信しました。 userId: {}", user.getUserId());
            return true;
        } catch (Exception e) {
            // メール送信に失敗した場合でもログイン処理は継続させる
            logger.error("ログイン通知メール送信エラー", e);
            return false;
        }
    }
}