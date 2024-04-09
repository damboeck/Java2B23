package at.ac.htlstp.et.sj23.k2b.verzweigungen;

import java.util.Scanner;

/**
 * Entwickle ein Java-Programm, welches folgende Aufgabenstellung erfüllt:
 *
 * Lies einen Kreis (x,y Koordinate von Mittelpunkt und Radius) und einen Punkt ein und bestimme ob dieser Punkt innerhalb des Kreise liegt!
 *
 * Lies der Reihe nach ein: Mittelpunkt x, Mittelpunkt y, Radius, zweiter Punkt x, zweiter Punkt y
 *
 * Als Antwort gibt entweder "innerhalb des Kreises" oder "außerhalb des Kreises" aus!
 */
public class InnerhalbKreis {

    public static void main(String[] args) {
        // Deklarationen
        double mx,my,r;  // Kreis
        double px,py;    // Punkt
        Scanner sc = new Scanner(System.in);
        double a;        // Abstand des Punktes vom Kreismittelpunktes
        // Einlesen
        System.out.print("Mittelpunkt x :"); mx = sc.nextDouble();
        System.out.print("Mittelpunkt y :"); my = sc.nextDouble();
        System.out.print("Radius : ");       r  = sc.nextDouble();
        System.out.print("Punkt x: ");       px = sc.nextDouble();
        System.out.print("Punkt y: ");       py = sc.nextDouble();
        // Berechnung
        a = Math.sqrt(Math.pow(px-mx,2)+Math.pow(py-my,2));
        // Ausgabe
        if (a<r) {
            System.out.println("innerhalb des Kreises");
        } else if (a>r) {
            System.out.println("außerhalb des Kreises");
        } else {
            System.out.println("auf dem Kreis");
        }
        // Finale
        sc.close();
    }
}
