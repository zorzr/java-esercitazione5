// ESERCITAZIONE 5
package eccezioni;

/**
 *
 * @author zorzr
 */

public class InvalidIban extends Exception {
    
    public InvalidIban() {
        super("ERRORE: L'IBAN inserito non corrisponde a nessun conto");
    }
}
