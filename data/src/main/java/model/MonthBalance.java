package model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Month;
import java.time.format.TextStyle;
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
    private Double salary;
    private Double totIncomes;
    private Double totExpenses;

    private List<BankBalance> bankBalanceList;

    @Builder
    public MonthBalance(Long id, Month month, Double salary, Double totIncomes, Double totExpenses
            , List<BankBalance> bankBalanceList) {
        super(id);
        this.month = month;
        this.month_name = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        this.salary = salary;
        this.totIncomes = totIncomes;
        this.totExpenses = totExpenses;
        if (bankBalanceList != null) {
            this.bankBalanceList = bankBalanceList;
        }
    }
}
