package astoppello.springframework.incomebalance.bootstrap;

import astoppello.springframework.incomebalance.model.Bank;
import astoppello.springframework.incomebalance.model.BankBalance;
import astoppello.springframework.incomebalance.model.MonthBalance;
import astoppello.springframework.incomebalance.model.YearBalance;
import org.springframework.boot.CommandLineRunner;
import astoppello.springframework.incomebalance.services.BankBalanceService;
import astoppello.springframework.incomebalance.services.MonthBalanceService;
import astoppello.springframework.incomebalance.services.YearBalanceService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;
import java.util.List;

/**
 * Created by @author stopp on 06/10/2020
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final BankBalanceService bankBalanceService;
    private final MonthBalanceService monthBalanceService;
    private final YearBalanceService yearBalanceService;

    public DataLoader(BankBalanceService bankBalanceService, MonthBalanceService monthBalanceService,
                      YearBalanceService yearBalanceService) {
        this.bankBalanceService = bankBalanceService;
        this.monthBalanceService = monthBalanceService;
        this.yearBalanceService = yearBalanceService;
    }


    @Override
    public void run(String... args) throws Exception {
        if (monthBalanceService.findAll()
                               .size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        BankBalance bankBalanceRevolut =
                BankBalance.builder()
                           .id(1L)
                           .bank(Bank.REVOLUT)
                           .totIncomes(new BigDecimal("120.24"))
                           .totExpenses(new BigDecimal("876.55"))
                           .build();
        BankBalance bankBalanceMediolanum =
                BankBalance.builder()
                           .id(2L)
                           .bank(Bank.MEDIOLANUM)
                           .totIncomes(new BigDecimal("500.1"))
                           .totExpenses(new BigDecimal("229.85"))
                           .build();
        BankBalance bankBalanceBoursorama =
                BankBalance.builder()
                           .id(3L)
                           .bank(Bank.BOURSORAMA)
                           .totIncomes(new BigDecimal("2778.12"))
                           .totExpenses(new BigDecimal("2321.21"))
                           .build();
        bankBalanceService.save(bankBalanceBoursorama);
        bankBalanceService.save(bankBalanceRevolut);
        bankBalanceService.save(bankBalanceMediolanum);
        System.out.println("Loading BankBalance");

        MonthBalance monthBalance =
                MonthBalance.builder()
                            .id(1L)
                            .salary(new BigDecimal("2078.12"))
                            .month(Month.SEPTEMBER)
                            .bankBalanceList(List.of(bankBalanceRevolut, bankBalanceBoursorama, bankBalanceMediolanum))
                            .build();
        monthBalanceService.save(monthBalance);
        System.out.println("Loading Month Balance");

        YearBalance yearBalance =
                YearBalance.builder()
                           .id(1L)
                           .monthSalaryList(List.of(monthBalance))
                           .year(Year.now())
                           .build();
        yearBalanceService.save(yearBalance);
        System.out.println("Loading Year Balance");
    }
}
