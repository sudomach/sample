
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
public class distanceconvertor {
    public static void main(String[] args) {
        JLabel kilometre = new JLabel();
        kilometre.setText("Kilometre");
        JLabel Miles = new JLabel();
        Miles.setText("Miles");
        JLabel Feet = new JLabel();
        Feet.setText("Feet");
        JLabel centimetre = new JLabel();
        centimetre.setText("Centimetre");
        JLabel millimetre = new JLabel();
        millimetre.setText("Millimetre");
        JTextField f1 = new JTextField();
        JTextField f2 = new JTextField();
        JTextField f3 = new JTextField();
        JTextField f4 = new JTextField();
        JTextField f5 = new JTextField();
        JButton convert = new JButton("CONVERT");
        convert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (f1.getText().length() > 0) {
                    double q = Double.parseDouble(f1.getText());
                    double r = q*0.6213;
                    f2.setText(r+"miles");
                    double s = q*3280.84;
                    f3.setText(s+"feet");
                    double t = q*100000;
                    f4.setText(t+"cm");
                    double u = q*1000000;
                    f5.setText(u+"mm");              
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Please enter a value in the Kilometre column.");
                }
            }
        });
         JButton clear = new JButton("CLEAR");
            clear.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            f1.setText("");
            f1.removeAll();
            f2.setText("");
            f2.removeAll();
            f3.setText("");
            f3.removeAll();
            f4.setText("");
            f4.removeAll();
            f5.setText("");
            f5.removeAll();
        }
    });
    
        JFrame frm = new JFrame("Distance Converter");
        frm.setSize(600, 400);
        frm.setResizable(false);
        frm.setLayout(new GridLayout(6, 2, 1, 1));
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.add(kilometre);
        frm.add(f1);
        frm.add(Miles);
        frm.add(f2);
        frm.add(Feet);
        frm.add(f3);
        frm.add(centimetre);
        frm.add(f4);
        frm.add(millimetre);
        frm.add(f5);
        frm.add(convert);
        frm.add(clear);
        

    }
}

    

