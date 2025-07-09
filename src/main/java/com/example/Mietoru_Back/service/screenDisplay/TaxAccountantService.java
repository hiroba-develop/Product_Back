package com.example.Mietoru_Back.service.screenDisplay;

import com.example.Mietoru_Back.entity.Profit;
import com.example.Mietoru_Back.entity.Sale;
import com.example.Mietoru_Back.entity.Setting;
import com.example.Mietoru_Back.entity.TaxAccountantComment;
import com.example.Mietoru_Back.entity.User;
import com.example.Mietoru_Back.model.AdminUserInfo;
import com.example.Mietoru_Back.model.ApiTaxAccountantGet200Response;
import com.example.Mietoru_Back.model.CommentHistory;
import com.example.Mietoru_Back.repository.auth.UserRepository;
import com.example.Mietoru_Back.repository.profit.ProfitRepository;
import com.example.Mietoru_Back.repository.sale.SaleRepository;
import com.example.Mietoru_Back.repository.setting.SettingRepository;
import com.example.Mietoru_Back.repository.taxAccountantComment.TaxAccountantCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * クライアント管理画面表示処理を行うサービスクラス
 */
@Service
public class TaxAccountantService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaxAccountantCommentRepository taxAccountantCommentRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProfitRepository profitRepository;

    @Autowired
    private SettingRepository settingRepository;

    /**
     * クライアント管理画面初期表示処理
     * 
     * @return クライアント管理情報
     */
    public ApiTaxAccountantGet200Response getTaxAccountant() {
        ApiTaxAccountantGet200Response response = new ApiTaxAccountantGet200Response();
        List<AdminUserInfo> userInfoList = new ArrayList<>();

        try {
            // 有効なユーザー（削除フラグが0）を全て取得
            List<User> users = userRepository.findAll().stream()
                    .filter(user -> "0".equals(user.getDelFlg()))
                    .collect(Collectors.toList());

            // 現在の年月を取得
            YearMonth currentYearMonth = YearMonth.now();
            int currentYear = currentYearMonth.getYear();
            int currentMonth = currentYearMonth.getMonthValue();

            // 先月の年月を取得
            YearMonth lastYearMonth = currentYearMonth.minusMonths(1);
            int lastYear = lastYearMonth.getYear();
            int lastMonth = lastYearMonth.getMonthValue();

            for (User user : users) {
                AdminUserInfo userInfo = new AdminUserInfo();

                // ユーザー基本情報を設定
                userInfo.setUserId(user.getUserId());
                userInfo.setUserName(user.getName());
                userInfo.setEmail(user.getEmail());
                userInfo.setBusinessName(user.getCompany());
                userInfo.setLastUpdated(user.getUpdatedAt());

                // 設定情報から決算月を取得
                Optional<Setting> settingOpt = settingRepository.findByUserId(user.getUserId());
                if (settingOpt.isPresent()) {
                    Setting setting = settingOpt.get();
                    userInfo.setFiscalYearEndMonth(
                            setting.getFiscalYearStartMonth() == 1 ? 12 : setting.getFiscalYearStartMonth() - 1);
                }

                // 先月の売上・利益データを取得
                Optional<Sale> lastMonthSaleOpt = saleRepository.findByUserIdAndYearAndMonth(user.getUserId(), lastYear,
                        lastMonth);
                Optional<Profit> lastMonthProfitOpt = profitRepository.findByUserIdAndYearAndMonth(user.getUserId(),
                        lastYear, lastMonth);

                if (lastMonthSaleOpt.isPresent()) {
                    Sale lastMonthSale = lastMonthSaleOpt.get();
                    userInfo.setLastMonthSalesTarget(
                            lastMonthSale.getSaleTarget() != null ? lastMonthSale.getSaleTarget().intValue() : 0);
                    userInfo.setLastMonthSalesActual(
                            lastMonthSale.getSaleResult() != null ? lastMonthSale.getSaleResult().intValue() : 0);

                    // 達成率を計算（目標が0の場合は0とする）
                    if (lastMonthSale.getSaleTarget() != null && lastMonthSale.getSaleTarget() > 0
                            && lastMonthSale.getSaleResult() != null) {
                        float achievementRate = (float) lastMonthSale.getSaleResult() / lastMonthSale.getSaleTarget()
                                * 100;
                        userInfo.setLastMonthSalesAchievementRate(achievementRate);
                    } else {
                        userInfo.setLastMonthSalesAchievementRate(0f);
                    }
                }

                if (lastMonthProfitOpt.isPresent()) {
                    Profit lastMonthProfit = lastMonthProfitOpt.get();
                    userInfo.setLastMonthProfitTarget(
                            lastMonthProfit.getProfitTarget() != null ? lastMonthProfit.getProfitTarget().intValue()
                                    : 0);
                    userInfo.setLastMonthProfitActual(
                            lastMonthProfit.getProfitResult() != null ? lastMonthProfit.getProfitResult().intValue()
                                    : 0);

                    // 達成率を計算（目標が0の場合は0とする）
                    if (lastMonthProfit.getProfitTarget() != null && lastMonthProfit.getProfitTarget() > 0
                            && lastMonthProfit.getProfitResult() != null) {
                        float achievementRate = (float) lastMonthProfit.getProfitResult()
                                / lastMonthProfit.getProfitTarget() * 100;
                        userInfo.setLastMonthProfitAchievementRate(achievementRate);
                    } else {
                        userInfo.setLastMonthProfitAchievementRate(0f);
                    }
                }

                // 今月の売上・利益データを取得
                Optional<Sale> currentMonthSaleOpt = saleRepository.findByUserIdAndYearAndMonth(user.getUserId(),
                        currentYear, currentMonth);
                Optional<Profit> currentMonthProfitOpt = profitRepository.findByUserIdAndYearAndMonth(user.getUserId(),
                        currentYear, currentMonth);

                if (currentMonthSaleOpt.isPresent()) {
                    Sale currentMonthSale = currentMonthSaleOpt.get();
                    userInfo.setCurrentMonthSalesTarget(
                            currentMonthSale.getSaleTarget() != null ? currentMonthSale.getSaleTarget().intValue() : 0);
                    userInfo.setCurrentMonthSalesActual(
                            currentMonthSale.getSaleResult() != null ? currentMonthSale.getSaleResult().intValue() : 0);

                    // 達成率を計算（目標が0の場合は0とする）
                    if (currentMonthSale.getSaleTarget() != null && currentMonthSale.getSaleTarget() > 0
                            && currentMonthSale.getSaleResult() != null) {
                        float achievementRate = (float) currentMonthSale.getSaleResult()
                                / currentMonthSale.getSaleTarget() * 100;
                        userInfo.setCurrentMonthSalesAchievementRate(achievementRate);
                    } else {
                        userInfo.setCurrentMonthSalesAchievementRate(0f);
                    }
                }

                if (currentMonthProfitOpt.isPresent()) {
                    Profit currentMonthProfit = currentMonthProfitOpt.get();
                    userInfo.setCurrentMonthProfitTarget(currentMonthProfit.getProfitTarget() != null
                            ? currentMonthProfit.getProfitTarget().intValue()
                            : 0);
                    userInfo.setCurrentMonthProfitActual(currentMonthProfit.getProfitResult() != null
                            ? currentMonthProfit.getProfitResult().intValue()
                            : 0);

                    // 達成率を計算（目標が0の場合は0とする）
                    if (currentMonthProfit.getProfitTarget() != null && currentMonthProfit.getProfitTarget() > 0
                            && currentMonthProfit.getProfitResult() != null) {
                        float achievementRate = (float) currentMonthProfit.getProfitResult()
                                / currentMonthProfit.getProfitTarget() * 100;
                        userInfo.setCurrentMonthProfitAchievementRate(achievementRate);
                    } else {
                        userInfo.setCurrentMonthProfitAchievementRate(0f);
                    }
                }

                // 前年同月比を計算
                calculateYearOverYearComparison(user.getUserId(), currentYear, currentMonth, userInfo);

                // 累計達成率を計算
                calculateCumulativeAchievementRate(user.getUserId(), currentYear, currentMonth, userInfo);

                // コメント情報を取得
                List<TaxAccountantComment> comments = taxAccountantCommentRepository.findByUserId(user.getUserId());
                if (!comments.isEmpty()) {
                    // コメントを日付の降順でソート
                    comments.sort(Comparator.comparing(TaxAccountantComment::getUpdatedAt).reversed());

                    // 最新のコメント情報を設定
                    TaxAccountantComment latestComment = comments.get(0);
                    userInfo.setHasComment("1".equals(latestComment.getTaxAccountantCommentFlg()));
                    userInfo.setComment(latestComment.getTaxAccountantComment());
                    userInfo.setCommentDate(latestComment.getUpdatedAt());

                    // コメント履歴を設定
                    List<CommentHistory> commentHistoryList = new ArrayList<>();
                    for (TaxAccountantComment comment : comments) {
                        if (comment.getTaxAccountantComment() != null && !comment.getTaxAccountantComment().isEmpty()) {
                            CommentHistory history = new CommentHistory();
                            history.setCommentId(comment.getTaxAccountantCommentId());
                            history.setComment(comment.getTaxAccountantComment());
                            history.setCommentDate(comment.getUpdatedAt());
                            commentHistoryList.add(history);
                        }
                    }
                    userInfo.setCommentHistory(commentHistoryList);
                } else {
                    userInfo.setHasComment(false);
                }

                userInfoList.add(userInfo);
            }

            response.setUsers(userInfoList);
            response.setResponseStatus(1); // 成功
        } catch (Exception e) {
            response.setResponseStatus(0); // 失敗
        }

        return response;
    }

    /**
     * 前年同月比を計算
     * 
     * @param userId   ユーザーID
     * @param year     現在の年
     * @param month    現在の月
     * @param userInfo ユーザー情報
     */
    private void calculateYearOverYearComparison(String userId, int year, int month, AdminUserInfo userInfo) {
        // 前年の同月の売上実績を取得
        Optional<Sale> lastYearSaleOpt = saleRepository.findByUserIdAndYearAndMonth(userId, year - 1, month);
        Optional<Sale> currentYearSaleOpt = saleRepository.findByUserIdAndYearAndMonth(userId, year, month);

        if (lastYearSaleOpt.isPresent() && currentYearSaleOpt.isPresent()) {
            Sale lastYearSale = lastYearSaleOpt.get();
            Sale currentYearSale = currentYearSaleOpt.get();

            if (lastYearSale.getSaleResult() != null && lastYearSale.getSaleResult() > 0
                    && currentYearSale.getSaleResult() != null) {
                float yoyComparison = (float) currentYearSale.getSaleResult() / lastYearSale.getSaleResult() * 100;
                userInfo.setYearOverYearComparison(yoyComparison);
            } else {
                userInfo.setYearOverYearComparison(0f);
            }
        } else {
            userInfo.setYearOverYearComparison(0f);
        }
    }

    /**
     * 累計達成率を計算
     * 
     * @param userId   ユーザーID
     * @param year     現在の年
     * @param month    現在の月
     * @param userInfo ユーザー情報
     */
    private void calculateCumulativeAchievementRate(String userId, int year, int month, AdminUserInfo userInfo) {
        // 年初から現在の月までの売上目標と実績を集計
        List<Sale> yearSales = saleRepository.findByUserIdAndYear(userId, year);

        long totalTarget = 0;
        long totalActual = 0;

        for (Sale sale : yearSales) {
            if (sale.getMonth() <= month) {
                if (sale.getSaleTarget() != null) {
                    totalTarget += sale.getSaleTarget();
                }
                if (sale.getSaleResult() != null) {
                    totalActual += sale.getSaleResult();
                }
            }
        }

        if (totalTarget > 0) {
            float cumulativeRate = (float) totalActual / totalTarget * 100;
            userInfo.setCumulativeAchievementRate(cumulativeRate);
        } else {
            userInfo.setCumulativeAchievementRate(0f);
        }
    }
}