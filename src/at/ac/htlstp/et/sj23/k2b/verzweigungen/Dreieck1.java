package at.ac.htlstp.et.sj23.k2b.verzweigungen;

import java.util.Scanner;

public class Dreieck1 {

    public static void main(String[] args) {
        double a,b,c,h;
        Scanner sc = new Scanner(System.in);
        // Einlesen a,b,c
        System.out.print("Seite 1:"); a = sc.nextDouble();
        System.out.print("Seite 2:"); b = sc.nextDouble();
        System.out.print("Seite 3:"); c = sc.nextDouble();
        // Sortiere a<=b<=c
        if (a>b) {
            // tausche a und b
            h=a;
            a=b;
            b=h;
        }
        if (a>c) {
            h=a;
            a=c;
            c=h;
        }
        if (b>c) { h=b; b=c; c=h; }
        // sortierte Seiten ausgeben
        System.out.printf("%f<=%f<=%f\n",a,b,c);
    }
}
