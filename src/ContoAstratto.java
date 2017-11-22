// ESERCITAZIONE 5
import java.util.ArrayList;
import eccezioni.*;

/**
 * @see Conto
 * @see ContoCorr
 * @see ContoDep
 * @see ContoWeb
 * @author zorzr
 */

public abstract class ContoAstratto implements Conto {
    private final String iban, cf;
    protected double saldo;
    protected ArrayList<Accountable> accountables;
    
    public ContoAstratto(String ib, String codf) {
        this.iban = ib;
        this.cf = codf;
        this.saldo = 0.;
        this.accountables = new ArrayList<>();
    }
    
    @Override
    public abstract boolean operazione(double x) throws PrelievoContoDep, SaldoInsuff, NotLogged;
    
    @Override
    public String getIban() {
        return iban;
    }
    @Override
    public double getSaldo() {
        return saldo;
    }
    @Override
    public String getCf() {
        return cf;
    }
    
    // ACCOUNTABLES
    @Override
    public boolean addAccountable (Accountable acc) throws AddebitoContoDep {
        return accountables.add(acc);
    }
    
    @Override
    public boolean fineMese () {
        boolean r = true;
        double val;
        int i, n;
        n = accountables.size();
        Accountable acc;
        
        for (i = 0; i < n; i++) {
            acc = accountables.get(i);
            val = acc.getImporto();
            
            if (acc.getType().equals(AccountableType.ACCREDITO)) {
                try {
                    r = operazione(val);
                }
                catch (PrelievoContoDep | SaldoInsuff | NotLogged e) {
                    System.out.println("Conto " + iban + "    " + e.getMessage());
                    return false;
                }
            }
        }
        
        for (i = 0; i < n; i++) {
            acc = accountables.get(i);
            val = acc.getImporto();
            
            if (acc.getType().equals(AccountableType.ADDEBITO)) {
                try {
                    r = operazione(-val);
                }
                catch (PrelievoContoDep | SaldoInsuff | NotLogged e) {
                    System.out.println("Conto " + iban + "    " + e.getMessage());
                    return false;
                }
            }
        }
        
        return true;
    }
}