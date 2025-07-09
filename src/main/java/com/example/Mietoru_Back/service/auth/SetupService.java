package com.example.Mietoru_Back.service.auth;

import com.example.Mietoru_Back.entity.NetAsset;
import com.example.Mietoru_Back.entity.Profit;
import com.example.Mietoru_Back.entity.Sale;
import com.example.Mietoru_Back.entity.Setting;
import com.example.Mietoru_Back.entity.User;
import com.example.Mietoru_Back.model.ApiAuthSetupPost200Response;
import com.example.Mietoru_Back.model.ApiAuthSetupPostRequest;
import com.example.Mietoru_Back.repository.auth.UserRepository;
import com.example.Mietoru_Back.repository.netAsset.NetAssetRepository;
import com.example.Mietoru_Back.repository.profit.ProfitRepository;
import com.example.Mietoru_Back.repository.sale.SaleRepository;
import com.example.Mietoru_Back.repository.setting.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * 初期設定処理を行うサービスクラス
 */
@Service
public class SetupService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SettingRepository settingRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProfitRepository profitRepository;

    @Autowired
    private NetAssetRepository netAssetRepository;

    /**
     * 初期設定処理
     * 
     * @param request 初期設定リクエスト
     * @return 設定結果
     */
    @Transactional
    public ApiAuthSetupPost200Response setup(ApiAuthSetupPostRequest request) {
        ApiAuthSetupPost200Response response = new ApiAuthSetupPost200Response();

        try {
            // リクエストの妥当性チェック
            if (request.getUserId() == null || request.getUserId().isEmpty()) {
                response.setResponseStatus(0);
                return response;
            }

            // ユーザーの存在確認
            Optional<User> userOptional = userRepository.findById(request.getUserId());
            if (!userOptional.isPresent()) {
                response.setResponseStatus(0);
                return response;
            }

            User user = userOptional.get();

            // Usersテーブルの更新
            if (request.getName() != null) {
                user.setName(request.getName());
            }
            if (request.getCompany() != null) {
                user.setCompany(request.getCompany());
            }
            if (request.getTelNo() != null) {
                user.setTelNo(request.getTelNo());
            }

            // settingFlgを1(設定完了)に更新
            user.setSettingFlg("1");

            // ユーザー情報を保存
            userRepository.save(user);

            // Settingテーブルのデータ追加/更新
            Optional<Setting> existingSetting = settingRepository.findByUserId(request.getUserId());

            Setting setting;
            if (existingSetting.isPresent()) {
                // 既存設定の更新
                setting = existingSetting.get();
                setting.setUpdatedAt(LocalDateTime.now());
            } else {
                // 新規設定の作成
                setting = new Setting();
                setting.setSettingId(UUID.randomUUID().toString());
                setting.setUserId(request.getUserId());
                setting.setCreatedAt(LocalDateTime.now());
                setting.setUpdatedAt(LocalDateTime.now());
            }

            // 設定データの更新
            if (request.getCompanySize() != null) {
                setting.setCompanySize(request.getCompanySize());
            }
            if (request.getIndustry() != null) {
                setting.setIndustry(request.getIndustry());
            }
            if (request.getFiscalYearStartYear() != null) {
                setting.setFiscalYearStartYear(request.getFiscalYearStartYear());
            }
            if (request.getFiscalYearStartMonth() != null) {
                setting.setFiscalYearStartMonth(request.getFiscalYearStartMonth());
            }
            if (request.getTotalAssets() != null) {
                setting.setTotalAssets(request.getTotalAssets().longValue());
            }
            if (request.getBusinessExperience() != null) {
                setting.setBusinessExperience(request.getBusinessExperience());
            }
            if (request.getFinancialKnowledge() != null) {
                setting.setFinancialKnowledge(request.getFinancialKnowledge());
            }

            // 設定情報を保存
            settingRepository.save(setting);

            // 初期データの作成
            createInitialData(request.getUserId(), request.getFiscalYearStartYear(), request.getFiscalYearStartMonth());

            // 成功レスポンス
            response.setResponseStatus(1);

        } catch (Exception e) {
            // エラー発生時
            response.setResponseStatus(0);
        }

        return response;
    }

    /**
     * 初期データ作成処理
     * 
     * @param userId               ユーザーID
     * @param fiscalYearStartYear  事業年度開始年
     * @param fiscalYearStartMonth 事業年度開始月
     */
    private void createInitialData(String userId, Integer fiscalYearStartYear, Integer fiscalYearStartMonth) {
        if (fiscalYearStartYear == null || fiscalYearStartMonth == null) {
            return;
        }

        LocalDateTime now = LocalDateTime.now();

        // 売上テーブルと利益テーブルの初期データ作成（120レコード、10年分の月次データ）
        createSalesAndProfitsData(userId, fiscalYearStartYear, fiscalYearStartMonth, now);

        // 純資産テーブルの初期データ作成（10レコード、10年分の年次データ）
        createNetAssetsData(userId, fiscalYearStartYear, now);
    }

    /**
     * 売上テーブルと利益テーブルの初期データ作成
     * 
     * @param userId               ユーザーID
     * @param fiscalYearStartYear  事業年度開始年
     * @param fiscalYearStartMonth 事業年度開始月
     * @param now                  現在時刻
     */
    private void createSalesAndProfitsData(String userId, Integer fiscalYearStartYear, Integer fiscalYearStartMonth,
            LocalDateTime now) {
        List<Sale> sales = new ArrayList<>();
        List<Profit> profits = new ArrayList<>();

        // 年次別の月間売上目標（万円）
        long[] monthlySaleTargets = { 42L, 83L, 125L, 167L, 250L, 333L, 417L, 542L, 667L, 792L };

        // 年次別の月間利益目標（万円）
        long[] monthlyProfitTargets = { 3L, 5L, 10L, 20L, 30L, 40L, 50L, 70L, 90L, 100L };

        // 10年分（120ヶ月）のデータを作成
        for (int yearOffset = 0; yearOffset < 10; yearOffset++) {
            for (int monthOffset = 0; monthOffset < 12; monthOffset++) {
                int currentYear = fiscalYearStartYear + yearOffset;
                int currentMonth = fiscalYearStartMonth + monthOffset;

                // 月が12を超える場合の年度調整
                if (currentMonth > 12) {
                    currentYear += (currentMonth - 1) / 12;
                    currentMonth = ((currentMonth - 1) % 12) + 1;
                }

                // 売上データ作成
                Sale sale = new Sale();
                sale.setSaleId(UUID.randomUUID().toString());
                sale.setUserId(userId);
                sale.setYear(currentYear);
                sale.setMonth(currentMonth);
                sale.setSaleTarget(monthlySaleTargets[yearOffset] * 10000L); // 万円を円に変換
                sale.setSaleResult(0L);
                sale.setCreatedAt(now);
                sale.setUpdatedAt(now);
                sales.add(sale);

                // 利益データ作成
                Profit profit = new Profit();
                profit.setProfitId(UUID.randomUUID().toString());
                profit.setUserId(userId);
                profit.setYear(currentYear);
                profit.setMonth(currentMonth);
                profit.setProfitTarget(monthlyProfitTargets[yearOffset] * 10000L); // 万円を円に変換
                profit.setProfitResult(0L);
                profit.setCreatedAt(now);
                profit.setUpdatedAt(now);
                profits.add(profit);
            }
        }

        // 一括保存
        saleRepository.saveAll(sales);
        profitRepository.saveAll(profits);
    }

    /**
     * 純資産テーブルの初期データ作成
     * 
     * @param userId              ユーザーID
     * @param fiscalYearStartYear 事業年度開始年
     * @param now                 現在時刻
     */
    private void createNetAssetsData(String userId, Integer fiscalYearStartYear, LocalDateTime now) {
        List<NetAsset> netAssets = new ArrayList<>();

        // 年次別の純資産目標（万円）
        long[] netAssetTargets = { 36L, 96L, 216L, 456L, 816L, 1296L, 1896L, 2736L, 3816L, 5016L };

        // 10年分のデータを作成
        for (int yearOffset = 0; yearOffset < 10; yearOffset++) {
            int currentYear = fiscalYearStartYear + yearOffset;

            NetAsset netAsset = new NetAsset();
            netAsset.setNetAssetId(UUID.randomUUID().toString());
            netAsset.setUserId(userId);
            netAsset.setYear(currentYear);
            netAsset.setNetAssetTarget(netAssetTargets[yearOffset] * 10000L); // 万円を円に変換
            netAsset.setNetAssetResult(0L);
            netAsset.setCreatedAt(now);
            netAsset.setUpdatedAt(now);
            netAssets.add(netAsset);
        }

        // 一括保存
        netAssetRepository.saveAll(netAssets);
    }
}