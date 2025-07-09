package com.example.Mietoru_Back.service.task;

import com.example.Mietoru_Back.entity.Task;
import com.example.Mietoru_Back.model.ApiTaskRegistrationPost200Response;
import com.example.Mietoru_Back.model.ApiTaskRegistrationPostRequest;
import com.example.Mietoru_Back.repository.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * タスク登録処理を行うサービスクラス
 */
@Service
public class TaskRegistrationService {

    @Autowired
    private TaskRepository taskRepository;

    /**
     * タスク登録処理
     * 
     * @param request タスク登録リクエスト
     * @return 登録結果
     */
    public ApiTaskRegistrationPost200Response registerTask(ApiTaskRegistrationPostRequest request) {
        ApiTaskRegistrationPost200Response response = new ApiTaskRegistrationPost200Response();

        try {
            // リクエストの妥当性チェック
            if (request.getTasks() == null || request.getTasks().isEmpty()) {
                response.setResponseStatus(0);
                return response;
            }

            // 複数のタスクを処理
            for (com.example.Mietoru_Back.model.Task taskModel : request.getTasks()) {
                if (taskModel.getUserId() == null) {
                    continue; // 無効なデータはスキップ
                }

                // 新しいタスクエンティティを作成
                Task task = new Task();
                task.setTaskId(UUID.randomUUID().toString());
                task.setUserId(taskModel.getUserId());
                task.setTaskName(taskModel.getTaskName());
                task.setNotificationCompleted("0");
                task.setNotificationEnabled("0");
                task.setNotificationDay(taskModel.getNotificationDay());
                task.setDelFlg("0");
                task.setCreatedAt(LocalDateTime.now());
                task.setUpdatedAt(LocalDateTime.now());

                // タスクを保存
                taskRepository.save(task);
            }

            response.setResponseStatus(1);

        } catch (Exception e) {
            // エラー発生時
            response.setResponseStatus(0);
        }

        return response;
    }
}