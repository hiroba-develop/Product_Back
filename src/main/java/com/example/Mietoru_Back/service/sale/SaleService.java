package com.example.Mietoru_Back.service.sale;

import com.example.Mietoru_Back.entity.Sale;
import com.example.Mietoru_Back.model.ApiSaleUpdatePut200Response;
import com.example.Mietoru_Back.model.ApiSaleUpdatePutRequest;
import com.example.Mietoru_Back.repository.sale.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

/**
 * 売上更新処理を行うサービスクラス
 */
@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    /**
     * 売上更新処理
     * 
     * @param request 売上更新リクエスト
     * @return 更新結果
     */
    public ApiSaleUpdatePut200Response updateSale(ApiSaleUpdatePutRequest request) {
        ApiSaleUpdatePut200Response response = new ApiSaleUpdatePut200Response();

        try {
            // リクエストの妥当性チェック
            if (request.getSales() == null || request.getSales().isEmpty()) {
                response.setResponseStatus(0);
                return response;
            }

            // 複数の売上データを処理
            for (com.example.Mietoru_Back.model.Sale saleModel : request.getSales()) {
                if (saleModel.getUserId() == null || saleModel.getYear() == null || saleModel.getMonth() == null) {
                    continue; // 無効なデータはスキップ
                }

                // 既存データの確認
                Optional<Sale> existingSale = saleRepository.findByUserIdAndYearAndMonth(
                        saleModel.getUserId(), saleModel.getYear(), saleModel.getMonth());

                Sale sale;
                if (existingSale.isPresent()) {
                    // 更新
                    sale = existingSale.get();
                    sale.setUpdatedAt(LocalDateTime.now());
                } else {
                    // 新規登録
                    sale = new Sale();
                    sale.setSaleId(UUID.randomUUID().toString());
                    sale.setUserId(saleModel.getUserId());
                    sale.setYear(saleModel.getYear());
                    sale.setMonth(saleModel.getMonth());
                    sale.setCreatedAt(LocalDateTime.now());
                    sale.setUpdatedAt(LocalDateTime.now());
                }

                // リクエストからデータを設定
                if (saleModel.getSaleTarget() != null) {
                    sale.setSaleTarget(saleModel.getSaleTarget().longValue());
                }
                if (saleModel.getSaleResult() != null) {
                    sale.setSaleResult(saleModel.getSaleResult().longValue());
                }

                // 保存
                saleRepository.save(sale);
            }

            response.setResponseStatus(1);

        } catch (Exception e) {
            // エラー発生時
            response.setResponseStatus(0);
        }

        return response;
    }
}