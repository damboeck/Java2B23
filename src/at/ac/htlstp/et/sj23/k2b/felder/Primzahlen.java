package at.ac.htlstp.et.sj23.k2b.felder;

import java.util.Vector;

public class Primzahlen {

    public static Vector<Integer> prims(int max) {
        Vector<Integer> p = new Vector<>();
        for (int x=2;x<=max;x++){
            boolean isprim=true;
            for (int i=0; i<p.size(); i++) {
                if (x%p.get(i)==0) isprim=false;
            }
            if (isprim) p.add(x);
        }
        return p;
    }

    public static void main(String[] args) {
        Vector<Integer> p;
        long t = System.currentTimeMillis();
        p = prims(100000);
        t = System.currentTimeMillis()-t;
        System.out.println("Dauer:"+t+"ms");
        System.out.println("PZ:"+p);
    }
}
