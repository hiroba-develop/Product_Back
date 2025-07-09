package com.example.Mietoru_Back.service.screenDisplay;

import com.example.Mietoru_Back.entity.NetAsset;
import com.example.Mietoru_Back.entity.Profit;
import com.example.Mietoru_Back.entity.Sale;
import com.example.Mietoru_Back.entity.Task;
import com.example.Mietoru_Back.entity.TaxAccountantComment;
import com.example.Mietoru_Back.model.ApiDashboardGet200Response;
import com.example.Mietoru_Back.repository.netAsset.NetAssetRepository;
import com.example.Mietoru_Back.repository.profit.ProfitRepository;
import com.example.Mietoru_Back.repository.sale.SaleRepository;
import com.example.Mietoru_Back.repository.task.TaskRepository;
import com.example.Mietoru_Back.repository.taxAccountantComment.TaxAccountantCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ダッシュボード画面表示処理を行うサービスクラス
 */
@Service
public class DashboardService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProfitRepository profitRepository;

    @Autowired
    private NetAssetRepository netAssetRepository;

    @Autowired
    private TaxAccountantCommentRepository taxAccountantCommentRepository;

    /**
     * ダッシュボード画面初期表示処理
     * 
     * @param userId ユーザーID（UUID）
     * @return ダッシュボード情報
     */
    public ApiDashboardGet200Response getDashboard(String userId) {
        try {
            ApiDashboardGet200Response response = new ApiDashboardGet200Response();

            // タスクデータを取得（論理削除されていないもののみ）
            List<Task> tasks = taskRepository.findByUserId(userId).stream()
                    .filter(task -> !"1".equals(task.getDelFlg()))
                    .collect(Collectors.toList());

            // 売上データを取得（年月順）
            List<Sale> sales = saleRepository.findByUserIdOrderByYearAscMonthAsc(userId);

            // 利益データを取得（年月順）
            List<Profit> profits = profitRepository.findByUserIdOrderByYearAscMonthAsc(userId);

            // 純資産データを取得（年度順）
            List<NetAsset> netAssets = netAssetRepository.findByUserIdOrderByYearAsc(userId);

            // 税理士コメントデータを取得（年月順）
            List<TaxAccountantComment> taxAccountantComments = taxAccountantCommentRepository
                    .findByUserIdOrderByYearAscMonthAsc(userId);

            // エンティティからモデルへの変換
            List<com.example.Mietoru_Back.model.Task> taskModels = tasks.stream()
                    .map(this::convertToTaskModel)
                    .collect(Collectors.toList());

            List<com.example.Mietoru_Back.model.Sale> saleModels = sales.stream()
                    .map(this::convertToSaleModel)
                    .collect(Collectors.toList());

            List<com.example.Mietoru_Back.model.Profit> profitModels = profits.stream()
                    .map(this::convertToProfitModel)
                    .collect(Collectors.toList());

            List<com.example.Mietoru_Back.model.NetAsset> netAssetModels = netAssets.stream()
                    .map(this::convertToNetAssetModel)
                    .collect(Collectors.toList());

            List<com.example.Mietoru_Back.model.TaxAccountantComment> taxAccountantCommentModels = taxAccountantComments
                    .stream()
                    .map(this::convertToTaxAccountantCommentModel)
                    .collect(Collectors.toList());

            // レスポンスに設定
            response.setResponseStatus(1); // 成功時は1を返却
            response.setTasks(taskModels);
            response.setSales(saleModels);
            response.setProfits(profitModels);
            response.setNetAssets(netAssetModels);
            response.setTaxAccountantComments(taxAccountantCommentModels);

            return response;

        } catch (Exception e) {
            // エラー時の処理
            ApiDashboardGet200Response errorResponse = new ApiDashboardGet200Response();
            errorResponse.setResponseStatus(0); // 失敗時は0を返却
            return errorResponse;
        }
    }

    /**
     * TaskエンティティをTaskモデルに変換
     */
    private com.example.Mietoru_Back.model.Task convertToTaskModel(Task entity) {
        com.example.Mietoru_Back.model.Task model = new com.example.Mietoru_Back.model.Task();
        model.setTaskId(entity.getTaskId());
        model.setUserId(entity.getUserId());
        model.setTaskName(entity.getTaskName());
        model.setNotificationCompleted(entity.getNotificationCompleted());

        // String から NotificationEnabledEnum への変換
        if (entity.getNotificationEnabled() != null) {
            if ("0".equals(entity.getNotificationEnabled())) {
                model.setNotificationEnabled("0");
            } else if ("1".equals(entity.getNotificationEnabled())) {
                model.setNotificationEnabled("1");
            }
        }

        model.setNotificationDay(entity.getNotificationDay());
        // delFlg, createdAt, updatedAtはモデルクラスにないため設定しない
        return model;
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

    /**
     * TaxAccountantCommentエンティティをTaxAccountantCommentモデルに変換
     */
    private com.example.Mietoru_Back.model.TaxAccountantComment convertToTaxAccountantCommentModel(
            TaxAccountantComment entity) {
        com.example.Mietoru_Back.model.TaxAccountantComment model = new com.example.Mietoru_Back.model.TaxAccountantComment();
        model.setTaxAccountantCommentId(entity.getTaxAccountantCommentId());
        model.setUserId(entity.getUserId());
        model.setYear(entity.getYear());
        model.setMonth(entity.getMonth());

        // フィールド名の違いに対応（taxAccountantComment → comment）
        model.setComment(entity.getTaxAccountantComment());

        // String から CommentFlgEnum への変換（taxAccountantCommentFlg → commentFlg）
        if (entity.getTaxAccountantCommentFlg() != null) {
            if ("0".equals(entity.getTaxAccountantCommentFlg())) {
                model.setCommentFlg("0");
            } else if ("1".equals(entity.getTaxAccountantCommentFlg())) {
                model.setCommentFlg("1");
            }
        }

        // createdAt, updatedAtはモデルクラスにないため設定しない
        return model;
    }
}