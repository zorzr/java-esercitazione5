// ESERCITAZIONE 5
package eccezioni;

/**
 *
 * @author zorzr
 */

public class WrongPass extends Exception {
    
    public WrongPass() {
        super("ERRORE: La password inserita non è corretta");
    }
}
