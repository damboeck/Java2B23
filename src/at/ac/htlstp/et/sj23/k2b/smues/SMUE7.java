package at.ac.htlstp.et.sj23.k2b.smues;

/**
 * Schreibe je eine Methode "ser" und "par" welche den
 * Serien- und Parallelersatzwiderstand von zwei Widerständen
 * (double!) berechnet!
 */
public class SMUE7 {

    /**
     * Berechnet den Serienersatzwiderstand
     * @param r1 erster Widerstand
     * @param r2 zweiter Widerstand
     * @return   Serienersatzwiderstand
     */
    public static double ser(double r1, double r2) {
        double rges = r1+r2;
        return rges;
    }

    /**
     * Berechnet den Parallelersatzwiderstand
     * @param r1 erster Widerstand
     * @param r2 zweiter Widerstand
     * @return   Parallelersatzwiderstand
     */
    public static double par(double r1, double r2) {
        double rges = r1*r2/(r1+r2);
        return rges;
    }

    /**
     * Prüft ob x=y ist mit einer Toleranz in Prozent
     * @param x  erster Wert
     * @param y  zweiter Wert
     * @param tolerance Toleranz in Prozent
     * @return   true wenn gleich
     */
    public static boolean equals(double x, double y, double tolerance) {
        double t = Math.abs(x-y)*100d/Math.max(Math.abs(x),Math.abs(y));
        return t<tolerance;
    }

    public static boolean equals(double x, double y) {
        return equals(x,y,1e-6);
    }

    public static boolean equals(int x, int y) {
        return x==y;
    }

    public static void testeserpar(double r1, double r2, double ser, double par){
        double berser = ser(r1,r2);
        double berpar = par(r1,r2);
        if (!equals(ser,berser,0.001)) System.out.println("Fehler!");
        if (!equals(par,berpar,0.001)) System.out.println("Fehler!");
    }

    public static void main(String[] args) {
        testeserpar(2,4,6,2*4/6d);
        testeserpar(5.6,5.6,11.2,2.8);
    }
}
