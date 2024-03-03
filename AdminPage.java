/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AdminPage extends JFrame{
    
    private JLabel l1;
    private JTextField t1;
    private JTextArea a1;
    private JButton b1,b2,b3,b4;
    
    
    public AdminPage(String title){
        super(title);
        this.setSize(400, 300);///////
        this.setLocation(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
          // Menu bar
        JMenuBar Men1 = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        Men1.add(fileMenu);
        setJMenuBar(Men1);
        
        
        // Text field for title
        JPanel p1 = new JPanel();
        l1 = new JLabel("Title:");
        t1 = new JTextField(20);
        p1.add(l1);
        p1.add(t1);
        
         // Text area for the main text
        a1 = new JTextArea();
        JScrollPane p2 = new JScrollPane(a1);

       //buttons
        
        b1 = new JButton("save");
        b2 = new JButton("search");
        b3 = new JButton("Clear");
        b4 = new JButton("statistics");
        
   
        
        JPanel p3 = new JPanel();
        p3.add(b1);
        p3.add(b2);
        p3.add(b3);
        p3.add(b4);
        
      
        
        b1.addActionListener(new SaveBut());
        b2.addActionListener(new SearchBut());
        b3.addActionListener(new ClearBut());
        b4.addActionListener(new StatBut());
        
         // Layout
        getContentPane().add(p1, "North");
        getContentPane().add(p2, "Center");
        getContentPane().add(p3, "South");
      
         // this.pack();
        this.setVisible(true);
        
    }
    
    class SaveBut implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            try{
               String filename = t1.getText() +".txt";
               String filecontent = a1.getText();
               String[] lines = filecontent.split("\\r?\\n");
               
               BufferedWriter file = new BufferedWriter(new FileWriter(filename, true));
               for(String line : lines){
                   file.append(line);
                   file.newLine();
               }
               file.close();               
               JOptionPane.showMessageDialog(null, "file saved successfully ");

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error writing user information to file.");
            }
        }
    
    }
    
    class ClearBut implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            
            t1.setText("");
            a1.setText("");
            
            
        }
    }
    class SearchBut implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            
            SearchPage p = new SearchPage("Search Page");
            
            
        }
    }
    class StatBut implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            
            StaticPage p = new StaticPage("Search Page");
            
            
        }
    }
    
}
