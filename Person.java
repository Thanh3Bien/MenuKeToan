/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuketoan;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Thanh
 */
public class Person {
    String id;
    String name;
    String firstName;
    String sureName;
    Date birthday;
    boolean gender;
    String phone;
    
    public Person(){

        this.id = "";
        this.name = "";
        this.firstName = "";
        this.sureName = "";
        this.birthday = null;
        this.gender = true;
        this.phone = "";
    }

    public Person(String id, String firstName, String sureName, Date birthday, boolean gender, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.sureName = sureName;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public String toString(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%6s|%6s|%6s|%6s|%6s|%6s", this.id, this.firstName, this.sureName, format.format(this.birthday), (this.gender?"Nam":"Nữ"), this.phone);
    }
    
    
}
