package objects.unmovableObjects;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class Point{


    private int x=-300;
    private int y=0;
    private int r=2;

    public void drawMe(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        int dx0 = g2d.getClipBounds().width / 2;
        int dy0 = g2d.getClipBounds().height / 2;

        AffineTransform saveAT = g2d.getTransform();

        AffineTransform t = new AffineTransform();
        t.translate(dx0, dy0);
        t.scale(1, -1);


        g2d.setTransform(t);
        g2d.fill(new Ellipse2D.Float.Float(x-r,y-r,2*r,2*r));

        g2d.setTransform(saveAT);

    }
    public int getX(){return x;}
    public int getY(){return y;}

    public void setD(int d) {x=d;}
    public void setH(int h) {y=h;}


}
