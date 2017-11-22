// ESERCITAZIONE 5
import eccezioni.*;

/**
 * @see Conto
 * @see ContoAstratto
 * @author zorzr
 */
public class ContoDep extends ContoAstratto {
    public ContoDep (String ib, String codf) {
        super(ib, codf);
    }
    
    @Override
    public boolean operazione (double x) throws PrelievoContoDep {
        if (x < 0) {
            throw new PrelievoContoDep();
        }
        
        saldo += x;
        return true;
    }
    
    // ACCOUNTABLES
    @Override
    public boolean addAccountable (Accountable acc) throws AddebitoContoDep {
        if (acc.getType().equals(AccountableType.ADDEBITO))  {
            throw new AddebitoContoDep();
        }
        
        return accountables.add(acc);
    }
}
