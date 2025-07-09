package com.example.Mietoru_Back.repository.task;

import com.example.Mietoru_Back.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * タスク関連のRepositoryインターフェース
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

    /**
     * ユーザーIDでタスクを検索
     * 
     * @param userId ユーザーID
     * @return タスクのリスト
     */
    List<Task> findByUserId(String userId);

    /**
     * ユーザーIDでタスクを作成日時の昇順で検索
     * 
     * @param userId ユーザーID
     * @return タスクのリスト（作成日時昇順）
     */
    List<Task> findByUserIdOrderByCreatedAtAsc(String userId);

    /**
     * ユーザーIDでタスクを作成日時の降順で検索
     * 
     * @param userId ユーザーID
     * @return タスクのリスト（作成日時降順）
     */
    List<Task> findByUserIdOrderByCreatedAtDesc(String userId);

    /**
     * ユーザーIDと通知有効フラグでタスクを検索
     * 
     * @param userId              ユーザーID
     * @param notificationEnabled 通知有効フラグ
     * @return タスクのリスト
     */
    List<Task> findByUserIdAndNotificationEnabled(String userId, String notificationEnabled);

    /**
     * ユーザーIDと通知日でタスクを検索
     * 
     * @param userId          ユーザーID
     * @param notificationDay 通知日
     * @return タスクのリスト
     */
    List<Task> findByUserIdAndNotificationDay(String userId, Integer notificationDay);

    /**
     * タスク名でタスクを検索（部分一致）
     * 
     * @param userId   ユーザーID
     * @param taskName タスク名
     * @return タスクのリスト
     */
    List<Task> findByUserIdAndTaskNameContaining(String userId, String taskName);

    /**
     * ユーザーIDでタスク数をカウント
     * 
     * @param userId ユーザーID
     * @return タスク数
     */
    long countByUserId(String userId);

    /**
     * タスクIDでタスクを論理削除（delFlgを1に更新）
     * 
     * @param taskId    タスクID
     * @param updatedAt 更新日時
     * @return 更新件数
     */
    @Modifying
    @Transactional
    @Query("UPDATE Task t SET t.delFlg = '1' WHERE t.taskId = :taskId")
    int logicalDeleteByTaskId(@Param("taskId") String taskId);

    /**
     * タスクIDでタスクの存在確認（論理削除されていないもののみ）
     * 
     * @param taskId タスクID
     * @return タスクが存在する場合true
     */
    boolean existsByTaskIdAndDelFlgNot(String taskId, String delFlg);

    /**
     * タスクIDでタスクを取得（論理削除されていないもののみ）
     * 
     * @param taskId タスクID
     * @param delFlg 削除フラグ
     * @return タスク
     */
    Optional<Task> findByTaskIdAndDelFlgNot(String taskId, String delFlg);

    /**
     * すべてのタスクの通知完了フラグを"0"にリセット
     * 
     * @return 更新件数
     */
    @Modifying
    @Transactional
    @Query("UPDATE Task t SET t.notificationCompleted = '0', t.updatedAt = CURRENT_TIMESTAMP WHERE t.delFlg = '0'")
    int resetAllNotificationCompleted();

    /**
     * 特定の通知日のタスクを検索（論理削除されていないもののみ）
     * 
     * @param notificationDay     通知日
     * @param notificationEnabled 通知有効フラグ
     * @param delFlg              削除フラグ
     * @return タスクのリスト
     */
    List<Task> findByNotificationDayAndNotificationEnabledAndDelFlg(
            Integer notificationDay, String notificationEnabled, String delFlg);
}