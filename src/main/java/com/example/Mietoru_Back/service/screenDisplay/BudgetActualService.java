package com.example.Mietoru_Back.service.screenDisplay;

import com.example.Mietoru_Back.entity.NetAsset;
import com.example.Mietoru_Back.entity.Profit;
import com.example.Mietoru_Back.entity.Sale;
import com.example.Mietoru_Back.model.ApiBudgetActualGet200Response;
import com.example.Mietoru_Back.repository.netAsset.NetAssetRepository;
import com.example.Mietoru_Back.repository.profit.ProfitRepository;
import com.example.Mietoru_Back.repository.sale.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 予実管理画面表示処理を行うサービスクラス
 */
@Service
public class BudgetActualService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProfitRepository profitRepository;

    @Autowired
    private NetAssetRepository netAssetRepository;

    /**
     * 予実管理画面初期表示処理
     * 
     * @param userId ユーザーID（UUID）
     * @return 予実管理情報
     */
    public ApiBudgetActualGet200Response getBudgetActual(String userId) {
        ApiBudgetActualGet200Response response = new ApiBudgetActualGet200Response();

        System.out.println("userId: " + userId);
        try {
            // 売上データを取得（年月順）
            List<Sale> sales = saleRepository.findByUserIdOrderByYearAscMonthAsc(userId);

            // 利益データを取得（年月順）
            List<Profit> profits = profitRepository.findByUserIdOrderByYearAscMonthAsc(userId);

            // 純資産データを取得（年度順）
            List<NetAsset> netAssets = netAssetRepository.findByUserIdOrderByYearAsc(userId);

            List<com.example.Mietoru_Back.model.Sale> saleModels = sales.stream()
                    .map(this::convertToSaleModel)
                    .collect(Collectors.toList());

            List<com.example.Mietoru_Back.model.Profit> profitModels = profits.stream()
                    .map(this::convertToProfitModel)
                    .collect(Collectors.toList());

            List<com.example.Mietoru_Back.model.NetAsset> netAssetModels = netAssets.stream()
                    .map(this::convertToNetAssetModel)
                    .collect(Collectors.toList());

            // レスポンスに設定
            response.setSales(saleModels);
            response.setProfits(profitModels);
            response.setNetAssets(netAssetModels);
            response.setResponseStatus(1); // 成功

        } catch (Exception e) {
            // エラー発生時
            response.setResponseStatus(0); // 失敗
        }

        return response;
    }

    /**
     * SaleエンティティをSaleモデルに変換
     */
    private com.example.Mietoru_Back.model.Sale convertToSaleModel(Sale entity) {
        com.example.Mietoru_Back.model.Sale model = new com.example.Mietoru_Back.model.Sale();
        model.setSaleId(entity.getSaleId());
        model.setUserId(entity.getUserId());
        model.setYear(entity.getYear());
        model.setMonth(entity.getMonth());

        // Long から Integer への変換
        if (entity.getSaleTarget() != null) {
            model.setSaleTarget(entity.getSaleTarget().intValue());
        }
        if (entity.getSaleResult() != null) {
            model.setSaleResult(entity.getSaleResult().intValue());
        }

        // createdAt, updatedAtはモデルクラスにないため設定しない
        return model;
    }

    /**
     * ProfitエンティティをProfitモデルに変換
     */
    private com.example.Mietoru_Back.model.Profit convertToProfitModel(Profit entity) {
        com.example.Mietoru_Back.model.Profit model = new com.example.Mietoru_Back.model.Profit();
        model.setProfitId(entity.getProfitId());
        model.setUserId(entity.getUserId());
        model.setYear(entity.getYear());
        model.setMonth(entity.getMonth());

        // Long から Integer への変換
        if (entity.getProfitTarget() != null) {
            model.setProfitTarget(entity.getProfitTarget().intValue());
        }
        if (entity.getProfitResult() != null) {
            model.setProfitResult(entity.getProfitResult().intValue());
        }

        // createdAt, updatedAtはモデルクラスにないため設定しない
        return model;
    }

    /**
     * NetAssetエンティティをNetAssetモデルに変換
     */
    private com.example.Mietoru_Back.model.NetAsset convertToNetAssetModel(NetAsset entity) {
        com.example.Mietoru_Back.model.NetAsset model = new com.example.Mietoru_Back.model.NetAsset();
        model.setNetAssetId(entity.getNetAssetId());
        model.setUserId(entity.getUserId());
        model.setYear(entity.getYear());

        // Long から Integer への変換
        if (entity.getNetAssetTarget() != null) {
            model.setNetAssetTarget(entity.getNetAssetTarget().intValue());
        }
        if (entity.getNetAssetResult() != null) {
            model.setNetAssetResult(entity.getNetAssetResult().intValue());
        }

        // createdAt, updatedAtはモデルクラスにないため設定しない
        return model;
    }
}