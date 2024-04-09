package at.ac.htlstp.et.sj23.k2b;

import java.util.Scanner;

/**
 * Programm welches aus Strom und Spannung einen
 * Widerstand berechnet.
 * (C) Werner Damböck
 * Datum: 19.9.2023
 * Version 0.1
 */
public class Widerstand {
    /**
     * Allgemeine Doku
     * @param args Parameter
     */
    public static void main(String[] args) {
        // Deklarationen
        double spannung=5;
        double widerstand,strom;
        Scanner sc = new Scanner(System.in);

        strom = 0.1;

        System.out.print("Spannung="); // Dies ist ein einzeiliger Kommentar
        //TODO Spannung einlesen
        spannung = sc.nextDouble();

        //TODO Strom einlesen
        System.out.print("Strom=");
        strom = sc.nextDouble();

        //TODO Widerstand berechnen
        widerstand = spannung / strom;
        // Ausgabe des Ergebnisses
        System.out.printf("Widerstand = %8.3f Ohm\n",widerstand);
        System.out.printf("Angabe: U=%8.3f V I=%8.3f\n A",spannung,strom);

    }
}
