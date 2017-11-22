// ESERCITAZIONE 5
package eccezioni;

/**
 *
 * @author zorzr
 */
public class AddebitoContoDep extends Exception {
    
    public AddebitoContoDep() {
        super("ERRORE: Impossibile aggiungere un addebito a un Conto Deposito");
    }
}
