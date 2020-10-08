package astoppello.springframework.incomebalance.services.map;

import astoppello.springframework.incomebalance.model.YearBalance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class YearBalanceMapServiceTest {

    YearBalanceMapService yearBalanceMapService;
    final long ID = 1L;

    @BeforeEach
    void setUp() {
        yearBalanceMapService = new YearBalanceMapService();
        YearBalance yearBalance = YearBalance.builder().id(1L).build();
        yearBalanceMapService.save(yearBalance);
    }

    @Test
    void findById() {
        YearBalance yearBalance = yearBalanceMapService.findById(ID);
        assertEquals(yearBalance.getId(), ID);
    }

    @Test
    void save() {
        YearBalance yearBalance = yearBalanceMapService.save(YearBalance.builder().id(2L).build());
        assertEquals(2L, yearBalance.getId());
    }

    @Test
    void SaveNoId(){
        YearBalance yearBalance = yearBalanceMapService.save(new YearBalance());
        assertNotNull(yearBalance);
        assertNotNull(yearBalance.getId());
    }

    @Test
    void saveAll() {
        List<YearBalance> yearBalances = List.of(YearBalance.builder().id(2L).build(),
                YearBalance.builder().id(3L).build());
        yearBalanceMapService.saveAll(yearBalances);
        assertEquals(3, yearBalanceMapService.findAll().size());
    }

    @Test
    void findAll() {
        assertEquals(1, yearBalanceMapService.findAll().size());
    }

    @Test
    void deleteById() {
        yearBalanceMapService.deleteById(ID);
        assertEquals(0, yearBalanceMapService.findAll().size());
    }

    @Test
    void delete() {
        yearBalanceMapService.delete(yearBalanceMapService.findById(ID));
        assertEquals(0, yearBalanceMapService.findAll().size());
    }
}