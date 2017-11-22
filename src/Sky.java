// ESERCITAZIONE 5

/**
 * @see Accountable
 * @see AccountableAstratto
 * @see AccountableType
 * @author zorzr
 */

public class Sky extends AccountableAstratto {
    private final double importo;
    
    public Sky (double val) {
        super(AccountableType.ADDEBITO);
        this.importo = val;
    }

    @Override
    public double getImporto() {
        return importo;
    }
}
