package com.example.Mietoru_Back.service.screenDisplay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Mietoru_Back.entity.Setting;
import com.example.Mietoru_Back.entity.Task;
import com.example.Mietoru_Back.entity.User;
import com.example.Mietoru_Back.model.ApiSettingGet200Response;
import com.example.Mietoru_Back.repository.auth.UserRepository;
import com.example.Mietoru_Back.repository.setting.SettingRepository;
import com.example.Mietoru_Back.repository.task.TaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 設定画面表示用のサービスクラス
 */
@Service
public class SettingsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SettingRepository settingRepository;

    @Autowired
    private TaskRepository taskRepository;

    /**
     * 設定画面初期表示データを取得
     * 
     * @param userId ユーザーID
     * @return 設定画面表示データ
     */
    public ApiSettingGet200Response getSetting(String userId) {
        ApiSettingGet200Response response = new ApiSettingGet200Response();

        try {
            // ユーザー情報の取得
            Optional<User> userOptional = userRepository.findById(userId);
            if (!userOptional.isPresent()) {
                response.setResponseStatus(0);
                return response;
            }

            User user = userOptional.get();

            // 設定情報の取得
            Optional<Setting> settingOptional = settingRepository.findByUserId(userId);

            // タスク情報の取得
            List<Task> taskList = taskRepository.findByUserIdOrderByCreatedAtAsc(userId);

            // レスポンスの構築
            response.setResponseStatus(1);
            response.setUserId(user.getUserId());
            response.setName(user.getName());
            response.setCompany(user.getCompany());
            response.setTelNo(user.getTelNo());

            // 設定情報がある場合は設定
            if (settingOptional.isPresent()) {
                Setting setting = settingOptional.get();
                response.setCompanySize(setting.getCompanySize());
                response.setIndustry(setting.getIndustry());
                response.setFiscalYearStartYear(setting.getFiscalYearStartYear());
                response.setFiscalYearStartMonth(setting.getFiscalYearStartMonth());
                response.setTotalAssets(setting.getTotalAssets() != null ? setting.getTotalAssets().intValue() : null);
                response.setBusinessExperience(setting.getBusinessExperience());
                response.setFinancialKnowledge(setting.getFinancialKnowledge());
            }

            // タスク情報の設定
            if (taskList != null && !taskList.isEmpty()) {
                List<com.example.Mietoru_Back.model.Task> modelTasks = new ArrayList<>();
                for (Task entityTask : taskList) {
                    com.example.Mietoru_Back.model.Task modelTask = new com.example.Mietoru_Back.model.Task();
                    modelTask.setTaskId(entityTask.getTaskId());
                    modelTask.setUserId(entityTask.getUserId());
                    modelTask.setTaskName(entityTask.getTaskName());

                    // notificationEnabledの変換（String → Enum）
                    if (entityTask.getNotificationEnabled() != null) {
                        if ("1".equals(entityTask.getNotificationEnabled())) {
                            modelTask.setNotificationEnabled("1");
                        } else {
                            modelTask.setNotificationEnabled("0");
                        }
                    }

                    modelTask.setNotificationDay(entityTask.getNotificationDay());
                    modelTasks.add(modelTask);
                }
                response.setTasks(modelTasks);
            } else {
                response.setTasks(new ArrayList<>());
            }

        } catch (Exception e) {
            // エラー発生時
            response.setResponseStatus(0);
        }

        return response;
    }
}
