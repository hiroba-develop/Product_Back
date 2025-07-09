package com.example.Mietoru_Back.service.netAsset;

import com.example.Mietoru_Back.entity.NetAsset;
import com.example.Mietoru_Back.model.ApiNetAssetUpdatePut200Response;
import com.example.Mietoru_Back.model.ApiNetAssetUpdatePutRequest;
import com.example.Mietoru_Back.repository.netAsset.NetAssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

/**
 * 純利益更新処理を行うサービスクラス
 */
@Service
public class NetAssetService {

    @Autowired
    private NetAssetRepository netAssetRepository;

    /**
     * 純利益更新処理
     * 
     * @param request 純利益更新リクエスト
     * @return 更新結果
     */
    public ApiNetAssetUpdatePut200Response updateNetAsset(ApiNetAssetUpdatePutRequest request) {
        ApiNetAssetUpdatePut200Response response = new ApiNetAssetUpdatePut200Response();

        try {
            // リクエストの妥当性チェック
            if (request.getNetAssets() == null || request.getNetAssets().isEmpty()) {
                response.setResponseStatus(0);
                return response;
            }

            // 複数の純資産データを処理
            for (com.example.Mietoru_Back.model.NetAsset netAssetModel : request.getNetAssets()) {
                if (netAssetModel.getUserId() == null || netAssetModel.getYear() == null) {
                    continue; // 無効なデータはスキップ
                }

                // 既存データの確認
                Optional<NetAsset> existingNetAsset = netAssetRepository.findByUserIdAndYear(
                        netAssetModel.getUserId(), netAssetModel.getYear());

                NetAsset netAsset;
                if (existingNetAsset.isPresent()) {
                    // 更新
                    netAsset = existingNetAsset.get();
                    netAsset.setUpdatedAt(LocalDateTime.now());
                } else {
                    // 新規登録
                    netAsset = new NetAsset();
                    netAsset.setNetAssetId(UUID.randomUUID().toString());
                    netAsset.setUserId(netAssetModel.getUserId());
                    netAsset.setYear(netAssetModel.getYear());
                    netAsset.setCreatedAt(LocalDateTime.now());
                    netAsset.setUpdatedAt(LocalDateTime.now());
                }

                // リクエストからデータを設定
                if (netAssetModel.getNetAssetTarget() != null) {
                    netAsset.setNetAssetTarget(netAssetModel.getNetAssetTarget().longValue());
                }
                if (netAssetModel.getNetAssetResult() != null) {
                    netAsset.setNetAssetResult(netAssetModel.getNetAssetResult().longValue());
                }

                // 保存
                netAssetRepository.save(netAsset);
            }

            response.setResponseStatus(1);

        } catch (Exception e) {
            // エラー発生時
            response.setResponseStatus(0);
        }

        return response;
    }
}