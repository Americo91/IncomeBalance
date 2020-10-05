package services.map;

import model.BankBalance;
import services.BankBalanceService;

import java.util.Set;

/**
 * Created by @author stopp on 05/10/2020
 */
public class BankBalanceMapService extends AbstractMapService<BankBalance, Long> implements BankBalanceService {
    @Override
    public BankBalance findById(Long id) {
        return super.findById(id);
    }

    @Override
    public BankBalance save(BankBalance bankBalance) {
        return super.save(bankBalance);
    }

    @Override
    public Set<BankBalance> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(BankBalance bankBalance) {
        super.delete(bankBalance);
    }
}
