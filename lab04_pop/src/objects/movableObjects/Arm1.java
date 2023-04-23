package objects.movableObjects;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Arm1 {
    private int lenght=100;
    public void drawMe(Graphics g, int y1) {

        Graphics2D g2d = (Graphics2D) g;

        int dy0 = g2d.getClipBounds().height / 2;

        AffineTransform saveAT = g2d.getTransform();
        Color saveColor = g2d.getColor();
        AffineTransform t = new AffineTransform();

        t.translate(0,dy0-y1);
        t.scale(1,-1);

        g2d.setTransform(t);
        g2d.drawLine(0,-lenght,0,0);
        g2d.setColor(saveColor);

        g2d.setTransform(saveAT);
    }

    public void setLenght(int lenght){this.lenght=lenght;}


}
