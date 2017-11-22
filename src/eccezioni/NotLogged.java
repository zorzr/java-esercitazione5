// ESERCITAZIONE 5
package eccezioni;

/**
 *
 * @author zorzr
 */
public class NotLogged extends Exception {
    
    public NotLogged() {
        super("ERRORE: E' necessario accedere per poter eseguire l'operazione richiesta");
    }
}
