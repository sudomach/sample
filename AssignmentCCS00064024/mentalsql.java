package com.mycompany.userinterface;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;



public class mentalsql {
    public static void main(String[] args) {
        JFrame frm = new JFrame("sql");
        JLabel label = new JLabel("Fill the following form and add to database:");
        JPanel form = new JPanel();
        JLabel fn = new JLabel("First Name");
        JTextField tf1 = new JTextField();
        tf1.setColumns(20);
        JLabel ln = new JLabel("Last Name");
        JTextField tf2 = new JTextField();
        tf2.setColumns(20);
        JLabel adm = new JLabel("Admission");
        JTextField tf3 = new JTextField();
        tf3.setColumns(20);        
        JLabel mail = new JLabel("Email Account");
        JTextField tf4 = new JTextField();
        tf4.setColumns(20);        
        JLabel marks = new JLabel(" Cat Marks");
        JTextField tf5 = new JTextField();
        tf5.setColumns(20);
        form.setLayout(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy =0;
        form.add(fn,gbc1);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 1;
        gbc2.gridy =0;        
        form.add(tf1,gbc2);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy =1;        
        form.add(ln,gbc3);
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 1;
        gbc4.gridy =1;        
        form.add(tf2,gbc4);
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 0;
        gbc5.gridy =2;        
        form.add(adm,gbc5);
        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 1;
        gbc6.gridy =2;        
        form.add(tf3,gbc6);
        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx = 0;
        gbc7.gridy =3;        
        form.add(mail,gbc7);
        GridBagConstraints gbc8 = new GridBagConstraints();
        gbc8.gridx = 1;
        gbc8.gridy =3;        
        form.add(tf4,gbc8);
        GridBagConstraints gbc9 = new GridBagConstraints();
        gbc9.gridx = 0;
        gbc9.gridy =4;        
        form.add(marks,gbc9);
        GridBagConstraints gbc10 = new GridBagConstraints();
        gbc10.gridx = 1;
        gbc10.gridy =4;        
        form.add(tf5,gbc10);
        JLabel formlabel = new JLabel();
        formlabel.setText("Status of actionPerformed will be displaying here!");
        formlabel.setForeground(Color.blue);
        GridBagConstraints gbc11 = new GridBagConstraints();
        gbc11.gridx=0;
        gbc11.gridy=5;
        gbc11.gridwidth=2;
        form.add(formlabel,gbc11);
        JPanel panelButton = new JPanel();
        JButton insert = new JButton("ADD TO DATABASE");
        insert.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                   String url = "jdbc:mysql://localhost:3306/MCS";
        String username="root";
        String password ="Codewar@kyu1";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username,password);
                Statement statement=conn.createStatement();
                String sql;
                if(tf3.getText().length()>0 && tf1.getText().length()>0
                        && tf2.getText().length()>0 && tf4.getText().length()>0
                        && tf5.getText().length()>0){
                String fname = tf1.getText();
                String lname = tf2.getText();
                String adm  = tf3.getText();
                String email = tf4.getText();
                int marks = Integer.parseInt(tf5.getText());
                
                sql ="INSERT INTO catRecords VALUES('"+fname+"','"+lname+"','"+adm+"','"+email+"',"+marks+")";
                statement.executeUpdate(sql);
                formlabel.setForeground(Color.green);
                formlabel.setText("Data was added successfully.");
                }else{
                    formlabel.setForeground(Color.red);
                    formlabel.setText("*Must Enter data in all field to add to Database.*");
                }
                      
        }
        catch(ClassNotFoundException | SQLException f){
            f.printStackTrace();
        }
            
            }
        });
        JButton retrieve = new JButton("GET DATABASE");
        retrieve.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String url ="jdbc:mysql://localhost:3306/MCS";
                String username = "root";
                String password = "Codewar@kyu1";
                try{
                Class.forName("com.mysql.jdbc.Driver");
                try(Connection conn = DriverManager.getConnection(url,username,password)){
                    Statement stmt = conn.createStatement();
                    String sql = "Select * from catRecords";
                    ResultSet  result =stmt.executeQuery(sql);
                    while(result.next()){
                        String first = result.getString("firstName");
                        String second = result.getString("lastName");
                        String adms = result.getString("admission");
                        String emailacct = result.getString("emailAcct");
                        String catmark = result.getString("catMarks");
                        System.out.println(first+"\t\t\t"+second+"\t\t"+adms+"\t"+emailacct+"\t\t"+catmark);
                        
                    }
                    formlabel.setForeground(Color.green);
                    formlabel.setText("Database was retrieved sucessfully");
                }
                }catch(Exception error){
                    System.out.println(error);
                    formlabel.setForeground(Color.red);
                    formlabel.setText("Error acquired! Check code for BUgs");
                }
            }
        });
        panelButton.add(insert);
        panelButton.add(retrieve);   
        
        frm.add(label, BorderLayout.NORTH);
        frm.add(form,BorderLayout.CENTER);
        frm.add(panelButton,BorderLayout.SOUTH);
        frm.setSize(700,500);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        frm.setVisible(true);
    }
    
}
