/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class StaticPage extends JFrame {
    private JLabel l1;
    private JTextField t1;
    private JButton b1;
    
    public StaticPage(String title){
        super(title);
        this.setLocation(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        l1=new JLabel("File to statistic");
        t1 = new JTextField(10);
        b1 = new JButton("Calculate");
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(l1);
        p1.add(t1);
        p1.add(b1);
        
        JPanel p=(JPanel)this.getContentPane();
        p.setLayout(new GridLayout());
        p.add(p1);
        
        this.pack();
        this.setVisible(true);
        
        b1.addActionListener(new ClacBut());
    }
    class ClacBut implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
            BufferedReader reader;
            String title = t1.getText()+".txt";
            String firstname, grade, line, arr[], message;
            int pass= 0;
            int fail = 0;
            Person p;
            
            try{
               reader = new BufferedReader(new FileReader(title));
               
               while((line = reader.readLine()) != null){
                   arr = line.split(" ");
                   firstname = arr[0];
                   grade = arr[1];

                   p = new Person(firstname,grade);
                   if( Integer.parseInt(arr[1]) >= 10){
                       pass++;
                   }else{
                       fail++;
                   }
                
               }
               message = "Number of students who pass : " + pass +"\nNumber of students who fail : " + fail ;
               JOptionPane.showMessageDialog(null, message, "Statistic", JOptionPane.INFORMATION_MESSAGE);
               reader.close();
            } catch(FileNotFoundException x){
                System.out.println("eer1");
            } catch(IOException x){
                System.out.println("eer2");
            } catch(NumberFormatException x){
                System.out.println("eer3");
            }
        }
    }
}
