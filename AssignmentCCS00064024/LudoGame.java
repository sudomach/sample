/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
/**
 *
 * @author USER
 */
public class LudoGame {
    public static void main(String[] args) {
        JFrame frm = new JFrame("Ludo");
        
        JTextField f1 = new JTextField();
        f1.setText("Random number will appear here!");
        f1.setColumns(40);
        
        JButton button = new JButton("CLICK TO GENERATE RANDOM NUMBER");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            Random peek = new Random();
            int choice = peek.nextInt(0,11);
            f1.setText(""+choice);
            }
        });
        
        frm.add(f1);
        frm.add(button);
        frm.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        frm.setSize(600,400);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
