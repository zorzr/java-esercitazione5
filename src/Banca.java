// ESERCITAZIONE 5
import java.util.HashMap;
import eccezioni.*;

/**
 * @see Conto
 * @see Accountable
 * @see ContoType
 * @author zorzr
 */

public class Banca {
    private final String nome, rad_iban;
    private HashMap<String,Conto> conti;
    private int n;
    
    public Banca(String nome_banca) {
        this.nome = nome_banca;
        this.rad_iban = "IBAN000";
        this.conti = new HashMap<>();
        this.n = 0;
    }
    
    public Conto addConto (String codf, ContoType type) {
        String iban = rad_iban + n;
        n++;
        
        if (conti.containsKey(iban))   return null;
        
        switch (type) {
            case CORRENTE:
                conti.put(iban, new ContoCorr(iban, codf));
                break;
            case DEPOSITO:
                conti.put(iban, new ContoDep(iban, codf));
                break;
            case WEB:
                conti.put(iban, new ContoWeb(iban, codf));
                break;
            default:
                break;
        }
        
        Conto c = conti.get(iban);
        return c;
    }
    
    public boolean operazione (String iban, double val) {
        try {
            if (!conti.containsKey(iban))   throw new InvalidIban();
        
            Conto c = conti.get(iban);
            return c.operazione(val);
        }
        catch (PrelievoContoDep | SaldoInsuff | NotLogged e) {
            System.out.println("Conto " + iban + "    " + e.getMessage());
            return false;
        }
        catch (InvalidIban e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean login (String iban, String pass) {
        try {
            if (!conti.containsKey(iban))   throw new InvalidIban();
            
            Conto c = conti.get(iban);
            if (c instanceof ContoWeb) {
                ContoWeb web = (ContoWeb) c;
                return web.login(pass);
            }
            return false;
        }
        catch (WrongPass | FirstLogin e) {
            System.out.println("Conto " + iban + "    " + e.getMessage());
            return false;
        }
        catch (InvalidIban e) {
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
    public boolean logout (String iban, String pass) {
        try {
            if (!conti.containsKey(iban))   throw new InvalidIban();
            
            Conto c = conti.get(iban);
            if (c instanceof ContoWeb) {
                ContoWeb web = (ContoWeb) c;
                web.logout();
                return true;
            }
            return false;
        }
        catch (InvalidIban e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean changePass (String iban, String pass, String new_pass) {
        try {
            if (!conti.containsKey(iban))   throw new InvalidIban();
            
            Conto c = conti.get(iban);
            if (c instanceof ContoWeb) {
                ContoWeb web = (ContoWeb) c;
                return web.setPassword(pass, new_pass);
            }
            return false;
        }
        catch (WrongPass e) {
            System.out.println("Conto " + iban + "    " + e.getMessage());
            return false;
        }
        catch (InvalidIban e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public void stampa_dati (String iban) {
        if (conti.containsKey(iban)) {
            Conto c = conti.get(iban);
            System.out.println(c.getCf() + "  " + c.getIban() + "  " + c.getSaldo());
        }
    }
    
    // ACCOUNTABLES
    public boolean addAccountable (String iban, Accountable acc) {
        try {
            if (!conti.containsKey(iban))   throw new InvalidIban();
            
            Conto c = conti.get(iban);
            return c.addAccountable(acc);
        }
        catch (AddebitoContoDep e) {
            System.out.println("Conto " + iban + "    " + e.getMessage());
            return false;
        }
        catch (InvalidIban e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean fineMese () {
        boolean r;
        
        for (Conto c : conti.values()) {
            r = c.fineMese();
            
            if (!r)  System.out.println("Errore nel pagamento degli accountable per il conto:  " + c.getIban());
        }
        return true;
    }
}
