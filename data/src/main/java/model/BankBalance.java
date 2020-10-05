package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by @author stopp on 05/10/2020
 */
@Getter
@Setter
@AllArgsConstructor
public class BankBalance extends BaseEntity{
    private Bank bank;
    private Double totIncome;
    private Double totExpenses;
}
