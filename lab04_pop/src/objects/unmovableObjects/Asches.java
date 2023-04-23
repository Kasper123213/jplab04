package objects.unmovableObjects;

import java.awt.*;
import java.awt.geom.AffineTransform;
public class Asches{

    public void drawMe(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        int dx0 = g2d.getClipBounds().width / 2;
        int dy0 = g2d.getClipBounds().height / 2;

            AffineTransform saveAT = g2d.getTransform();


            AffineTransform t = new AffineTransform();
            t.translate(dx0, dy0);
            t.scale(1, -1);

            g2d.setTransform(t);


        g2d.drawLine(-dx0,-dy0-100,-dx0,dy0);



        g2d.drawLine(-dx0,-0,dx0,-0);



        g2d.setTransform(saveAT);
    }
}