/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class SearchPage extends JFrame {
    private JLabel l1,l2;
    private JTextField t1,t2;
    private JTextArea a1;
    private JButton b1,b2,b3;
    
    
    public SearchPage(String title){
        super(title);
        this.setLocation(300,300);
        this.setSize(700, 500);///////
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel p1 = new JPanel();
        l1 = new JLabel("File to search");
        t1 = new JTextField(20);
        p1.add(l1);
        p1.add(t1);
       
        JPanel p2 = new JPanel();
        l2 = new JLabel("Keyword");
        t2 = new JTextField(20);
        p2.add(l2);
        p2.add(t2);
        
       
        
          //buttons
        
        b1 = new JButton("Search");
        b2 = new JButton("Clear");
        b3 = new JButton("Cancel");
      
      //  JPanel p3 = new JPanel();
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        
             // Text area for the main text
     //   a1 = new JTextArea();
        a1 = new JTextArea(25, 40); 
        JScrollPane p4 = new JScrollPane(a1);
        
   
        
        getContentPane().add(p1, "North");
        getContentPane().add(p2, "Center");
        getContentPane().add(p4, "South");
      
      
        
        b1.addActionListener(new SearchBut()); 
        b2.addActionListener(new ClearButo());
        b3.addActionListener(new CancelButo());
        
       //  this.pack();
        this.setVisible(true);
    
    }
    class ClearButo implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            
            t1.setText("");
            t2.setText("");
            a1.setText("");
            
            
        }
    }
    
    class SearchBut implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
            BufferedReader reader;
            String title = t1.getText()+".txt";
            String keyword = t2.getText();
            String firstname, grade, line, arr[];
            Person p;
            
            try{
               reader = new BufferedReader(new FileReader(title));
               
               while((line = reader.readLine()) != null){
                   arr = line.split(" ");
                   firstname = arr[0];
                   grade = arr[1];

                   p = new Person(firstname,grade);
                   if(arr[0].equals(keyword) || arr[1].equals(keyword) ){
                       a1.append(line + "\n");
                   }
                
               } 
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
    class CancelButo implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            
            System.exit(0);
            
            
        }
    }
}
