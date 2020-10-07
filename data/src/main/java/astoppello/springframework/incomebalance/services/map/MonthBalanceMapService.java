package astoppello.springframework.incomebalance.services.map;

import astoppello.springframework.incomebalance.model.MonthBalance;
import astoppello.springframework.incomebalance.services.MonthBalanceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by @author stopp on 05/10/2020
 */
@Service
public class MonthBalanceMapService extends AbstractMapService<MonthBalance, Long> implements MonthBalanceService {

    @Override
    public MonthBalance findById(Long id) {
        return super.findById(id);
    }

    @Override
    public MonthBalance save(MonthBalance monthBalance) {
        return super.save(monthBalance);
    }

    @Override
    public List<MonthBalance> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(MonthBalance monthBalance) {
        super.delete(monthBalance);
    }
}
