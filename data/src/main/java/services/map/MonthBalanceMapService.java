package services.map;

import model.MonthBalance;
import services.MonthBalanceService;

import java.util.Set;

/**
 * Created by @author stopp on 05/10/2020
 */
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
    public Set<MonthBalance> findAll() {
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
