package astoppello.springframework.incomebalance.modelUtils;

import astoppello.springframework.incomebalance.model.BankBalance;
import astoppello.springframework.incomebalance.model.MonthBalance;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;

/**
 * Created by @author stopp on 07/10/2020
 */
public final class MonthBalanceUtils {

    public static BigDecimal computeTotExpenses(MonthBalance monthBalance) {
        BigDecimal totExpenses = new BigDecimal(0.0);
        if (CollectionUtils.isEmpty(monthBalance.getBankBalanceList())) {
            return totExpenses;
        }
        return monthBalance.getBankBalanceList()
                           .stream()
                           .map(BankBalance::getTotExpenses)
                           .reduce(totExpenses, BigDecimal::add);
    }

    public static BigDecimal computeTotIncomes(MonthBalance monthBalance) {
        BigDecimal totIncomes = new BigDecimal(0.0);
        if (CollectionUtils.isEmpty(monthBalance.getBankBalanceList())) {
            return totIncomes;
        }
        return monthBalance.getBankBalanceList()
                           .stream()
                           .map(BankBalance::getTotIncomes)
                           .reduce(totIncomes, BigDecimal::add);
    }

    public static BigDecimal computeResult(MonthBalance monthBalance) {
        return computeTotIncomes(monthBalance).subtract(computeTotExpenses(monthBalance));
    }

    public static void fillMonthBalance(MonthBalance monthBalance) {
        monthBalance.setTotIncomes(computeTotIncomes(monthBalance));
        monthBalance.setTotExpenses(computeTotExpenses(monthBalance));
        monthBalance.setResult(computeResult(monthBalance));
    }
}
