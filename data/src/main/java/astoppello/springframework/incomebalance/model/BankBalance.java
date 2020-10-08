package astoppello.springframework.incomebalance.model;

import lombok.*;

import java.math.BigDecimal;

/**
 * Created by @author stopp on 05/10/2020
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankBalance extends BaseEntity{
    private Bank bank;

    @Builder
    public BankBalance(Long id, Bank bank, BigDecimal totIncomes, BigDecimal totExpenses, BigDecimal result) {
        super(id, totIncomes, totExpenses, result);
        this.bank = bank;
    }
}
