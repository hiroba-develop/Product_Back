package com.example.Mietoru_Back.service.profit;

import com.example.Mietoru_Back.entity.Profit;
import com.example.Mietoru_Back.model.ApiProfitUpdatePut200Response;
import com.example.Mietoru_Back.model.ApiProfitUpdatePutRequest;
import com.example.Mietoru_Back.repository.profit.ProfitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

/**
 * 利益更新処理を行うサービスクラス
 */
@Service
public class ProfitService {

    @Autowired
    private ProfitRepository profitRepository;

    /**
     * 利益更新処理
     * 
     * @param request 利益更新リクエスト
     * @return 更新結果
     */
    public ApiProfitUpdatePut200Response updateProfit(ApiProfitUpdatePutRequest request) {
        ApiProfitUpdatePut200Response response = new ApiProfitUpdatePut200Response();

        try {
            // リクエストの妥当性チェック
            if (request.getProfits() == null || request.getProfits().isEmpty()) {
                response.setResponseStatus(0);
                return response;
            }

            // 複数の利益データを処理
            for (com.example.Mietoru_Back.model.Profit profitModel : request.getProfits()) {
                if (profitModel.getUserId() == null || profitModel.getYear() == null
                        || profitModel.getMonth() == null) {
                    continue; // 無効なデータはスキップ
                }

                // 既存データの確認
                Optional<Profit> existingProfit = profitRepository.findByUserIdAndYearAndMonth(
                        profitModel.getUserId(), profitModel.getYear(), profitModel.getMonth());

                Profit profit;
                if (existingProfit.isPresent()) {
                    // 更新
                    profit = existingProfit.get();
                    profit.setUpdatedAt(LocalDateTime.now());
                } else {
                    // 新規登録
                    profit = new Profit();
                    profit.setProfitId(UUID.randomUUID().toString());
                    profit.setUserId(profitModel.getUserId());
                    profit.setYear(profitModel.getYear());
                    profit.setMonth(profitModel.getMonth());
                    profit.setCreatedAt(LocalDateTime.now());
                    profit.setUpdatedAt(LocalDateTime.now());
                }

                // リクエストからデータを設定
                if (profitModel.getProfitTarget() != null) {
                    profit.setProfitTarget(profitModel.getProfitTarget().longValue());
                }
                if (profitModel.getProfitResult() != null) {
                    profit.setProfitResult(profitModel.getProfitResult().longValue());
                }

                // 保存
                profitRepository.save(profit);
            }

            response.setResponseStatus(1);

        } catch (Exception e) {
            // エラー発生時
            response.setResponseStatus(0);
        }

        return response;
    }
}