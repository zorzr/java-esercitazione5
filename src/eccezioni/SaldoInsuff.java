// ESERCITAZIONE 5
package eccezioni;

/**
 *
 * @author zorzr
 */

public class SaldoInsuff extends Exception {
    
    public SaldoInsuff() {
        super("ERRORE: Impossibile eseguire l'operazione, saldo insufficiente");
    }
    
}
