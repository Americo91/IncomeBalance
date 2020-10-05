package model;

import lombok.*;

import java.time.Year;
import java.util.List;

/**
 * Created by @author stopp on 05/10/2020
 */
@Getter
@Setter
@NoArgsConstructor
public class YearBalance extends BaseEntity {

    private Year year;
    private Double totIncomes;
    private Double totExpenses;
    private Double annualSalary;
    private List<MonthBalance> monthSalaryList;

    @Builder
    public YearBalance(Long id, Year year, List<MonthBalance> monthSalaryList) {
        super(id);
        this.year = year;
        if(monthSalaryList != null) {
            this.monthSalaryList = monthSalaryList;
        }
    }
}
