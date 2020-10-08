package astoppello.springframework.incomebalance.controllers;

import astoppello.springframework.incomebalance.model.BankBalance;
import astoppello.springframework.incomebalance.model.MonthBalance;
import astoppello.springframework.incomebalance.model.YearBalance;
import astoppello.springframework.incomebalance.services.BankBalanceService;
import astoppello.springframework.incomebalance.services.MonthBalanceService;
import astoppello.springframework.incomebalance.services.YearBalanceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.*;

@ExtendWith(MockitoExtension.class)
class IndexControllerTest {

    @Mock
    BankBalanceService bankBalanceService;
    @Mock
    MonthBalanceService monthBalanceService;
    @Mock
    YearBalanceService yearBalanceService;

    @InjectMocks
    IndexController indexController;
    MockMvc mockMvc;

    List<BankBalance> bankBalances;
    List<MonthBalance> monthBalances;
    List<YearBalance> yearBalances;

    @BeforeEach
    void setUp() {
        bankBalances = List.of(BankBalance.builder().id(1L).build(), BankBalance.builder().id(2L).build());
        monthBalances = List.of(MonthBalance.builder().id(1L).build(), MonthBalance.builder().id(2L).build());
        yearBalances = List.of(YearBalance.builder().id(1L).build(), YearBalance.builder().id(2L).build());
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    void index() throws Exception {
        when(yearBalanceService.findAll()).thenReturn(yearBalances);
        when(monthBalanceService.findAll()).thenReturn(monthBalances);
        when(bankBalanceService.findAll()).thenReturn(bankBalances);
        mockMvc.perform(get("/"))
               .andExpect(status().isOk())
               .andExpect(view().name("index"))
               .andExpect(model().attribute("bankBalances", hasSize(2)))
               .andExpect(model().attribute("monthBalances",hasSize(2)))
               .andExpect(model().attribute("yearBalances", hasSize(2)));
        verify(bankBalanceService, times(1)).findAll();
        verify(yearBalanceService, times(1)).findAll();
        verify(bankBalanceService, times(1)).findAll();
    }
}