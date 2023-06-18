/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuketoan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Thanh
 */
public class CheckCondition {
    
    public String inputString(Scanner sc, String s){
        String x;
        if (!"".equals(s)) {
          System.out.println("Input " + s + ":");
        }
        do {
            x = sc.nextLine();
            if(x.isEmpty()){
            System.out.println("Data has no value, enter again: ");
            }
        } while (x.isEmpty());
        return x;
    }
    public int inputInteger(Scanner sc, String s){
        int x;
        boolean cont;
        if (!"".equals(s)) {
          System.out.println("Input " + s + ":");
        }
        do {
            x = sc.nextInt();            
            try {
                cont = false;
            } catch (Exception e) {
                System.out.println("Value is not integer, please try again: ");
                cont = true;
            }
        } while (cont);
        
        return x;
        
    }
    public double inputDouble(Scanner sc, String s){
        double x;
        boolean cont;
        if (!"".equals(s)) {
          System.out.println("Input " + s + ":");
        }
        do {
            x = sc.nextDouble();            
            try {
                cont = false;
            } catch (Exception e) {
                System.out.println("Value is not integer, please try again: ");
                cont = true;
            }
        } while (cont);
        
        return x;
    }
   
    public String inputId(Scanner sc){
        System.out.println("Enter ID: ");
        String s;
        boolean cont;
        do{
        s = inputString(sc, "");
        try {
            String pattern = ("^SE[0-9]{6}");
            if(!s.matches(pattern)){
                throw new Exception();
            }
            cont = false;
        } catch (Exception e) {
            System.out.println("Input follow format SE******");
            cont = true;
        }

        } while(cont == true);
        return s;
    }
    
    public Date inputDate(Scanner sc){
        System.out.println("Enter birthday (dd/MM/yyyy): ");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        boolean cont;
        String s;
        Date x = null;
        format.setLenient(false);
        do {
            try {
                x = format.parse(inputString(sc, ""));
                cont = false;
            } catch (ParseException e) {
                System.out.println("Input follow format dd/MMMM/yyyy");
                cont = true;
            }
    
        } while (cont == true);
        
        return x;
    }
    
    public String inputName(Scanner sc, String s){
        System.out.println("Enter " + s + ":");
        String x;
        do {            
            x = inputString(sc, "");
            String[] names = x.split(" ");     //tách thành mảng chuỗi các kí tự phân biệt khoảng trắng
            StringBuilder sb = new StringBuilder();
            for(String name : names){
                sb.append(name.substring(0, 1).toUpperCase()).append(name.substring(1)).append(" ");
            }
            x = sb.toString().trim();
        } while ("".equals(x));
        return x;
    }
    
    public boolean inputGender(Scanner sc){
        System.out.println("Input Gender(1/Enter-Male, 0-Female)");
        String x;
        boolean cont = true;
        do {            
            x = inputString(sc, "");
            switch (x) {
                case "0":
                    cont = false;
                    break;
                case "1":
                    cont = true;
                    break;
                default:
                    System.out.println("Try again: ");
                    break;
            }
        } while (!"1".equals(x) && !"0".equals(x));
        return cont;
    }
    
    public int inputReward(Scanner sc){
        System.out.println("Input reward: ");
        int x;
        do {  
            x = inputInteger(sc, "");
            if(x <= 0){
                System.out.println("Data can not be excepted, try again: ");
            } 
        } while (x <= 0);
        return x;
    }
    public double  inputSalary(Scanner sc){
        System.out.println("Input Salary: ");
        double x;
        do {  
            x = inputDouble(sc, "");
            if(x <= 0){
                System.out.println("Data can not be excepted, try again: ");
            } 
        } while (x <= 0);
        return x;
    }
    public String inputPhone(Scanner sc){
        System.out.println("Enter Phone: ");
        String s;
        boolean cont;
        do{
        s = inputString(sc, "");
        try {
            String pattern = ("^0[0-9]{9}");
            if(!s.matches(pattern)){
                throw new Exception();
            }
            cont = false;
        } catch (Exception e) {
            System.out.println("Input follow format SE******");
            cont = true;
        }

        } while(cont == true);
        return s;
    }
    
}
