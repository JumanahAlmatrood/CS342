/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
import java.io.Serializable;


public class Person implements Serializable  {
    private String firstname, grade;
    
    
    public Person(String fn, String gr){
        firstname = fn;
        grade = gr; 
    }
    
    @Override
    public String toString(){
        return (this.firstname +" " + this.grade);
    }
}

