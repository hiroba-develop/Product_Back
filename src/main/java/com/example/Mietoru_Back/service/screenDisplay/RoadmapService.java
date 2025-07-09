package com.example.Mietoru_Back.service.screenDisplay;

import com.example.Mietoru_Back.model.ApiBudgetActualGet200Response;
import com.example.Mietoru_Back.entity.Sale;
import com.example.Mietoru_Back.entity.Profit;
import com.example.Mietoru_Back.entity.NetAsset;
import com.example.Mietoru_Back.repository.sale.SaleRepository;
import com.example.Mietoru_Back.repository.profit.ProfitRepository;
import com.example.Mietoru_Back.repository.netAsset.NetAssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

/**
 * ロードマップ設定画面表示処理を行うサービスクラス
 */
@Service
public class RoadmapService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProfitRepository profitRepository;

    @Autowired
    private NetAssetRepository netAssetRepository;

    /**
     * ロードマップ設定画面初期表示処理
     * 
     * @param userId ユーザーID（UUID）
     * @return ロードマップ情報
     */
    public ApiBudgetActualGet200Response getRoadmap(String userId) {
        try {
            ApiBudgetActualGet200Response response = new ApiBudgetActualGet200Response();

            // 売上データを取得（年月昇順）
            List<Sale> salesList = saleRepository.findByUserIdOrderByYearAscMonthAsc(userId);

            // 利益データを取得（年月昇順）
            List<Profit> profitsList = profitRepository.findByUserIdOrderByYearAscMonthAsc(userId);

            // 純資産データを取得（年度昇順）
            List<NetAsset> netAssetsList = netAssetRepository.findByUserIdOrderByYearAsc(userId);

            // モデルクラスに変換
            List<com.example.Mietoru_Back.model.Sale> modelSales = convertSalesToModel(salesList);
            List<com.example.Mietoru_Back.model.Profit> modelProfits = convertProfitsToModel(profitsList);
            List<com.example.Mietoru_Back.model.NetAsset> modelNetAssets = convertNetAssetsToModel(netAssetsList);

            // レスポンスに設定
            response.setResponseStatus(1); // 成功
            response.setSales(modelSales);
            response.setProfits(modelProfits);
            response.setNetAssets(modelNetAssets);

            return response;

        } catch (Exception e) {
            // エラー時の処理
            ApiBudgetActualGet200Response errorResponse = new ApiBudgetActualGet200Response();
            errorResponse.setResponseStatus(0); // 失敗
            errorResponse.setSales(new ArrayList<>());
            errorResponse.setProfits(new ArrayList<>());
            errorResponse.setNetAssets(new ArrayList<>());
            return errorResponse;
        }
    }

    /**
     * SaleエンティティをモデルクラスのSaleに変換
     * 
     * @param salesList エンティティのSaleリスト
     * @return モデルクラスのSaleリスト
     */
    private List<com.example.Mietoru_Back.model.Sale> convertSalesToModel(List<Sale> salesList) {
        List<com.example.Mietoru_Back.model.Sale> modelSales = new ArrayList<>();

        for (Sale sale : salesList) {
            com.example.Mietoru_Back.model.Sale modelSale = new com.example.Mietoru_Back.model.Sale();
            modelSale.setSaleId(sale.getSaleId());
            modelSale.setUserId(sale.getUserId());
            modelSale.setYear(sale.getYear());
            modelSale.setMonth(sale.getMonth());
            modelSale.setSaleTarget(sale.getSaleTarget() != null ? sale.getSaleTarget().intValue() : null);
            modelSale.setSaleResult(sale.getSaleResult() != null ? sale.getSaleResult().intValue() : null);
            modelSales.add(modelSale);
        }

        return modelSales;
    }

    /**
     * ProfitエンティティをモデルクラスのProfitに変換
     * 
     * @param profitsList エンティティのProfitリスト
     * @return モデルクラスのProfitリスト
     */
    private List<com.example.Mietoru_Back.model.Profit> convertProfitsToModel(List<Profit> profitsList) {
        List<com.example.Mietoru_Back.model.Profit> modelProfits = new ArrayList<>();

        for (Profit profit : profitsList) {
            com.example.Mietoru_Back.model.Profit modelProfit = new com.example.Mietoru_Back.model.Profit();
            modelProfit.setProfitId(profit.getProfitId());
            modelProfit.setUserId(profit.getUserId());
            modelProfit.setYear(profit.getYear());
            modelProfit.setMonth(profit.getMonth());
            modelProfit.setProfitTarget(profit.getProfitTarget() != null ? profit.getProfitTarget().intValue() : null);
            modelProfit.setProfitResult(profit.getProfitResult() != null ? profit.getProfitResult().intValue() : null);
            modelProfits.add(modelProfit);
        }

        return modelProfits;
    }

    /**
     * NetAssetエンティティをモデルクラスのNetAssetに変換
     * 
     * @param netAssetsList エンティティのNetAssetリスト
     * @return モデルクラスのNetAssetリスト
     */
    private List<com.example.Mietoru_Back.model.NetAsset> convertNetAssetsToModel(List<NetAsset> netAssetsList) {
        List<com.example.Mietoru_Back.model.NetAsset> modelNetAssets = new ArrayList<>();

        for (NetAsset netAsset : netAssetsList) {
            com.example.Mietoru_Back.model.NetAsset modelNetAsset = new com.example.Mietoru_Back.model.NetAsset();
            modelNetAsset.setNetAssetId(netAsset.getNetAssetId());
            modelNetAsset.setUserId(netAsset.getUserId());
            modelNetAsset.setYear(netAsset.getYear());
            modelNetAsset.setNetAssetTarget(
                    netAsset.getNetAssetTarget() != null ? netAsset.getNetAssetTarget().intValue() : null);
            modelNetAsset.setNetAssetResult(
                    netAsset.getNetAssetResult() != null ? netAsset.getNetAssetResult().intValue() : null);
            modelNetAssets.add(modelNetAsset);
        }

        return modelNetAssets;
    }
}