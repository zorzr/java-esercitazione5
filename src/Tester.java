// ESERCITAZIONE 5

/**
 * @see Banca
 * @see Conto
 * @see Accountable
 * @author zorzr
 */

public class Tester {
    public static void main(String[] args) {
        boolean r;
        Banca ubi = new Banca("UBI BANCA");
        
        Conto c1, c2, c3;
        c1 = ubi.addConto("CF01", ContoType.CORRENTE);
        check(c1);
        System.out.println("01) OK!");
        c2 = ubi.addConto("CF02", ContoType.DEPOSITO);
        check(c2);
        System.out.println("02) OK!");
        c3 = ubi.addConto("CF03", ContoType.WEB);
        check(c3);
        System.out.println("03) OK!\n");
        
        
        System.out.print("01) ");
        r = ubi.operazione(c1.getIban(), 100.);
        if (r)   System.out.println("OK!");
        System.out.print("02) ");
        r = ubi.operazione(c2.getIban(), -100.);
        if (r)   System.out.println("OK!");
        System.out.print("03) ");
        r = ubi.operazione(c1.getIban(), -50.);
        if (r)   System.out.println("OK!");
        System.out.print("04) ");
        r = ubi.operazione(c3.getIban(), 1000.);
        if (r)   System.out.println("OK!");
        
        r = ubi.changePass(c3.getIban(), "changeme", "tartellette");
        System.out.println("    Cambio password:     " + r);
        r = ubi.login(c3.getIban(), "tartellette");
        System.out.println("    Login:               " + r);
        
        System.out.print("05) ");
        r = ubi.operazione(c3.getIban(), 1000.);
        if (r)   System.out.println("OK!");
        System.out.print("06) ");
        r = ubi.operazione(c3.getIban(), -2000.);
        if (r)   System.out.println("OK!");
        System.out.print("07) ");
        r = ubi.operazione(c2.getIban(), 500.);
        if (r)   System.out.println("OK!");
        System.out.print("08) ");
        r = ubi.operazione("AJEJE BRAZORF", -10.);
        if (r)   System.out.println("OK!");
        
        
        // ACCOUNTABLES
        System.out.println("\nAccountable:");
        System.out.print("01) ");
        r = ubi.addAccountable(c1.getIban(), new Sky(6000.));
        if (r)   System.out.println("OK!");
        System.out.print("02) ");
        r = ubi.addAccountable(c1.getIban(), new Stipendio(1500.));
        if (r)   System.out.println("OK!");
        System.out.print("03) ");
        r = ubi.addAccountable(c2.getIban(), new Sky(10.));
        if (r)   System.out.println("OK!");
        System.out.print("04) ");
        r = ubi.addAccountable(c2.getIban(), new Stipendio(2000.));
        if (r)   System.out.println("OK!");
        
        ubi.logout(c3.getIban(), "tartellette");
        
        System.out.print("05) ");
        r = ubi.addAccountable(c3.getIban(), new Stipendio(1000.));
        if (r)   System.out.println("OK!");
        
        
        System.out.println("\nFine mese:");
        ubi.fineMese();
        
        System.exit(0);
    }
    
    private static void check (Conto c) {
        if (c == null) {
            System.out.println("Errore: conto non inserito\n");
            System.exit(-1);
        }
    }
}
