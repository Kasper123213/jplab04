package objects.movableObjects;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class ConactPoint{
    private int y;
    private int ymax=50;
    private int ymin=-50;
    private int r=2;
    private int speed=1;


    private int dx0;
    private int dy0;
    private int startPossition=0;
    private int repeat=0;
    public ConactPoint(){y=startPossition;}

    public void drawMe(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        dx0 = g2d.getClipBounds().width / 2;
        dy0 = g2d.getClipBounds().height / 2;

        AffineTransform saveAT = g2d.getTransform();

        AffineTransform t = new AffineTransform();
        t.translate(dx0, dy0);
        t.scale(1, -1);


        g2d.setTransform(t);
        g2d.fill(new Ellipse2D.Float.Float(-dx0,y,2*r,2*r));

        g2d.setTransform(saveAT);

    }

    public void move(){

        y+=speed;

        if(y==startPossition)repeat+=1;
        else if (y<=ymin||y>=ymax)speed*=-1;


    }
    public int getY(){return y;}
    public boolean canMove(){return(repeat != 2);}
    public int getX() {return -dx0;}

    public void setSpeed(int value) {
        speed = value;
    }

    public void setBorders(int lenght) {
        ymax=lenght/2;
        ymin=-ymax;
    }
}
