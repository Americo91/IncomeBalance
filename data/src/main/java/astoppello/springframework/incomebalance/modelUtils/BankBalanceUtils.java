package astoppello.springframework.incomebalance.modelUtils;

import astoppello.springframework.incomebalance.model.BankBalance;

import java.math.BigDecimal;

/**
 * Created by @author stopp on 07/10/2020
 */
public class BankBalanceUtils {

    public static BigDecimal computeResult(BankBalance bankBalance) {
        if (bankBalance.getTotIncomes() == null || bankBalance.getTotExpenses() == null) {
            return new BigDecimal("0.0");
        }
        return bankBalance.getTotIncomes().subtract(bankBalance.getTotExpenses());
    }
}
