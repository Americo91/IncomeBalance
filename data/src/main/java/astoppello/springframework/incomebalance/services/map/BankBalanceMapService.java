package astoppello.springframework.incomebalance.services.map;

import astoppello.springframework.incomebalance.model.BankBalance;
import astoppello.springframework.incomebalance.services.BankBalanceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by @author stopp on 05/10/2020
 */
@Service
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
    public List<BankBalance> findAll() {
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
