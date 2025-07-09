package com.example.Mietoru_Back.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.Mietoru_Back.service.mail.EmailService;
import com.example.Mietoru_Back.model.ApiAuthForgotPasswordPost200Response;
import com.example.Mietoru_Back.model.ApiAuthForgotPasswordPostRequest;
import com.example.Mietoru_Back.repository.auth.UserRepository;
import com.example.Mietoru_Back.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class ForgotPasswordService {

    private static final Logger logger = LoggerFactory.getLogger(ForgotPasswordService.class);

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordResetTokenUtil passwordResetTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @Value("${app.frontend.url}")
    private String frontendUrl;

    public ApiAuthForgotPasswordPost200Response forgotPassword(
            ApiAuthForgotPasswordPostRequest apiAuthForgotPasswordPostRequest) {
        ApiAuthForgotPasswordPost200Response response = new ApiAuthForgotPasswordPost200Response();

        try {
            String email = apiAuthForgotPasswordPostRequest.getEmail();
            logger.info("パスワードリセットメール送信処理: {}", email);

            // メールアドレスでユーザーを検索
            Optional<User> userOpt = userRepository.findByEmail(email);

            // ユーザーが存在しない、またはパスワードハッシュがnullの場合
            if (userOpt.isEmpty() || userOpt.get().getPasswordHash() == null) {
                logger.warn("パスワードリセット失敗: メールアドレスが存在しないか、パスワードハッシュがnullです。email: {}", email);
                response.setResponseStatus(2); // 2: メールアドレスがDBに存在しない
                return response;
            }

            // パスワードリセットメール送信
            sendForgotPasswordEmail(email);

            response.setResponseStatus(1); // 1: 成功
            return response;
        } catch (Exception e) {
            logger.error("パスワードリセット処理でエラーが発生しました", e);
            response.setResponseStatus(0); // 0: 失敗
            return response;
        }
    }

    /**
     * パスワードリセットメールを送信する
     * 
     * @param email ユーザーのメールアドレス
     */
    private boolean sendForgotPasswordEmail(String email) {
        try {
            // ユーザーのメールアドレスを取得
            logger.debug("ユーザーのメールアドレスを取得");
            if (email == null || email.isEmpty()) {
                logger.warn("パスワードリセットメール送信失敗: メールアドレスが設定されていません。 userId: {}", email);
                return false;
            }

            // トークンを生成
            logger.debug("パスワードリセットトークンを生成");
            String token = passwordResetTokenUtil.generateToken(email);

            // リセットURLを生成
            String resetUrl = String.format("%s/reset-password?token=%s", frontendUrl, token);
            logger.debug("パスワードリセットURL: {}", resetUrl);

            // 現在の日時を取得
            logger.debug("現在の日時を取得");
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分");
            String formattedDateTime = now.format(formatter);

            // メールの件名
            logger.debug("メールの件名を設定");
            String subject = "【ミエトル】パスワードリセット通知";

            // メールの本文
            StringBuilder body = new StringBuilder();
            body.append("ミエトルへのパスワードリセットリクエストがありました。\n\n");
            body.append("■リクエスト日時: ").append(formattedDateTime).append("\n\n");
            body.append("下記のURLからパスワードの再設定を行ってください。\n");
            body.append(resetUrl).append("\n\n");
            body.append("※このURLの有効期限は30分です。\n");
            body.append("※このリクエストに心当たりがない場合は、このメールを無視してください。\n");
            body.append("※このメールは自動送信されています。返信はできませんのでご了承ください。");

            // メール送信
            logger.debug("メール送信");
            emailService.sendSimpleEmail(email, subject, body.toString());

            logger.info("パスワードリセットメールを送信しました。 userId: {}", email);
            return true;
        } catch (Exception e) {
            // メール送信に失敗した場合でもログイン処理は継続させる
            logger.error("パスワードリセットメール送信エラー", e);
            return false;
        }
    }
}
