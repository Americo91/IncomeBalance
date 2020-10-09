package astoppello.springframework.incomebalance.controllers;

import astoppello.springframework.incomebalance.model.YearBalance;
import astoppello.springframework.incomebalance.modelUtils.YearBalanceUtils;
import astoppello.springframework.incomebalance.services.YearBalanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by @author stopp on 09/10/2020
 */
@Controller
@Slf4j
@RequestMapping("/years")
public class YearBalanceController {

    private final YearBalanceService yearBalanceService;


    public YearBalanceController(YearBalanceService yearBalanceService) {
        this.yearBalanceService = yearBalanceService;
    }

    @GetMapping("/{id}/show")
    public String showById(@PathVariable String id, Model model){
        log.debug("Show id: "+id);
        YearBalance yearBalance = yearBalanceService.findById(Long.parseLong(id));
        YearBalanceUtils.fillYearBalance(yearBalance);
        model.addAttribute(yearBalance);
        return "yearbalance/show";
    }

}
