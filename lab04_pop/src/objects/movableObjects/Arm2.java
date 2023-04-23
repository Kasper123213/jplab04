package objects.movableObjects;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Arm2 {
    private int lenght=100;
    double angle;
    public void drawMe(Graphics g, int y1, int pointY, int pointX) {

        Graphics2D g2d = (Graphics2D) g;
        int dx0 = g2d.getClipBounds().width / 2;
        int dy0 = g2d.getClipBounds().height / 2;

        angle = -(Math.PI/2-Math.atan2(dx0+pointX,y1-pointY));

        AffineTransform saveAT = g2d.getTransform();
        AffineTransform t = new AffineTransform();

        t.translate(0,dy0-y1);
        t.scale(1,-1);
        t.rotate(angle);

        g2d.setTransform(t);
        g2d.drawLine(0,0,lenght,0);

        g2d.setTransform(saveAT);
    }

    public int getLenght() {
        return lenght;
    }
    public void setLenght(int lenght){this.lenght=lenght;}

    public double getAngle() {
        return angle;
    }
}
