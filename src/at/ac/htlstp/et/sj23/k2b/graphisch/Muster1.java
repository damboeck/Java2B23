package at.ac.htlstp.et.sj23.k2b.graphisch;

// BLABLA
// Kinderspiel

import java.awt.*;

public class Muster1 extends MyFrame{

    public static void main(String[] args) {
        new Muster1("Muster1",800,600);
    }
    public Muster1(String title, int width, int height) {
        super(title, width, height);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        int h = this.getHeight();
        for (int i=0;i<h;i+=h/11)
            g.drawLine(0,i,this.getWidth(),i);
    }
}
