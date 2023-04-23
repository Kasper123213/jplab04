package buttons;

import main.MainFrame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel{


    private JSlider length1 = new JSlider(100, 400, 100);
    private JSlider length2 = new JSlider(100, 900, 100);
    private JSlider jump = new JSlider(1, 10, 1);
    private JSlider dDistance = new JSlider(-300, 300, -300);
    private JSlider hDistance = new JSlider(-200, 150, -200);


    private JLabel lengthlabel1, lengthlabel2, jumpLabel, dDistanceLabel, hDistanceLabel;

    private JButton startButton = new JButton("Start");



    public ButtonsPanel(){

        setLayout(new GridLayout(6,2));

        lengthlabel1 = new JLabel("Dlugosc pierwszego ramienia: "+length1.getValue());
        lengthlabel2 = new JLabel("Dlugosc drugiego ramienia: "+length2.getValue());
        jumpLabel = new JLabel("Skok: 1");
        dDistanceLabel = new JLabel("Dlugosc D: "+dDistance.getValue());
        hDistanceLabel = new JLabel("Dlugosc H: "+hDistance.getValue());


        length1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lengthlabel1.setText("Dlugosc pierwszego ramienia: "+length1.getValue());
                MainFrame.setLenght1(length1.getValue());
            }
        });
        add(length1);
        add(lengthlabel1);

        length2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lengthlabel2.setText("Dlugosc drugiego ramienia: "+length2.getValue());
                MainFrame.setLenght2(length2.getValue());
            }
        });
        add(length2);
        add(lengthlabel2);


        jump.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jumpLabel.setText("Skok: "+jump.getValue());
                MainFrame.setSpeed(jump.getValue());
            }
        });
        add(jump);
        add(jumpLabel);


        dDistance.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                dDistanceLabel.setText("Dlugosc D: "+dDistance.getValue());
                MainFrame.setD(dDistance.getValue());
            }
        });
        add(dDistance);
        add(dDistanceLabel);


        hDistance.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                hDistanceLabel.setText("Dlugosc H: "+hDistance.getValue());
                MainFrame.setH(hDistance.getValue());
            }
        });
        add(hDistance);
        add(hDistanceLabel);


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.start=true;
                MainFrame.animate();
            }
        });
        add(startButton);

    }




}
