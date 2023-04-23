package chart;

import objects.unmovableObjects.Asches;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.HashMap;

public class ChartPanel extends javax.swing.JPanel {
    private HashMap<Integer,Double> points = new HashMap<>();
    private String tekst;

    public ChartPanel(String tekst) {
        this.tekst=tekst;
        setLayout(new java.awt.BorderLayout());

        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(500, 500));
    }

    @Override
    public void paintComponent(java.awt.Graphics g){
        super.paintComponent(g);

        java.awt.Dimension d = this.getPreferredSize();
        Asches asches =new Asches();
        asches.drawMe(g);
        Graphics2D g2d = (Graphics2D) g;

        int dy0 = g2d.getClipBounds().height / 2;
        AffineTransform saveAT = g2d.getTransform();
        AffineTransform t = new AffineTransform();
        t.translate(0, dy0);
        t.scale(1, -1);


        g.drawString(tekst,10,10);

        int time;
        double v;

        g2d.setTransform(t);

        for(int i:points.keySet()){
            time=i;
            v=points.get(i);
            g.drawLine(time, 0,time, (int)(v*100));
        }


        g2d.setTransform(saveAT);
    }


    public void addV(int time, double xVelocity) {points.put(time, xVelocity);}

}


