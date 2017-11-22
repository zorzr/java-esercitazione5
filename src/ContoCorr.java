// ESERCITAZIONE 5
import eccezioni.*;

/**
 * @see Conto
 * @see ContoAstratto
 * @author zorzr
 */
public class ContoCorr extends ContoAstratto {
    public ContoCorr (String ib, String codf) {
        super(ib, codf);
    }
    
    @Override
    public boolean operazione (double x) throws SaldoInsuff, NotLogged {
        if (x < -saldo) {
            throw new SaldoInsuff();
        }
        
        saldo += x;
        return true;
    }
}
