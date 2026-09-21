/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
/**
 *
 * @author USER
 */
public class Loan_repaymentprogram {
    public static void main(String[] args) {
        
    JFrame frm = new JFrame("Loan Repayment");
    
    JLabel label = new JLabel("LOAN BORROWED(Kshs)");
    JTextField text1 = new JTextField();
    
    JButton button1 = new JButton("AMOUNT REPAYABLE AFTER INTEREST(Kshs)");
    JTextField text2 = new JTextField();
    button1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            Double q = Double.parseDouble(text1.getText());
            DecimalFormat df = new DecimalFormat("0.00");
            Double w = q*(1.043);
            text2.setText(""+df.format(w));
        }
    });    
    
    JButton button2 = new JButton("MONTHLY PAYMENTS(Kshs)");
    JTextField text3 = new JTextField();
    button2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            Double q = Double.parseDouble(text1.getText());
            Double w = q*(1.043);
            DecimalFormat df = new DecimalFormat("0.00");
            
            text2.setText(""+df.format(w));
            Double z = w/12;
            text3.setText(""+df.format(z));
        }
    });
    JButton button3 = new JButton("CLEAR");
    button3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            text1.setText("");
            text1.removeAll();
            text2.setText("");
            text2.removeAll();
            text3.setText("");
            text3.removeAll();
        }
    });
    
    frm.add(label);
    frm.add(text1);
    frm.add(button1);
    frm.add(text2);
    frm.add(button2);
    frm.add(text3);
    frm.add(button3);
    frm.setLayout(new GridLayout(4,2,5,5));
    frm.setSize(600,400);
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frm.setVisible(true);
    }
}
