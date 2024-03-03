/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
import java.sql.PreparedStatement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Login extends JFrame{
   
        
   private JLabel l1,l2;
   private JTextField t1;
   private JPasswordField t2;
   private JButton b1,b2;
   
   public Login(String title){
       
        super(title);
        this.setLocation(500, 500);
        this.setSize(250,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        l1= new JLabel("login");
        l2= new JLabel("password");
        JPanel p1 = new JPanel(new GridLayout(2,1));
        p1.add(l1);
        p1.add(l2);
        
        t1=new JTextField(15);
        t2=new JPasswordField(15);
        JPanel p2 = new JPanel(new GridLayout(2,1));
        p2.add(t1);
        p2.add(t2);
        
        b1 = new JButton("Enter");
        b2 = new JButton("cancel");
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p3.add(b1);
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p4.add(b2);
        
        b1.addActionListener(new enter());
        b2.addActionListener(new Cancel());

        JPanel p=(JPanel)this.getContentPane();
        p.setLayout(new GridLayout(2,2));
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        
        //this.pack();
        this.setVisible(true);
   }
class Cancel implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
     
        Login.this.dispose();

    }
}
   class enter implements ActionListener{

    @Override
public void actionPerformed(ActionEvent e) {
    try {
        String enteredUsername = t1.getText();
        String enteredPassword = new String(t2.getPassword());

        Connection c = DriverManager.getConnection("jdbc:ucanaccess://DBlogin.accdb");
        Statement st = c.createStatement();
        String sql = "SELECT * FROM [DBlogin] WHERE UserName = '" + enteredUsername + "' AND Password = '" + enteredPassword + "'";
        ResultSet rs = st.executeQuery(sql);

        if (rs.next()) {
            String userType = rs.getString("UserType");
            if (userType.equalsIgnoreCase("Admin")) {
                new AdminPage("admin");
            } else {
                new UserPage("user");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Username or password is incorrect!");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
}
    }
