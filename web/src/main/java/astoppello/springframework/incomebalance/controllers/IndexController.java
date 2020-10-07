package astoppello.springframework.incomebalance.controllers;

import astoppello.springframework.incomebalance.model.BankBalance;
import astoppello.springframework.incomebalance.model.MonthBalance;
import astoppello.springframework.incomebalance.model.YearBalance;
import astoppello.springframework.incomebalance.modelUtils.BankBalanceUtils;
import astoppello.springframework.incomebalance.modelUtils.MonthBalanceUtils;
import astoppello.springframework.incomebalance.modelUtils.YearBalanceUtils;
import astoppello.springframework.incomebalance.services.BankBalanceService;
import astoppello.springframework.incomebalance.services.MonthBalanceService;
import astoppello.springframework.incomebalance.services.YearBalanceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by @author stopp on 07/10/2020
 */
@Controller
public class IndexController {

    private final BankBalanceService bankBalanceService;
    private final MonthBalanceService monthBalanceService;
    private final YearBalanceService yearBalanceService;

    public IndexController(BankBalanceService bankBalanceService, MonthBalanceService monthBalanceService,
                           YearBalanceService yearBalanceService) {
        this.bankBalanceService = bankBalanceService;
        this.monthBalanceService = monthBalanceService;
        this.yearBalanceService = yearBalanceService;
    }

    @RequestMapping({"index", "", "/", "index.html"})
    public String index(Model model) {
        List<BankBalance> bankBalances = bankBalanceService.findAll();
        bankBalances.forEach(bankBalance -> bankBalance.setResult(BankBalanceUtils.computeResult(bankBalance)));
        model.addAttribute("bankBalances", bankBalances);


        List<MonthBalance> monthBalanceAll = monthBalanceService.findAll();
        monthBalanceAll.forEach(MonthBalanceUtils::fillMonthBalance);
        monthBalanceService.saveAll(monthBalanceAll);
        model.addAttribute("monthBalances", monthBalanceAll);


        List<YearBalance> yearsBalances = yearBalanceService.findAll();
        yearsBalances.forEach(YearBalanceUtils::fillYearBalance);
        yearBalanceService.saveAll(yearsBalances);

        model.addAttribute("yearBalances", yearsBalances);
        return "index";
    }


}
