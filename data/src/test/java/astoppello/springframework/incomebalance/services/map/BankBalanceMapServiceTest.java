package astoppello.springframework.incomebalance.services.map;

import astoppello.springframework.incomebalance.model.BankBalance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BankBalanceMapServiceTest {

    BankBalanceMapService bankBalanceMapService;
    final long ID = 1L;

    @BeforeEach
    void setUp() {
        bankBalanceMapService = new BankBalanceMapService();
        BankBalance bankBalance = BankBalance.builder().id(ID).build();
        bankBalanceMapService.save(bankBalance);
    }

    @Test
    void findById() {
        BankBalance bankBalance = bankBalanceMapService.findById(ID);
        assertEquals(ID, bankBalance.getId());
    }

    @Test
    void save() {
        BankBalance bankBalance = BankBalance.builder().id(2L).build();
        BankBalance savedBankBalance = bankBalanceMapService.save(bankBalance);
        assertEquals(bankBalance.getId(), savedBankBalance.getId());
    }


    @Test
    void saveNoId() {
        BankBalance bankBalance = new BankBalance();
        BankBalance savedBankBalance = bankBalanceMapService.save(bankBalance);
        assertNotNull(savedBankBalance);
        assertNotNull(savedBankBalance.getId());
    }

    @Test
    void findAll() {
        assertEquals(1, bankBalanceMapService.findAll().size());
    }

    @Test
    void deleteById() {
        bankBalanceMapService.deleteById(ID);
        assertEquals(0, bankBalanceMapService.findAll().size());
    }

    @Test
    void delete() {
        bankBalanceMapService.delete(bankBalanceMapService.findById(ID));
        assertEquals(0, bankBalanceMapService.findAll().size());
    }
}