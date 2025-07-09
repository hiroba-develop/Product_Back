package com.example.Mietoru_Back.controller;

import com.example.Mietoru_Back.model.*;
import com.example.Mietoru_Back.service.auth.LoginService;
import com.example.Mietoru_Back.service.auth.ResetPasswordService;
import com.example.Mietoru_Back.service.auth.ForgotPasswordService;
import com.example.Mietoru_Back.service.auth.RegistrationService;
import com.example.Mietoru_Back.service.auth.SetupService;
import com.example.Mietoru_Back.service.netAsset.NetAssetService;
import com.example.Mietoru_Back.service.profit.ProfitService;
import com.example.Mietoru_Back.service.sale.SaleService;
import com.example.Mietoru_Back.service.screenDisplay.BudgetActualService;
import com.example.Mietoru_Back.service.screenDisplay.DashboardService;
import com.example.Mietoru_Back.service.screenDisplay.RoadmapService;
import com.example.Mietoru_Back.service.screenDisplay.TaxAccountantService;
import com.example.Mietoru_Back.service.screenDisplay.SettingsService;
import com.example.Mietoru_Back.service.setting.SettingService;
import com.example.Mietoru_Back.service.task.TaskDeleteService;
import com.example.Mietoru_Back.service.task.TaskRegistrationService;
import com.example.Mietoru_Back.service.task.TaskUpdateService;
import com.example.Mietoru_Back.service.taxAccountantComment.TaxAccountantCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DefaultApiインターフェースの実装クラス
 * 各APIエンドポイントを対応するサービスクラスに委譲します
 */
@RestController
public class DefaultApiController implements DefaultApi {

    private static final Logger logger = LoggerFactory.getLogger(DefaultApiController.class);

    @Autowired
    private LoginService loginService;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private SetupService setupService;

    @Autowired
    private ForgotPasswordService forgotPasswordService;

    @Autowired
    private ResetPasswordService resetPasswordService;

    @Autowired
    private BudgetActualService budgetActualService;

    @Autowired
    private DashboardService dashboardService;

    @Autowired
    private RoadmapService roadmapService;

    @Autowired
    private TaxAccountantService taxAccountantService;

    @Autowired
    private NetAssetService netAssetService;

    @Autowired
    private ProfitService profitService;

    @Autowired
    private SaleService saleService;

    @Autowired
    private SettingService settingService;

    @Autowired
    private TaskDeleteService taskDeleteService;

    @Autowired
    private TaskRegistrationService taskRegistrationService;

    @Autowired
    private TaskUpdateService taskUpdateService;

    @Autowired
    private TaxAccountantCommentService taxAccountantCommentService;

    @Autowired
    private SettingsService settingsService;

    // =============================================================
    // 認証関連API
    // =============================================================

    /**
     * GET /api/auth/login - ユーザーログイン
     */
    @Override
    public ResponseEntity<ApiAuthLoginGet200Response> apiAuthLoginGet(
            String email, String passwordHash, String googleId) {
        logger.debug("ログインAPI呼び出し - email: {}, googleIdあり: {}", email, (googleId != null && !googleId.isEmpty()));
        ApiAuthLoginGet200Response response = loginService.login(email, passwordHash, googleId);
        return ResponseEntity.ok(response);
    }

    /**
     * POST /api/auth/registration - ユーザー登録
     */
    @Override
    public ResponseEntity<ApiAuthLoginGet200Response> apiAuthRegistrationPost(
            ApiAuthRegistrationPostRequest apiAuthRegistrationPostRequest) {
        logger.debug("ユーザー登録API呼び出し - email: {}", apiAuthRegistrationPostRequest.getEmail());
        ApiAuthLoginGet200Response response = registrationService.register(apiAuthRegistrationPostRequest);
        return ResponseEntity.ok(response);
    }

    /**
     * POST /api/auth/setup - 初期設定
     */
    @Override
    public ResponseEntity<ApiAuthSetupPost200Response> apiAuthSetupPost(
            ApiAuthSetupPostRequest apiAuthSetupPostRequest) {
        ApiAuthSetupPost200Response response = setupService.setup(apiAuthSetupPostRequest);
        return ResponseEntity.ok(response);
    }

    /**
     * POST /api/auth/forgotPassword - パスワード再送信
     */
    @Override
    public ResponseEntity<ApiAuthForgotPasswordPost200Response> apiAuthForgotPasswordPost(
            ApiAuthForgotPasswordPostRequest apiAuthForgotPasswordPostRequest) {
        ApiAuthForgotPasswordPost200Response response = forgotPasswordService
                .forgotPassword(apiAuthForgotPasswordPostRequest);
        return ResponseEntity.ok(response);
    }

    /**
     * POST /api/auth/resetPassword - パスワードリセット
     */
    @Override
    public ResponseEntity<ApiAuthResetPasswordPost200Response> apiAuthResetPasswordPost(
            ApiAuthResetPasswordPostRequest apiAuthResetPasswordPostRequest) {
        ApiAuthResetPasswordPost200Response response = resetPasswordService
                .resetPassword(apiAuthResetPasswordPostRequest);
        return ResponseEntity.ok(response);
    }

    // =============================================================
    // 画面表示関連API
    // =============================================================

    /**
     * GET /api/dashboard - ダッシュボード画面初期表示
     */
    @Override
    public ResponseEntity<ApiDashboardGet200Response> apiDashboardGet(String userId) {
        ApiDashboardGet200Response response = dashboardService.getDashboard(userId);
        return ResponseEntity.ok(response);
    }

    /**
     * GET /api/budgetActual - 予実管理画面初期表示
     */
    @Override
    public ResponseEntity<ApiBudgetActualGet200Response> apiBudgetActualGet(String userId) {
        ApiBudgetActualGet200Response response = budgetActualService.getBudgetActual(userId);
        return ResponseEntity.ok(response);
    }

    /**
     * GET /api/roadmap - ロードマップ設定画面初期表示
     */
    @Override
    public ResponseEntity<ApiBudgetActualGet200Response> apiRoadmapGet(String userId) {
        ApiBudgetActualGet200Response response = roadmapService.getRoadmap(userId);
        return ResponseEntity.ok(response);
    }

    /**
     * GET /api/taxAccountant - クライアント管理画面初期表示
     */
    @Override
    public ResponseEntity<ApiTaxAccountantGet200Response> apiTaxAccountantGet() {
        ApiTaxAccountantGet200Response response = taxAccountantService.getTaxAccountant();
        return ResponseEntity.ok(response);
    }

    /**
     * GET /api/setting - 設定画面初期表示
     */
    @Override
    public ResponseEntity<ApiSettingGet200Response> apiSettingGet(String userId) {
        ApiSettingGet200Response response = settingsService.getSetting(userId);
        return ResponseEntity.ok(response);
    }

    // =============================================================
    // データ更新関連API
    // =============================================================

    /**
     * PUT /api/netAsset/update - 純利益更新
     */
    @Override
    public ResponseEntity<ApiNetAssetUpdatePut200Response> apiNetAssetUpdatePut(
            ApiNetAssetUpdatePutRequest apiNetAssetUpdatePutRequest) {
        ApiNetAssetUpdatePut200Response response = netAssetService.updateNetAsset(apiNetAssetUpdatePutRequest);
        return ResponseEntity.ok(response);
    }

    /**
     * PUT /api/profit/update - 利益更新
     */
    @Override
    public ResponseEntity<ApiProfitUpdatePut200Response> apiProfitUpdatePut(
            ApiProfitUpdatePutRequest apiProfitUpdatePutRequest) {
        ApiProfitUpdatePut200Response response = profitService.updateProfit(apiProfitUpdatePutRequest);
        return ResponseEntity.ok(response);
    }

    /**
     * PUT /api/sale/update - 売上更新
     */
    @Override
    public ResponseEntity<ApiSaleUpdatePut200Response> apiSaleUpdatePut(
            ApiSaleUpdatePutRequest apiSaleUpdatePutRequest) {
        ApiSaleUpdatePut200Response response = saleService.updateSale(apiSaleUpdatePutRequest);
        return ResponseEntity.ok(response);
    }

    /**
     * PUT /api/setting/update - 設定内容変更
     */
    @Override
    public ResponseEntity<ApiSettingUpdatePut200Response> apiSettingUpdatePut(
            ApiSettingUpdatePutRequest apiSettingUpdatePutRequest) {
        ApiSettingUpdatePut200Response response = settingService.updateSetting(apiSettingUpdatePutRequest);
        return ResponseEntity.ok(response);
    }

    // =============================================================
    // タスク管理関連API
    // =============================================================

    /**
     * POST /api/task/registration - タスク登録
     */
    @Override
    public ResponseEntity<ApiTaskRegistrationPost200Response> apiTaskRegistrationPost(
            ApiTaskRegistrationPostRequest apiTaskRegistrationPostRequest) {
        ApiTaskRegistrationPost200Response response = taskRegistrationService
                .registerTask(apiTaskRegistrationPostRequest);
        return ResponseEntity.ok(response);
    }

    /**
     * PUT /api/task/update - タスク更新
     */
    @Override
    public ResponseEntity<ApiTaskRegistrationPost200Response> apiTaskUpdatePut(
            ApiTaskRegistrationPostRequest apiTaskRegistrationPostRequest) {
        ApiTaskRegistrationPost200Response response = taskUpdateService.updateTask(apiTaskRegistrationPostRequest);
        return ResponseEntity.ok(response);
    }

    /**
     * DELETE /api/task/delete - タスク削除
     */
    @Override
    public ResponseEntity<ApiAuthSetupPost200Response> apiTaskDeleteDelete(String taskId) {
        ApiAuthSetupPost200Response response = taskDeleteService.deleteTask(taskId);
        return ResponseEntity.ok(response);
    }

    // =============================================================
    // 税理士コメント関連API
    // =============================================================

    /**
     * POST /api/taxAccountantComment/registration - 税理士コメント登録
     */
    @Override
    public ResponseEntity<ApiTaxAccountantCommentRegistrationPost200Response> apiTaxAccountantCommentRegistrationPost(
            ApiTaxAccountantCommentRegistrationPostRequest apiTaxAccountantCommentRegistrationPostRequest) {
        ApiTaxAccountantCommentRegistrationPost200Response response = taxAccountantCommentService
                .registerTaxAccountantComment(apiTaxAccountantCommentRegistrationPostRequest);
        return ResponseEntity.ok(response);
    }
}