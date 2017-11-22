// ESERCITAZIONE 5
import eccezioni.*;

/**
 * @see Banca
 * @see ContoAstratto
 * @author zorzr
 */

public interface Conto {
    public boolean operazione(double x) throws PrelievoContoDep, SaldoInsuff, NotLogged;
    public String getIban();
    public double getSaldo();
    public String getCf();
    
    // ACCOUNTABLES
    public boolean addAccountable(Accountable acc) throws AddebitoContoDep;
    public boolean fineMese();
}
