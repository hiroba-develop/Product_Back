package com.example.Mietoru_Back.service.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.UUID;

@Component
public class PasswordResetTokenUtil {

    private static final Logger logger = LoggerFactory.getLogger(PasswordResetTokenUtil.class);
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    private static final String TOKEN_DELIMITER = "|";

    @Value("${app.password-reset.token.expiration}")
    private int tokenExpirationMinutes;

    /**
     * パスワードリセット用のトークンを生成する
     * 
     * @param email ユーザーのメールアドレス
     * @return 生成されたトークン
     */
    public String generateToken(String email) {
        try {
            // タイムスタンプ生成
            String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMATTER);

            // UUID生成
            String uuid = UUID.randomUUID().toString();

            // プレーン文字列を組み立て
            String plainToken = String.join(TOKEN_DELIMITER, email, timestamp, uuid);

            // Base64エンコード
            return Base64.getEncoder().encodeToString(plainToken.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            logger.error("トークン生成エラー", e);
            throw new RuntimeException("トークン生成に失敗しました", e);
        }
    }

    /**
     * トークンを検証し、含まれるメールアドレスを取得する
     * 
     * @param token 検証するトークン
     * @return トークンに含まれるメールアドレス（トークンが無効な場合はnull）
     */
    public String validateTokenAndGetEmail(String token) {
        try {
            // Base64デコード
            String decodedToken = new String(Base64.getDecoder().decode(token), StandardCharsets.UTF_8);

            // トークンを分解
            String[] parts = decodedToken.split("\\" + TOKEN_DELIMITER);
            if (parts.length != 3) {
                logger.warn("不正なトークン形式: {}", token);
                return null;
            }

            String email = parts[0];
            String timestamp = parts[1];

            // タイムスタンプを検証
            LocalDateTime tokenTime = LocalDateTime.parse(timestamp, TIMESTAMP_FORMATTER);
            LocalDateTime expirationTime = tokenTime.plusMinutes(tokenExpirationMinutes);

            if (LocalDateTime.now().isAfter(expirationTime)) {
                logger.warn("トークンの有効期限切れ: {}", token);
                return null;
            }

            return email;
        } catch (Exception e) {
            logger.error("トークン検証エラー", e);
            return null;
        }
    }
}