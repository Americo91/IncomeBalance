package astoppello.springframework.incomebalance.services.map;

import astoppello.springframework.incomebalance.model.MonthBalance;
import astoppello.springframework.incomebalance.services.MonthBalanceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MonthBalanceMapServiceTest {

    MonthBalanceService monthBalanceService;
    final long ID = 1L;

    @BeforeEach
    void setUp() {
        monthBalanceService = new MonthBalanceMapService();
        MonthBalance monthBalance = MonthBalance.builder().id(ID).build();
        monthBalanceService.save(monthBalance);
    }

    @Test
    void findById() {
        MonthBalance monthBalance = monthBalanceService.findById(ID);
        assertEquals(monthBalance.getId(), ID);
    }

    @Test
    void save() {
        MonthBalance monthBalance = MonthBalance.builder().id(2L).build();
        MonthBalance savedBalance = monthBalanceService.save(monthBalance);
        assertEquals(savedBalance.getId(), monthBalance.getId());
    }

    @Test
    void saveNoId() {
        MonthBalance monthBalance = monthBalanceService.save(new MonthBalance());
        assertNotNull(monthBalance);
        assertNotNull(monthBalance.getId());
    }

    @Test
    void findAll() {
        assertEquals(1, monthBalanceService.findAll().size());
    }

    @Test
    void deleteById() {
        monthBalanceService.deleteById(ID);
        assertEquals(0, monthBalanceService.findAll().size());
    }

    @Test
    void delete() {
        monthBalanceService.delete(monthBalanceService.findById(ID));
        assertEquals(0, monthBalanceService.findAll().size());
    }
}