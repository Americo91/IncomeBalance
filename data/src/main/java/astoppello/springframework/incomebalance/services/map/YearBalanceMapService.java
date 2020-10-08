package astoppello.springframework.incomebalance.services.map;

import astoppello.springframework.incomebalance.model.YearBalance;
import astoppello.springframework.incomebalance.services.YearBalanceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by @author stopp on 05/10/2020
 */
@Service
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
    public List<YearBalance> saveAll(List<YearBalance> list) {
        return super.saveAll(list);
    }

    @Override
    public List<YearBalance> findAll() {
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
