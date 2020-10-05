package services.map;

import model.YearBalance;
import services.YearBalanceService;

import java.util.Set;

/**
 * Created by @author stopp on 05/10/2020
 */
public class YearBalanceMapService  extends AbstractMapService<YearBalance, Long> implements YearBalanceService {
    @Override
    public YearBalance findById(Long id) {
        return super.findById(id);
    }

    @Override
    public YearBalance save(YearBalance yearBalance) {
        return super.save(yearBalance);
    }

    @Override
    public Set<YearBalance> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(YearBalance yearBalance) {
        super.delete(yearBalance);
    }
}
