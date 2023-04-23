package objects.movableObjects;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class ArmEnd {

    private int rpoint=2;
    private double xc;
    private double yc;


    public void drawMe(Graphics g, int y1,int x1, int x2, double angle) {

        xc=x1+x2*Math.cos(angle);
        yc=y1+x2*Math.sin(angle);
        Graphics2D g2d = (Graphics2D) g;

        int dx0 = g2d.getClipBounds().width / 2;
        int dy0 = g2d.getClipBounds().height / 2;

        AffineTransform saveAT = g2d.getTransform();

        AffineTransform t = new AffineTransform();
        t.translate(dx0, dy0);
        t.scale(1, -1);


        g2d.setTransform(t);
        g2d.fill(new Ellipse2D.Float.Float((float)xc,(float)yc,2*rpoint,2*rpoint));

        g2d.setTransform(saveAT);

    }

    public double getX() {
        return xc;
    }

    public double getY() {
        return yc;
    }
}
