package at.ac.htlstp.et.sj23.k2b.felder;

import java.util.Vector;

public class Primzahlen2 {

    public static Vector<Integer> prims(int max) {
        Vector<Integer> p = new Vector<>();
        PRIMSCHLEIFE:
        for (int x=3;x<=max;x+=2){
            int w = ((int)Math.sqrt(x))+1;
            for (int i=0; i<p.size(); i++) {
                //if (p.get(i)*p.get(i)>x) continue;
                if (p.get(i)>w) continue;
                if (x%p.get(i)==0) continue PRIMSCHLEIFE;
            }
            p.add(x);
        }
        p.insertElementAt(2,0);
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
