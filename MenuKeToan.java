/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuketoan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thanh
 */
public class MenuKeToan {
    private static String Menu(Scanner sc){
        String s;
        System.out.println("1. Add accountant information");
        System.out.println("2. Show all accountants");
        System.out.println("3. Filter accountants by high salary");
        System.out.println("4. Find accountant by ID");
        System.out.println("5. Find accountant by firstName");
        System.out.println("6. Delete an accountant(ID)");
        System.out.println("7. Update the information of an accountant");
        System.out.println("8. Sort accountant by First Name");
        System.out.println("9. Sort Salary(DES), then birthday(ASC)");
        System.out.println("10. Quit");
        System.out.println("Input choose: ");
        s = sc.nextLine();
        return s;
    }

    private static void inputInformation(Scanner sc, List<Accountant> ds) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat();
        Accountant x = new Accountant();
        CheckCondition condition = new CheckCondition();
        x.setId(condition.inputId(sc));
        x.setFirstName(condition.inputName(sc, "First name"));
        x.setSureName(condition.inputName(sc, "Sure name"));
        x.setBirthday(condition.inputDate(sc));
        x.setGender(condition.inputGender(sc));
        x.setBasicSalary(condition.inputSalary(sc));
        x.setReward(condition.inputReward(sc));
        sc.nextLine();
        x.setPhone(condition.inputPhone(sc));
        ds.add(x);
    }
    
    private static void showAll(List<Accountant> ds){
        for(Accountant i : ds){
            System.out.println(i.toString());
        }
    }
    
    private static void highSalary(List<Accountant> ds){
        for(Accountant i : ds){
            if(i.earnMoney()>=3000){
                System.out.println(i.firstName + " " + i.sureName + " | " + i.earnMoney());
            }
        }
    }
    private static void findId(Scanner sc, List<Accountant> ds){
        System.out.println("ID to find: ");
        String s = sc.nextLine();
        for(Accountant i : ds){
            if(i.id.equals(s)){
                System.out.println(i.toString());
            }
        }
    }
    private static void findFirstName(Scanner sc, List<Accountant> ds){
        System.out.println("First Name to find: ");
        String s = sc.nextLine();
        for(Accountant i : ds){
            if(i.id.equals(s)){
                System.out.println(i.toString());
            }
        }
    }
    
    private static void deleteID(Scanner sc, List<Accountant> ds){
        boolean cont = true;           
            System.out.println("ID of Accountant to delete: ");
            String s = sc.nextLine();
            System.out.println("Please confirm again: ");
            String s2 = sc.nextLine();
            int x = ds.size();
            int count = 0;
            for (int i = 0; i < ds.size(); i++) {
                    if(s.equals(s2) && s.equals(ds.get(i).getId())){
                        ds.remove(ds.get(i));
                        break;
                    }
                    else if(s.equals(s2) && !s.equals(ds.get(i).getId())){
                        count++;
                    }
                }
            if(count == x){
                System.out.println("Don't exit this ID");
            }
    }
    
    private static void editInfo(Scanner sc, List<Accountant> ds) throws ParseException{
        System.out.println("ID you need edit: ");
        String s = sc.nextLine();
        System.out.println("1-ID |  2-First name  |  3-Sure name  |  4-Birthday  |  5-Gender  |  6-Salary  |  7-Reward  |  8-Phone  |  9-All");
        System.out.println("Data you need edit: ");
        int n = sc.nextInt();
        SimpleDateFormat format = new SimpleDateFormat();
        CheckCondition condition = new CheckCondition();
        for(int i = 0; i < ds.size(); i++){
            if(s.equals(ds.get(i).getId())) {
                switch(n){
                    case 1:   sc.nextLine();
                              ds.get(i).setId(condition.inputId(sc));
                              break;
                    case 2:   ds.get(i).setFirstName(condition.inputName(sc, "First name"));
                              break;
                    case 3:   ds.get(i).setSureName(condition.inputName(sc, "Sure name"));
                              break;
                    case 4:   ds.get(i).setBirthday(condition.inputDate(sc));
                              break;
                    case 5:   ds.get(i).setGender(condition.inputGender(sc));
                              break;
                    case 6:   ds.get(i).setBasicSalary(condition.inputSalary(sc));
                              break;
                    case 7:   ds.get(i).setReward(condition.inputReward(sc));
                              break;
                    case 8:   ds.get(i).setPhone(condition.inputPhone(sc));
                              break;
//                    case 9:   inputInformation(sc, ds);
//                              break;
                    
                }   
            }
        }

    }
    private static void sortByName(Scanner sc, List<Accountant> ds){

        System.out.println("Choose sort way(1-Ascending | 2-Decreasing): ");
        CheckCondition cont = new CheckCondition();
//        sc.nextLine();
        int orderType = cont.inputInteger(sc, "");
        if (orderType==1) {
            Collections.sort(ds);
        } else {
            Collections.sort(ds, Collections.reverseOrder());
        }
        sc.nextLine();
        showAll(ds);
    }
    
    private static void sortbyFirstName(List<Accountant> ds){
        Collections.sort(ds);
        showAll(ds);
    }
    
    private static void sortSalary(List<Accountant> ds){
        Collections.sort(ds, Accountant.compareMoney);
        showAll(ds);
    }
    
    
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String choose;
        List<Accountant> ds = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String s = "12/02/2022";
        Date date = format.parse(s);
        Accountant x = new Accountant("SE171763", "vo", "tung", date, true, "0918129118", 10000, 300);
        ds.add(x);
        s = "12/01/2021";
        date = format.parse(s);
        x = new Accountant("SE171769", "nguyen", "tung", date, true, "0328588985", 10000, 200);
        ds.add(x);
        s = "22/02/2020";
        date = format.parse(s);
        x = new Accountant("SE171769", "le", "cam", date, false, "0123456789", 1000, 900);
        ds.add(x); 
        
        do {
            choose = Menu(sc);
            switch(choose){
                case "1":   inputInformation(sc, ds);
                            break;
                case "2":   showAll(ds);
                            break;  
                case "3":   highSalary(ds);
                            break;
                case "4":   findId(sc, ds);
                            break;
                case "5":   findFirstName(sc, ds);
                            break;
                case "6":   deleteID(sc, ds);
                            break;
                case "7":   editInfo(sc, ds);
                            break;
                case "8":   sortByName(sc, ds);
                            break;
                case "9":   sortSalary(ds);
                            break;
            }
        } while (!choose.equals("10"));
    }
    
}
