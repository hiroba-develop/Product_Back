package com.example.Mietoru_Back.service.setting;

import com.example.Mietoru_Back.entity.Setting;
import com.example.Mietoru_Back.entity.User;
import com.example.Mietoru_Back.model.ApiSettingUpdatePut200Response;
import com.example.Mietoru_Back.model.ApiSettingUpdatePutRequest;
import com.example.Mietoru_Back.repository.setting.SettingRepository;
import com.example.Mietoru_Back.repository.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

/**
 * 設定内容変更処理を行うサービスクラス
 */
@Service
public class SettingService {

    @Autowired
    private SettingRepository settingRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * 設定内容更新処理
     * 
     * @param request 設定更新リクエスト
     * @return 更新結果
     */
    public ApiSettingUpdatePut200Response updateSetting(ApiSettingUpdatePutRequest request) {
        ApiSettingUpdatePut200Response response = new ApiSettingUpdatePut200Response();

        try {
            // リクエストの妥当性チェック
            if (request.getUserId() == null) {
                response.setResponseStatus(0);
                return response;
            }

            // ユーザー情報の更新
            Optional<User> existingUser = userRepository.findById(request.getUserId());
            if (existingUser.isPresent()) {
                User user = existingUser.get();
                boolean userUpdated = false;

                // name、company、telNoの更新
                if (request.getName() != null) {
                    user.setName(request.getName());
                    userUpdated = true;
                }
                if (request.getCompany() != null) {
                    user.setCompany(request.getCompany());
                    userUpdated = true;
                }
                if (request.getTelNo() != null) {
                    user.setTelNo(request.getTelNo());
                    userUpdated = true;
                }

                if (userUpdated) {
                    user.setUpdatedAt(LocalDateTime.now());
                    userRepository.save(user);
                }
            }

            // 既存設定の確認
            Optional<Setting> existingSetting = settingRepository.findByUserId(request.getUserId());

            Setting setting;
            if (existingSetting.isPresent()) {
                // 更新
                setting = existingSetting.get();
                setting.setUpdatedAt(LocalDateTime.now());
            } else {
                // 新規登録
                setting = new Setting();
                setting.setSettingId(UUID.randomUUID().toString());
                setting.setUserId(request.getUserId());
                setting.setCreatedAt(LocalDateTime.now());
                setting.setUpdatedAt(LocalDateTime.now());
            }

            // リクエストからデータを設定
            if (request.getCompanySize() != null) {
                setting.setCompanySize(request.getCompanySize());
            }
            if (request.getIndustry() != null) {
                setting.setIndustry(request.getIndustry());
            }
            if (request.getFiscalYearStartMonth() != null) {
                setting.setFiscalYearStartMonth(request.getFiscalYearStartMonth());
            }
            if (request.getTotalAssets() != null) {
                setting.setTotalAssets(request.getTotalAssets().longValue());
            }
            if (request.getBusinessExperience() != null) {
                setting.setBusinessExperience(request.getBusinessExperience());
            }
            if (request.getFinancialKnowledge() != null) {
                setting.setFinancialKnowledge(request.getFinancialKnowledge());
            }

            // 保存
            settingRepository.save(setting);

            response.setResponseStatus(1);

        } catch (Exception e) {
            // エラー発生時
            response.setResponseStatus(0);
        }

        return response;
    }
}