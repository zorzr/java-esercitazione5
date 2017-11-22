// ESERCITAZIONE 5

/**
 * @see Accountable
 * @see AccountableAstratto
 * @see AccountableType
 * @author zorzr
 */

public class Stipendio extends AccountableAstratto {
    private final double importo;
    
    public Stipendio (double val) {
        super(AccountableType.ACCREDITO);
        this.importo = val;
    }

    @Override
    public double getImporto() {
        return importo;
    }
}
