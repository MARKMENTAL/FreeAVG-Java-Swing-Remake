import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class CoreFrame extends Frame implements ActionListener {
    JButton calc, close;
    JTextField atbatstxt, hitstxt;
    JLabel batlbl, hitslbl;

    CoreFrame() {
        batlbl = new JLabel("atbats:");
        hitslbl = new JLabel("hits:");
        batlbl.setBounds(50, 70, 250, 30);
        hitslbl.setBounds(50, 126, 250, 30);
        setTitle("FreeAVG Java Swing Remake");
        calc = new JButton("Calculate Batting Average");
        close = new JButton("Close");
        close.setBounds(240, 320, 100, 20);
        calc.setBounds(50, 190, 250, 30);
        calc.setBackground(new Color(179, 203, 150));
        close.setBackground(new Color(239, 191, 210));

        calc.addActionListener(this);
        //embedded action listeners to close the program with both the window button
        //and the JButton
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        add(calc);
        add(close);
        add(batlbl);
        add(hitslbl);
        atbatstxt = new JTextField("Type the Number of atbats here");
        hitstxt = new JTextField("Type the Number of hits here");
        atbatstxt.setBounds(50, 100, 250, 30);
        hitstxt.setBounds(50, 150, 250, 30);
        add(atbatstxt);
        add(hitstxt);
        setSize(350, 350);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Double atbatsdbl = Double.parseDouble(atbatstxt.getText());
            Double hitsdbl = Double.parseDouble(hitstxt.getText());
            Double avg = hitsdbl / atbatsdbl;
            DecimalFormat df = new DecimalFormat(".###");
            JOptionPane.showMessageDialog(null,
                    "The player's batting average is: " + df.format(avg));
            if (avg > .29) {
                JOptionPane.showMessageDialog(null,
                        "Your player is a real slugger!");
            }
            if (avg < .2) {
                JOptionPane.showMessageDialog(null,
                        "Your player could work on their swing...");
            }
            if (avg >= .2 && avg < .3) {
                JOptionPane.showMessageDialog(null,
                        "Your player's batting average is indeed average");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter Appropriate Input");
            atbatstxt.setText("0");
            hitstxt.setText("0");
        }
    }
}