// ESERCITAZIONE 5
import eccezioni.*;

/**
 * @see Conto
 * @see ContoAstratto
 * @see ContoCorr
 * @author zorzr
 */

public class ContoWeb extends ContoCorr {
    private String password;
    private boolean firstlogin, loggedin;
    
    public ContoWeb (String ib, String codf) {
        super(ib, codf);
        this.password = "changeme";
        this.firstlogin = true;
        this.loggedin = false;
    }
    
    public boolean login (String pass) throws WrongPass, FirstLogin {
        if (!pass.equals(this.password)) {
            throw new WrongPass();
        }
        if (this.firstlogin) {
            throw new FirstLogin();
        }
        
        this.loggedin = true;
        return true;
    }
    
    public void logout () {
        this.loggedin = false;
    }
    
    public boolean setPassword (String pass, String new_pass) throws WrongPass {
        if (!pass.equals(this.password)) {
            throw new WrongPass();
        }
        
        this.password = new_pass;
        if (this.firstlogin)    this.firstlogin = false;
        
        return true;
    }
    
    @Override
    public boolean operazione (double x) throws SaldoInsuff, NotLogged {
        if (x < -saldo) {
            throw new SaldoInsuff();
        }
        if (!loggedin) {
            throw new NotLogged();
        }
        
        saldo += x;
        return true;
    }
}
