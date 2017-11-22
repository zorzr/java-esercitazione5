// ESERCITAZIONE 5
package eccezioni;

/**
 *
 * @author zorzr
 */

public class PrelievoContoDep extends Exception {
    
    public PrelievoContoDep() {
        super("ERRORE: Impossibile prelevare da un Conto Deposito");
    }
}
