package astoppello.springframework.incomebalance.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.Year;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by @author stopp on 05/10/2020
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class YearBalance extends BaseEntity {

    private Year year;
    private BigDecimal annualSalary;
    private List<MonthBalance> monthSalaryList = new LinkedList<>();

    @Builder
    public YearBalance(Long id, Year year, List<MonthBalance> monthSalaryList) {
        super(id, null, null, null);
        this.year = year;
        if (monthSalaryList != null) {
            this.monthSalaryList = monthSalaryList;
        }
    }

    @Builder
    public YearBalance(Long id, Year year, BigDecimal totIncomes, BigDecimal totExpenses, BigDecimal result,
                       BigDecimal annualSalary, List<MonthBalance> monthSalaryList) {
        super(id, totIncomes, totExpenses, result);
        this.year = year;
        this.annualSalary = annualSalary;
        if (monthSalaryList != null) {
            this.monthSalaryList = monthSalaryList;
        }
    }
}
