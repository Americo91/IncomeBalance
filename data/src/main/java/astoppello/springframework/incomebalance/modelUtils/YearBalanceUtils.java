package astoppello.springframework.incomebalance.modelUtils;

import astoppello.springframework.incomebalance.model.MonthBalance;
import astoppello.springframework.incomebalance.model.YearBalance;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;

/**
 * Created by @author stopp on 07/10/2020
 */
public final class YearBalanceUtils {

    public static BigDecimal computeTotExpenses(YearBalance yearBalance) {
        BigDecimal totExpenses = new BigDecimal("0.0");
        if (CollectionUtils.isEmpty(yearBalance.getMonthSalaryList())) {
            return totExpenses;
        }
        return yearBalance.getMonthSalaryList()
                          .stream()
                          .map(MonthBalanceUtils::computeTotExpenses)
                          .reduce(totExpenses, BigDecimal::add);
    }

    public static BigDecimal computeTotIncomes(YearBalance yearBalance) {
        BigDecimal totIncomes = new BigDecimal("0.0");
        if (CollectionUtils.isEmpty(yearBalance.getMonthSalaryList())) {
            return totIncomes;
        }
        return yearBalance.getMonthSalaryList()
                          .stream()
                          .map(MonthBalanceUtils::computeTotIncomes)
                          .reduce(totIncomes, BigDecimal::add);
    }

    public static BigDecimal computeAnnualSalary(YearBalance yearBalance) {
        BigDecimal annualSalary = new BigDecimal("0.0");
        if (CollectionUtils.isEmpty(yearBalance.getMonthSalaryList())) {
            return annualSalary;
        }
        return yearBalance.getMonthSalaryList()
                          .stream()
                          .map(MonthBalance::getSalary)
                          .reduce(annualSalary, BigDecimal::add);
    }

    public static BigDecimal computeResult(YearBalance yearBalance) {
        BigDecimal result = new BigDecimal("0.0");
        if (CollectionUtils.isEmpty(yearBalance.getMonthSalaryList())) {
            return result;
        }
        return yearBalance.getMonthSalaryList()
                          .stream()
                          .map(MonthBalance::getResult)
                          .reduce(result, BigDecimal::add);
    }

    public static void fillYearBalance(YearBalance yearBalance) {
        yearBalance.setAnnualSalary(computeAnnualSalary(yearBalance));
        yearBalance.setTotIncomes(computeTotIncomes(yearBalance));
        yearBalance.setTotExpenses(computeTotExpenses(yearBalance));
        yearBalance.setResult(computeResult(yearBalance));
    }


}
