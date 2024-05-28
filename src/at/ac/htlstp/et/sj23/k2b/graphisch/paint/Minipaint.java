package at.ac.htlstp.et.sj23.k2b.graphisch.paint;

import at.ac.htlstp.et.sj23.k2b.graphisch.MANIPULATIONSMODE;
import at.ac.htlstp.et.sj23.k2b.graphisch.MyFrameMT;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class Minipaint extends MyFrameMT {

    private static final double MAX_SELECT_DISTANCE = 10;

    private Vector<Paintable> objects = new Vector<Paintable>();
    private PaintMode mode = PaintMode.LINIE;
    private Paintable selected = null;
    private Color drawColor = Color.BLACK;
    private Color fillColor = Color.red;
    private int thickness   = 1;
    private Point oldCursor;

    public static void main(String[] args) {
        new Minipaint();
    }

    public Minipaint() {
        super("Minipaint", 800,600);
        //objects.add(new Linie(new Point(100,100),new Point(500,500),Color.blue,null,1));
        //objects.add(new Rechteck(new Point(200,100),new Point(500,200),Color.red,Color.green,1));
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        for (Paintable o : objects) {
            o.paint(g);
        }
        if (selected!=null && mode==PaintMode.SELECT) selected.paintSelection(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (mode) {
            case LINIE -> {
                Linie linie = new Linie(e.getPoint(),e.getPoint(),drawColor,fillColor,thickness);
                selected = linie;
                objects.add(linie);
                mode = PaintMode.CREATE;
                repaint();
            }
            case RECHTECK -> {
            }
            case OVAL -> {
            }
            case CREATE -> {
            }
            case SELECT -> {
                selected = null;
                double minDistance=MAX_SELECT_DISTANCE*2;
                // Suche direkt auf den Linien
                for (Paintable p:objects) if (p instanceof Selectable) {
                    Selectable s = (Selectable) p;
                    double distance = s.distanceTo(e.getPoint());
                    if (distance<MAX_SELECT_DISTANCE && distance<minDistance) {
                        selected = p;
                        minDistance = distance;
                    }
                }
                if (selected==null) {
                    // wenn nichts gefunden dann suche nach den Flächen
                    for (Paintable p:objects) if (p instanceof Selectable) {
                        Selectable s = (Selectable) p;
                        if (s.inner(e.getPoint())) {
                            selected = p;
                        }
                    }
                }
                if (selected!=null) {
                    mode = PaintMode.MOVE;
                    oldCursor = e.getPoint();
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (mode) {
            case CREATE -> {
                if (selected instanceof Zweipunkt) {
                    Zweipunkt zweipunkt = (Zweipunkt) selected;
                    zweipunkt.setP2(e.getPoint());
                    repaint();
                    if (zweipunkt instanceof Linie) mode = PaintMode.LINIE;
                    else if (zweipunkt instanceof Rechteck) mode = PaintMode.RECHTECK;
                    //else if (zweipunkt instanceof Oval) mode = PaintMode.OVAL;
                    else mode = PaintMode.LINIE;
                    mode=PaintMode.SELECT;
                }
            }
            case MOVE -> {
                if (selected instanceof Moveable) {
                    ((Moveable)selected).move(oldCursor,e.getPoint());
                    oldCursor=e.getPoint();
                }
                mode = PaintMode.SELECT;
                repaint();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        switch (mode) {
            case CREATE -> {
                if (selected instanceof Zweipunkt) {
                    Zweipunkt zweipunkt = (Zweipunkt) selected;
                    zweipunkt.setP2(e.getPoint());
                    repaint();
                }
            }
            case MOVE -> {
                if (selected instanceof Moveable) {
                    ((Moveable)selected).move(oldCursor,e.getPoint());
                    oldCursor=e.getPoint();
                    repaint();
                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        double d = selected instanceof Selectable ? ((Selectable) selected).distanceTo(e.getPoint()) : 1000;
        System.out.println("d="+d);
    }
}
