package astoppello.springframework.incomebalance.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Created by @author stopp on 05/10/2020
 */
@Getter
@Setter
@NoArgsConstructor
public class MonthBalance extends BaseEntity {
    private String month_name;
    private Month month;
    private BigDecimal salary;

    private List<BankBalance> bankBalanceList = new LinkedList<>();

    @Builder
    public MonthBalance(Long id, Month month, BigDecimal salary, BigDecimal totIncomes, BigDecimal totExpenses,
                        BigDecimal result, List<BankBalance> bankBalanceList) {
        super(id, totIncomes, totExpenses, result);
        this.month = month;
        this.month_name = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        this.salary = salary;
        if (bankBalanceList != null) {
            this.bankBalanceList = bankBalanceList;
        }
    }
}
