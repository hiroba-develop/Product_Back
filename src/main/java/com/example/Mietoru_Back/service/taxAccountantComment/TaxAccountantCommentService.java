package com.example.Mietoru_Back.service.taxAccountantComment;

import com.example.Mietoru_Back.entity.TaxAccountantComment;
import com.example.Mietoru_Back.model.ApiTaxAccountantCommentRegistrationPost200Response;
import com.example.Mietoru_Back.model.ApiTaxAccountantCommentRegistrationPostRequest;
import com.example.Mietoru_Back.repository.taxAccountantComment.TaxAccountantCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 税理士コメント登録処理を行うサービスクラス
 */
@Service
public class TaxAccountantCommentService {

    @Autowired
    private TaxAccountantCommentRepository taxAccountantCommentRepository;

    /**
     * 税理士コメント登録処理
     * 
     * @param request 税理士コメント登録リクエスト
     * @return 登録結果
     */
    @Transactional
    public ApiTaxAccountantCommentRegistrationPost200Response registerTaxAccountantComment(
            ApiTaxAccountantCommentRegistrationPostRequest request) {
        ApiTaxAccountantCommentRegistrationPost200Response response = new ApiTaxAccountantCommentRegistrationPost200Response();

        try {
            List<com.example.Mietoru_Back.model.TaxAccountantComment> responseComments = new ArrayList<>();
            LocalDateTime now = LocalDateTime.now();

            // リクエストからの税理士コメントリストを処理
            for (com.example.Mietoru_Back.model.TaxAccountantComment requestComment : request
                    .getTaxAccountantComments()) {
                // エンティティに変換
                TaxAccountantComment entity = new TaxAccountantComment();

                // IDがない場合は新規作成
                if (requestComment.getTaxAccountantCommentId() == null
                        || requestComment.getTaxAccountantCommentId().isEmpty()) {
                    entity.setTaxAccountantCommentId(UUID.randomUUID().toString());
                } else {
                    entity.setTaxAccountantCommentId(requestComment.getTaxAccountantCommentId());
                }

                entity.setUserId(requestComment.getUserId());
                entity.setYear(requestComment.getYear());
                entity.setMonth(requestComment.getMonth());
                entity.setTaxAccountantComment(requestComment.getComment());
                entity.setTaxAccountantCommentFlg(requestComment.getCommentFlg());
                entity.setCreatedAt(now);
                entity.setUpdatedAt(now);

                // 保存
                TaxAccountantComment savedEntity = taxAccountantCommentRepository.save(entity);

                // レスポンス用のモデルに変換
                com.example.Mietoru_Back.model.TaxAccountantComment responseComment = new com.example.Mietoru_Back.model.TaxAccountantComment();
                responseComment.setTaxAccountantCommentId(savedEntity.getTaxAccountantCommentId());
                responseComment.setUserId(savedEntity.getUserId());
                responseComment.setYear(savedEntity.getYear());
                responseComment.setMonth(savedEntity.getMonth());
                responseComment.setComment(savedEntity.getTaxAccountantComment());
                responseComment.setCommentFlg(savedEntity.getTaxAccountantCommentFlg());

                responseComments.add(responseComment);
            }

            // レスポンスを設定
            response.setResponseStatus(1); // 成功
            response.setTaxAccountantComments(responseComments);

        } catch (Exception e) {
            // エラー時の処理
            response.setResponseStatus(0); // 失敗
        }

        return response;
    }
}