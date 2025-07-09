package com.example.Mietoru_Back.service.task;

import com.example.Mietoru_Back.entity.Task;
import com.example.Mietoru_Back.model.ApiTaskRegistrationPost200Response;
import com.example.Mietoru_Back.model.ApiTaskRegistrationPostRequest;
import com.example.Mietoru_Back.repository.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * タスク更新処理を行うサービスクラス
 */
@Service
public class TaskUpdateService {

    @Autowired
    private TaskRepository taskRepository;

    /**
     * タスク更新処理
     * 
     * @param request タスク更新リクエスト
     * @return 更新結果
     */
    public ApiTaskRegistrationPost200Response updateTask(ApiTaskRegistrationPostRequest request) {
        ApiTaskRegistrationPost200Response response = new ApiTaskRegistrationPost200Response();
        List<com.example.Mietoru_Back.model.Task> updatedTasks = new ArrayList<>();

        try {
            for (com.example.Mietoru_Back.model.Task taskModel : request.getTasks()) {
                // タスクIDが存在し、論理削除されていないことを確認
                Optional<Task> existingTaskOpt = taskRepository.findByTaskIdAndDelFlgNot(taskModel.getTaskId(), "1");

                if (existingTaskOpt.isPresent()) {
                    Task existingTask = existingTaskOpt.get();

                    // 更新対象のフィールドを設定（taskIdは更新しない）
                    if (taskModel.getTaskName() != null) {
                        existingTask.setTaskName(taskModel.getTaskName());
                    }
                    if (taskModel.getNotificationCompleted() != null) {
                        existingTask.setNotificationCompleted(taskModel.getNotificationCompleted());
                    }
                    if (taskModel.getNotificationEnabled() != null) {
                        existingTask.setNotificationEnabled(taskModel.getNotificationEnabled());
                    }
                    if (taskModel.getNotificationDay() != null) {
                        existingTask.setNotificationDay(taskModel.getNotificationDay());
                    }

                    // データベースに保存
                    Task savedTask = taskRepository.save(existingTask);

                    // レスポンス用のTaskモデルに変換
                    com.example.Mietoru_Back.model.Task responseTask = convertToModelTask(savedTask);
                    updatedTasks.add(responseTask);
                } else {
                    // タスクが存在しない場合は失敗を返す
                    response.setResponseStatus(0);
                    return response;
                }
            }

            // 成功時のレスポンス設定
            response.setResponseStatus(1);
            response.setTasks(updatedTasks);

        } catch (Exception e) {
            // エラー発生時は失敗ステータスを返す
            response.setResponseStatus(0);
        }

        return response;
    }

    /**
     * エンティティのTaskをモデルのTaskに変換
     * 
     * @param entityTask エンティティのTask
     * @return モデルのTask
     */
    private com.example.Mietoru_Back.model.Task convertToModelTask(Task entityTask) {
        com.example.Mietoru_Back.model.Task modelTask = new com.example.Mietoru_Back.model.Task();
        modelTask.setTaskId(entityTask.getTaskId());
        modelTask.setUserId(entityTask.getUserId());
        modelTask.setTaskName(entityTask.getTaskName());

        modelTask.setNotificationCompleted(entityTask.getNotificationCompleted());
        modelTask.setNotificationEnabled(entityTask.getNotificationEnabled());

        modelTask.setNotificationDay(entityTask.getNotificationDay());
        return modelTask;
    }
}