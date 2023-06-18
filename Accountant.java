/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuketoan;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Thanh
 */
public class Accountant extends Person implements Working, Comparable<Object>{
    double basicSalary;
    int reward;

    public Accountant() {
        
    }

   
    
    

    public Accountant(String id, String firstName, String sureName, Date birthday, boolean gender, String phone, double basicSalary, int reward) {
        super(id, firstName, sureName, birthday, gender, phone);
        this.basicSalary = basicSalary;
        this.reward = reward;
    }


    
    
    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }
    
    @Override
    public double earnMoney(){
        return this.basicSalary + this.reward;
    }
    @Override
    public double tax(){
        double t;
        if(earnMoney() < 1000){
            t = 0;
        }
        else if(earnMoney()<3000){
            t = (earnMoney()-1000+1)*0.1;
        }
        else{
            t = 1000*0.1 + (earnMoney()-3000+1)*0.25;
        }
        
        return t;
    }
    
    @Override
    public String toString(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%6s|%6s|%6s|%6s|%3s|%6s|%9s|%6s", this.id, this.firstName, this.sureName, format.format(this.birthday), (this.gender?"Nam":"Nữ"), this.phone, this.basicSalary, this.reward);
    }

    @Override
    public int compareTo(Object o) {
        return this.getFirstName().compareToIgnoreCase(((Accountant)o).getFirstName());
    }
    
    public static Comparator compareMoney = new Comparator<Accountant>() {
        @Override
        public int compare(Accountant acc1, Accountant acc2) {
            int result = 0;
            
            if (acc1.basicSalary<acc2.basicSalary) {
                result = 1;
            }
            else if(acc1.basicSalary>acc2.basicSalary){
                result = -1;
            }
            else{
                return acc1.getBirthday().compareTo(acc2.getBirthday());
            }

            return result;
        }
    };
}
