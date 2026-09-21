
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
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
public class BmAdvisor {
     public static void main(String[] args) {
        JLabel weight = new JLabel();
        weight.setText("Weight(kg)");
        JLabel height = new JLabel();
        height.setText("Height(m)");
        JTextField f1 = new JTextField();
        JTextField f2 = new JTextField();

        JButton convert = new JButton("CHECK STATUS");
        convert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (f1.getText().length() > 0) {
                    double q = Double.parseDouble(f1.getText());
                if (f2.getText().length()>0){
                    double r = Double.parseDouble(f2.getText());
                    
                   double BMI = q/(r*r);
                   DecimalFormat df = new DecimalFormat("0.00");
                   String BMI_con = df.format(BMI);
                   if(BMI<18.5){
                   JOptionPane.showMessageDialog(null,"Your BMI= "+BMI_con+"\nYou are UnderWeight");
                   }else if(BMI>=18.5 && BMI<25){
                   JOptionPane.showMessageDialog(null,"Your BMI= "+BMI_con+"\nYou have normal weight");
                   }else if(BMI>=25.9 && BMI<30){
                   JOptionPane.showMessageDialog(null,"Your BMI= "+BMI_con+"\nYou are Overweight");
                   }else if(BMI>=30){
                   JOptionPane.showMessageDialog(null,"Your BMI= "+BMI_con+"\nYou are obese");
                   }
                   
                }
                                   
                }
            }
        });
         JButton button3 = new JButton("CLEAR");
    button3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            f1.setText("");
            f1.removeAll();
            f2.setText("");
            f2.removeAll();
            
        }
    });
    

        JFrame frm = new JFrame("BM ADVISOR");
        frm.setSize(600, 400);
        frm.setResizable(false);
        frm.setLayout(new FlowLayout());
        frm.setLayout(new GridLayout(4, 2, 1, 1));
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.add(weight);
        frm.add(f1);
        frm.add(height);
        frm.add(f2);
        frm.add(convert);
        frm.add(button3);

    }
}


