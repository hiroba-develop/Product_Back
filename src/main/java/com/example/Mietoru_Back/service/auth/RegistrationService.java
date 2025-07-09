package com.example.Mietoru_Back.service.auth;

import com.example.Mietoru_Back.entity.User;
import com.example.Mietoru_Back.model.ApiAuthRegistrationPostRequest;
import com.example.Mietoru_Back.model.ApiAuthLoginGet200Response;
import com.example.Mietoru_Back.repository.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * ユーザー登録処理を行うサービスクラス
 */
@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    /**
     * ユーザー登録処理（ローカル登録 & Google SSO登録対応）
     * 
     * @param request ユーザー登録リクエスト
     * @return 登録結果
     */
    public ApiAuthLoginGet200Response register(ApiAuthRegistrationPostRequest request) {
        ApiAuthLoginGet200Response response = new ApiAuthLoginGet200Response();

        try {
            // メールアドレスの必須チェック
            if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
                response.setResponseStatus(0);
                return response;
            }

            // GoogleIDまたはパスワードハッシュのどちらかが必須
            boolean isGoogleRegistration = request.getGoogleId() != null && !request.getGoogleId().trim().isEmpty();
            boolean isLocalRegistration = request.getPasswordHash() != null
                    && !request.getPasswordHash().trim().isEmpty();

            if (!isGoogleRegistration && !isLocalRegistration) {
                // どちらも未設定の場合はエラー
                response.setResponseStatus(0);
                return response;
            }

            if (isGoogleRegistration && isLocalRegistration) {
                // 両方設定されている場合もエラー（どちらか一方のみ）
                response.setResponseStatus(0);
                return response;
            }

            // 認証方式に応じた重複チェック
            if (isGoogleRegistration) {
                // Google SSO登録の場合：同じメールアドレス＋Google SSOの組み合わせをチェック
                if (userRepository.existsByEmailAndGoogleIdIsNotNull(request.getEmail())) {
                    response.setResponseStatus(0);
                    return response;
                }
                // GoogleIDの重複チェック
                if (userRepository.existsByGoogleId(request.getGoogleId())) {
                    response.setResponseStatus(0);
                    return response;
                }
            } else {
                // ローカル登録の場合：同じメールアドレス＋ローカル認証の組み合わせをチェック
                if (userRepository.existsByEmailAndPasswordHashIsNotNull(request.getEmail())) {
                    response.setResponseStatus(0);
                    return response;
                }
            }

            // 新しいユーザーエンティティを作成
            User newUser = new User();
            newUser.setUserId(UUID.randomUUID().toString());
            newUser.setEmail(request.getEmail());

            if (isGoogleRegistration) {
                // Google SSO登録の場合
                newUser.setGoogleId(request.getGoogleId());
                newUser.setPasswordHash(null); // Google SSOの場合はパスワード不要
            } else {
                // ローカル登録の場合
                newUser.setPasswordHash(request.getPasswordHash());
                newUser.setGoogleId(null); // ローカル登録の場合はGoogleID不要
            }

            newUser.setName(null); // 初期登録時は未設定
            newUser.setCompany(null); // 初期登録時は未設定
            newUser.setTelNo(null); // 初期登録時は未設定
            newUser.setRole("0"); // 初期登録時は未設定状態
            newUser.setSettingFlg("0"); // 初期登録時は未設定状態
            newUser.setDelFlg("0"); // 削除されていない状態

            // ユーザーをデータベースに保存
            userRepository.save(newUser);

            // 登録成功
            response.setResponseStatus(1);
            response.setUserId(newUser.getUserId());

        } catch (Exception e) {
            // エラー発生時は失敗を返却
            response.setResponseStatus(0);
        }

        return response;
    }
}