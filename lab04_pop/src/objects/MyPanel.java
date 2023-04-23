package objects;

import objects.movableObjects.Arm1;
import objects.movableObjects.Arm2;
import objects.movableObjects.ArmEnd;
import objects.movableObjects.ConactPoint;
import objects.unmovableObjects.Point;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    public Point point;
    public ConactPoint contactPoint;
    public Arm1 arm1;
    public Arm2 arm2;
    public ArmEnd armEnd;


    public MyPanel() {
        this.setBackground(Color.getHSBColor(60,100,80));

		 point = new Point();
		 contactPoint = new ConactPoint();
		 arm1 = new Arm1();
		 arm2 = new Arm2();
		 armEnd = new ArmEnd();
    }

    @Override
    protected void paintComponent(Graphics arg0) {
        super.paintComponent(arg0);

        if (arm1 != null) {
            arm1.drawMe(arg0,contactPoint.getY());
        }
        if (arm2 != null) {
            arm2.drawMe(arg0,contactPoint.getY(),point.getY(),point.getX());
        }
        if (point != null) {
            point.drawMe(arg0);
        }
        if (contactPoint != null) {
            contactPoint.drawMe(arg0);
        }
        if (armEnd != null) {
            armEnd.drawMe(arg0,contactPoint.getY(),contactPoint.getX(),arm2.getLenght(),arm2.getAngle());
        }
    }

}
