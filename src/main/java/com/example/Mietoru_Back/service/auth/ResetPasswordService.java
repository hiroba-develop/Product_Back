package com.example.Mietoru_Back.service.auth;

import com.example.Mietoru_Back.entity.User;
import com.example.Mietoru_Back.model.ApiAuthResetPasswordPost200Response;
import com.example.Mietoru_Back.model.ApiAuthResetPasswordPostRequest;
import com.example.Mietoru_Back.repository.auth.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ResetPasswordService {

    private static final Logger logger = LoggerFactory.getLogger(ResetPasswordService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenUtil passwordResetTokenUtil;

    /**
     * パスワードをリセットする
     * 
     * @param apiAuthResetPasswordPostRequest リセット要求
     * @return レスポンス
     */
    @Transactional
    public ApiAuthResetPasswordPost200Response resetPassword(
            ApiAuthResetPasswordPostRequest apiAuthResetPasswordPostRequest) {

        ApiAuthResetPasswordPost200Response response = new ApiAuthResetPasswordPost200Response();

        try {
            // トークンを検証し、メールアドレスを取得
            String token = apiAuthResetPasswordPostRequest.getToken();
            String email = passwordResetTokenUtil.validateTokenAndGetEmail(token);

            if (email == null) {
                logger.warn("無効なパスワードリセットトークン: {}", token);
                response.setResponseStatus(0); // 失敗
                return response;
            }

            // ユーザーを検索
            Optional<User> userOpt = userRepository.findByEmail(email);
            if (userOpt.isEmpty()) {
                logger.warn("パスワードリセット: ユーザーが見つかりません。 email: {}", email);
                response.setResponseStatus(0); // 失敗
                return response;
            }

            // パスワードを更新
            User user = userOpt.get();
            user.setPasswordHash(apiAuthResetPasswordPostRequest.getNewPasswordHash());
            user.setUpdatedAt(LocalDateTime.now());

            // ユーザー情報を保存
            userRepository.save(user);

            logger.info("パスワードリセット成功: {}", email);
            response.setResponseStatus(1); // 成功
            return response;

        } catch (Exception e) {
            logger.error("パスワードリセットエラー", e);
            response.setResponseStatus(0); // 失敗
            return response;
        }
    }
}
