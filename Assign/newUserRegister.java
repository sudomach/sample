/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.speedtestproject;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author USER
 */
public class newUserRegister {
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JTextField tf4;
    private JTextField tf5;
    private JTextField tf6;
    private ResultSet result;
    private Statement stmt;
    private Connection conn;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new newUserRegister().initiateGUI();
        });
        
    }
    public void initiateGUI(){
         String url ="jdbc:mysql://localhost:3306/MCS";
                String username = "root";
                String password = "Codewar@kyu1";
                try{
                Class.forName("com.mysql.jdbc.Driver");
                 conn = DriverManager.getConnection(url,username,password);
                     stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    String sql = "Select * from register";
                    result =stmt.executeQuery(sql);
                   
                   
             
                
            JFrame frm = new JFrame("UserRegister");
            JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();
            JPanel panel3 = new JPanel();

            frm.add(panel1,BorderLayout.NORTH);
            JLabel header = new JLabel();
            header.setText("<HTML><font size='12'>New User Register</font></HTML>");
            panel1.add(header);
            frm.add(panel2,BorderLayout.CENTER);
            JLabel plabel = new JLabel("First name");
            JLabel plabel2 = new JLabel("Username");
            JLabel plabel3 = new JLabel("Last name");
            JLabel plabel4 = new JLabel("Password");
            JLabel plabel5 = new JLabel("Email address");
            JLabel plabel6 = new JLabel("Mobile number");
            tf1 = new JTextField();
            tf1.setColumns(10);
            tf2 = new JTextField();
            tf2.setColumns(10);
            tf3 = new JTextField();
            tf3.setColumns(10);
            tf4 = new JTextField();
            tf4.setColumns(10);
            tf5 = new JTextField();
            tf5.setColumns(10);
            tf6 = new JTextField();
            tf6.setColumns(10);

            panel2.setLayout(new GridLayout(3,4,10,10));
            panel2.add(plabel);
            panel2.add(tf1);
            panel2.add(plabel2);
            panel2.add(tf2);
            panel2.add(plabel3);
            panel2.add(tf3);
            panel2.add(plabel4);
            panel2.add(tf4);
            panel2.add(plabel5);
            panel2.add(tf5);
            panel2.add(plabel6);
            panel2.add(tf6);



            frm.add(panel3,BorderLayout.SOUTH);
            JButton button1 = new JButton("Register");
            JButton button2 = new JButton("Delete");
            JButton button3 = new JButton("Next");
            JButton button4 = new JButton("Previous");
            JButton button5 = new JButton("Exit");
            panel3.add(button1);
            JLabel formlabel = new JLabel();
            button1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                     String url = "jdbc:mysql://localhost:3306/MCS";
            String username="root";
            String password ="Codewar@kyu1";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(url,username,password);
                    Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    String sql;
                    if(tf3.getText().length()>0 && tf1.getText().length()>0
                            && tf2.getText().length()>0 && tf4.getText().length()>0
                            && tf5.getText().length()>0 && tf6.getText().length()>0){
                    String fname = tf1.getText();
                    String username1 = tf2.getText();
                    String lname  = tf3.getText();
                    String password1 = tf4.getText();
                    String email = tf5.getText();
                    String mobile = tf6.getText();

                    sql ="INSERT INTO register VALUES('"+fname+"','"+lname+"','"+username1+"','"+password1+"',"
                            + "'"+email+"','"+mobile+"')";
                    statement.executeUpdate(sql);

                    tf1.removeAll();
                    tf1.setText("");
                    tf2.removeAll();
                    tf2.setText("");
                    tf3.removeAll();
                    tf3.setText("");
                    tf4.removeAll();
                    tf4.setText("");
                    tf5.removeAll();
                    tf5.setText("");
                    tf6.removeAll();
                    tf6.setText("");

                    }
            }
        catch(ClassNotFoundException | SQLException f){
            f.printStackTrace();
        }
            
            
            }
        });
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    JOptionPane.showMessageDialog(null, "This Record will be deleted parmanently from DB");
                    result.deleteRow();
                    if(result.next()) displayRow(result);
                    else if(result.previous()) displayRow(result);
                    else{
                    tf1.removeAll();
                    tf1.setText("");
                    tf2.removeAll();
                    tf2.setText(""); 
                    tf3.removeAll();
                    tf3.setText("");
                    tf4.removeAll();
                    tf4.setText("");
                    tf5.removeAll();
                    tf5.setText("");
                    tf6.removeAll();
                    tf6.setText("");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(newUserRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    if(result.next() && !result.isClosed()){
                    displayRow(result);}
                } catch (SQLException ex) {
                    Logger.getLogger(newUserRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        });
         button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    if (result.previous() && !result.isClosed()){
                        displayRow(result);
                    }  } catch (SQLException ex) {
                    Logger.getLogger(newUserRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        });
       
        button5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frm.dispose();
            }
        });
        panel3.add(button2);
        panel3.add(button3);
        panel3.add(button4);
        panel3.add(button5);
        
        
        frm.setSize(800,300);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setResizable(false);
                    System.out.println(result.isClosed());
                
                }catch(Exception error){
                    System.out.println(error);
                    
                }
        
    }
    public  void displayRow(ResultSet rs)throws SQLException{
    
                        tf1.setText( rs.getString("fname"));
                        tf2.setText(rs.getString("username"));
                        tf3.setText(rs.getString("lname"));
                        tf4.setText(rs.getString("password"));
                        tf5.setText(rs.getString("email"));
                        tf6.setText(rs.getString("mobile"));
    }
}
