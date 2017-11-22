// ESERCITAZIONE 5

/**
 * @see Accountable
 * @see AccountableType
 * @author zorzr
 */

public abstract class AccountableAstratto implements Accountable {
    private final AccountableType type;
    
    public AccountableAstratto (AccountableType t) {
        this.type = t;
    }

    @Override
    public AccountableType getType() {
        return type;
    }
    
    @Override
    public abstract double getImporto();
}
