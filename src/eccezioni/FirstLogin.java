// ESERCITAZIONE 5
package eccezioni;

/**
 *
 * @author zorzr
 */

public class FirstLogin extends Exception {
    
    public FirstLogin() {
        super("ERRORE: E' necessario modificare la password prima di utilizzare il conto");
    }
}
