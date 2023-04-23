package main;

import buttons.ButtonsPanel;
import chart.ChartPanel;
import objects.MyPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame {

    private JPanel contentPane;
    private static MyPanel mp;
    private static ChartPanel chX;
    private static ChartPanel chY;
    private ButtonsPanel bp;
    private static int dtime=5;
    private static int time=0;
    public static boolean start=false;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame thisClass = new MainFrame();
                thisClass.setTitle("Maszyna");
                thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thisClass.setVisible(true);

            }
        });


    }
    public static void animate() {


        Thread t = new Thread(new Runnable() {
            public void run() {
                double x1;
                double x2;
                double y1;
                double y2;
                double xVelocity;
                double yVelocity;


                while (mp.contactPoint.canMove()) {
                    x1 = mp.armEnd.getX();
                    y1 = mp.armEnd.getY();

                    mp.repaint();

                    try {
                        Thread.sleep(dtime);
                    } catch (Exception e) {}


                    mp.contactPoint.move();
                    time+=1;



                    x2 = mp.armEnd.getX();
                    y2 = mp.armEnd.getY();

                    xVelocity=(x2-x1)/dtime;
                    yVelocity=(y2-y1)/dtime;

                    chX.addV(time, xVelocity);
                    chY.addV(time,yVelocity);

                    chX.repaint();
                    chY.repaint();


                }

            }
        });
        t.start();
    }


    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new GridLayout(2,3));
        setContentPane(contentPane);


        chX = new ChartPanel("Vx(t)");
        contentPane.add(chX);


        bp = new ButtonsPanel();
        contentPane.add(bp);


        chY = new ChartPanel("Vy(t)");
        contentPane.add(chY);


        mp = new MyPanel();
        contentPane.add(mp);

    }

    public static void setSpeed(int speed) {
        mp.contactPoint.setSpeed(speed);
        mp.repaint();
    }
    public static void setLenght1(int lenght) {
        mp.arm1.setLenght(lenght);
        mp.contactPoint.setBorders(lenght);
        mp.repaint();
    }
    public static void setLenght2(int lenght) {
        mp.arm2.setLenght(lenght);
        mp.repaint();
    }

    public static void setD(int d) {
        mp.point.setD(d);
        mp.repaint();
    }

    public static void setH(int h) {
        mp.point.setH(h);
        mp.repaint();
    }



}
