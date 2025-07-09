package com.example.Mietoru_Back.service.task;

import com.example.Mietoru_Back.model.ApiAuthSetupPost200Response;
import com.example.Mietoru_Back.repository.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * タスク削除処理を行うサービスクラス
 */
@Service
public class TaskDeleteService {

    @Autowired
    private TaskRepository taskRepository;

    /**
     * タスク削除処理
     * 
     * @param taskId タスクID（UUID）
     * @return 削除結果
     */
    public ApiAuthSetupPost200Response deleteTask(String taskId) {
        ApiAuthSetupPost200Response response = new ApiAuthSetupPost200Response();

        try {
            // 論理削除を実行（delFlgを1に更新）
            int updatedCount = taskRepository.logicalDeleteByTaskId(taskId);

            if (updatedCount > 0) {
                // 削除成功
                response.setResponseStatus(1);
            } else {
                // 削除失敗
                response.setResponseStatus(0);
            }

        } catch (Exception e) {
            // エラー発生時は失敗ステータスを返す
            response.setResponseStatus(0);
        }

        return response;
    }
}