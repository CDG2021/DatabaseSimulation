/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fall2020project;

import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Carlos Garcia
 */
public class Option {
    boolean control = true;
    int choice;
    String choiceCheck;
    public void choices(DLinkedList my) throws IOException
    {   while(control != false)
        {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Press 1 to insert a new record, 2 to delete a record, 3 to list all current by original input, 4 for order by ID GPA or birthday, 5 to list all student in a given major or a given ID, or type 6 to terminate and save Data");
            choiceCheck = keyboard.nextLine();
            
            while(!choiceCheck.matches("[0-9]+")){
                System.out.print("Please input a valid choice: ");
                choiceCheck = keyboard.nextLine();
            }
            choice = Integer.parseInt(choiceCheck);
            
            if(choice == 6)
            {
                control = false;
            }
            else if(choice == 1){
                String ID;
                System.out.print("Please input the 8 digit ID: ");
                ID = keyboard.nextLine(); 
                
                if(ID.length() == 8 && ID.matches("[0-9]+"))
                {
                    if(my.checkIfUsed(Integer.parseInt(ID)) == false) ID = "0";
                }
                while(ID.length() != 8 || !ID.matches("[0-9]+"))
                {
                    System.out.print("Please enter a valid 8 digit ID and one that hasn't been used: ");
                    ID = keyboard.nextLine();
                    if(ID.matches("[0-9]+") && ID.length() == 8)
                    {
                        if(my.checkIfUsed(Integer.parseInt(ID)) == false) ID = "0";
                    }
                }
                
                System.out.print("Please input the first name: ");
                String fName = keyboard.nextLine();
                while(!fName.matches("[a-zA-Z]+"))
                {
                    System.out.print("Please input a valid first name: ");
                    fName = keyboard.nextLine();
                }
                
                System.out.print("Please input the last name: ");              
                String lName = keyboard.nextLine();
                 while(!lName.matches("[a-zA-Z]+"))
                {
                    System.out.print("Please input a valid last name: ");
                    lName = keyboard.nextLine();
                }
                 
                System.out.print("Please input a 10 digit phone number: ");
                String phoneNumber = keyboard.nextLine();
                while(phoneNumber.length() != 10 || !phoneNumber.matches("[0-9]+"))
                {
                    System.out.print("Please enter a valid 10 digit phone number: ");
                    phoneNumber = keyboard.nextLine();
                }
                
                System.out.print("Please input Major: ");
                String major = keyboard.nextLine();
                while(!major.matches("[a-zA-Z ]+"))
                {
                    System.out.print("Please input a valid major: ");
                    major = keyboard.nextLine();
                }
                
                System.out.print("Please enter GPA(based on a 4.00 scale): ");
                String gpa = keyboard.nextLine();
                double GPA;
                boolean boss = true;
                try{
                    GPA = Double.parseDouble(gpa);
                }
                catch(NumberFormatException e){
                    boss = false;
                }
               if(boss == true)
               {
                   if(Double.parseDouble(gpa) > 4 || Double.parseDouble(gpa) < 0)
                   {
                     boss = false;
                   }
               }
                while(boss != true){
                    System.out.print("Please input a valid GPA: ");
                    gpa = keyboard.nextLine();
                    try{
                        GPA = Double.parseDouble(gpa);
                        boss = true;
                    }
                    catch(NumberFormatException e){
                        System.out.println("Not valid!");
                        boss = false;
                    }
                    if(boss == true)
                    {
                        if(Double.parseDouble(gpa) > 4 || Double.parseDouble(gpa) < 0)
                        {
                            boss = false;
                        }
                    }
                }
                GPA = Double.parseDouble(gpa);
                boolean confirmation = false, verification = false;
                int direction, yob = 0, mob = 0, dob = 0;
                String numberCheck;
                while(confirmation == false){
                    System.out.print("Please enter the year of birth: ");
                    numberCheck = keyboard.nextLine();
                    while(verification != true)
                    {
                        try{
                            yob = Integer.parseInt(numberCheck);
                            verification = true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("Not Valid");
                        }
                        if(verification == false) {
                            System.out.print("Please enter a valid year: ");
                            numberCheck = keyboard.nextLine();
                        }
                    }
                    yob = Integer.parseInt(numberCheck);
                    
                    verification = false;
                    System.out.print("Please enter the month of birth: ");
                    numberCheck = keyboard.nextLine();
                    while(verification != true){
                        try{
                            mob = Integer.parseInt(numberCheck);
                            verification = true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("Not Valid");
                        }
                        if(verification == false) {
                            System.out.print("Please enter a valid month: ");
                            numberCheck = keyboard.nextLine();
                        }
                        else if(verification == true)
                        {
                            if(mob <1 || mob > 12) 
                            {
                                verification = false;
                                System.out.print("Please enter a valid month: ");
                                numberCheck = keyboard.nextLine();
                            }
                        }
                    }
                    mob = Integer.parseInt(numberCheck);
                    
                    verification = false;
                    System.out.print("Please enter the date of birth: "); 
                    numberCheck = keyboard.nextLine();
                    while(verification != true){
                        try{
                            dob = Integer.parseInt(numberCheck);
                            verification = true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("Not Valid");
                        }
                        if(verification == false) {
                            System.out.print("Please enter a valid date: ");
                            numberCheck = keyboard.nextLine();
                        }
                        else if(verification == true)
                        {
                            if(dob < 1 || dob > 32) 
                            {
                                verification = false;
                                System.out.print("Please enter a valid date: ");
                                numberCheck = keyboard.nextLine();
                            }
                        }
                    }
                
                    System.out.println("Is this your birthday Date/Month/Year(press 1 for Yes 0 for No): " + dob +"/" + mob+"/" +yob);
                    numberCheck = keyboard.nextLine();
                    verification = false;
                    direction = -1;
                    while(verification != true){
                        try{
                            direction = Integer.parseInt(numberCheck);
                            verification = true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("Not Valid");
                        }
                        if(verification == true)
                        {
                            if(direction != 1 && direction != 0)
                            {
                                verification = false;
                                System.out.print("Please enter a valid number: ");
                                numberCheck = keyboard.nextLine();
                            }
                        }
                        else if(verification == false)
                        {
                            System.out.print("Please enter a valid number(0 or 1): ");
                            numberCheck = keyboard.nextLine();
                        }
                    }
                    direction = Integer.parseInt(numberCheck);
                    if(direction == 1)
                    {
                        confirmation = true;
                    }
                }
                    System.out.print("Please enter the Home Address: ");
                    String hA = keyboard.nextLine();
                    
                   
                my.insert(Integer.parseInt(ID), fName, lName, phoneNumber, major, GPA, yob, mob, dob, hA);    
            }
            else if(choice==2){
                String placeHolder;
                System.out.print("Input the student ID that you would like to delete(8 digits): ");
                placeHolder = keyboard.nextLine();
                
                while(placeHolder.length() != 8 || !placeHolder.matches("[0-9]+")){
                System.out.print("Please input a valid student ID(8 digits): ");
                placeHolder = keyboard.nextLine();
                }
                my.DeleteAt(Integer.parseInt(placeHolder));
            }
            else if(choice==3){
                my.ascendingOrderOriginal();
                System.out.println(my);
            }
            else if(choice==4){
                boolean exit = false;
                int choice = -1;
                String choiceCheck;
                boolean verify = false;
                while(exit == false){
                    System.out.println("Please input 1 for ID, 2 for GPA, 3 for Birthday: ");
                    choiceCheck = keyboard.nextLine();
                    while(verify != true){
                        try{
                            choice = Integer.parseInt(choiceCheck);
                            verify = true;
                        }
                        catch(NumberFormatException e)
                        {
                            System.out.println("Not a valid input");
                            System.out.print("Please input a valid choice: ");
                            choiceCheck = keyboard.nextLine();
                        }
                        
                    }
                    choice = Integer.parseInt(choiceCheck);
                    if(choice == 1)
                    {
                        System.out.println("Press 1 for ascending and 2 for descending order by ID: ");
                        choiceCheck = keyboard.nextLine();
                        verify = false;
                        while(verify != true){
                            try{
                                choice = Integer.parseInt(choiceCheck);
                                verify = true;
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("Not a valid input");
                                System.out.print("Please input a valid choice(1 or 2): ");
                                choiceCheck = keyboard.nextLine();
                            }
                            if(verify == true)
                            {
                                if(choice != 1 && choice != 2)
                                {
                                    verify = false;
                                    System.out.print("Please input a valid choice(1 or 2): ");
                                    choiceCheck = keyboard.nextLine();
                                }
                            }
                        }
                        if(choice == 1) my.ascendingOrderID();
                        else if(choice == 2) my.descendingOrderID();
                        System.out.println();
                        System.out.println(my);
                        System.out.println();
                        System.out.print("Would you like to exit? (press 1 for yes or any other number for no): ");
                        choiceCheck = keyboard.nextLine();
                        verify = false;
                        while(verify != true){
                            try{
                                choice = Integer.parseInt(choiceCheck);
                                verify = true;
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("Not a valid input");
                                System.out.print("Please input a valid choice(1 or any other number): ");
                                choiceCheck = keyboard.nextLine();
                            }
                            if(verify == true)
                            {
                                if(choice != 1 && !choiceCheck.matches("[0-9]+"))
                                {
                                    verify = false;
                                    System.out.print("Please input a valid choice(1 or any other number):");
                                    choiceCheck = keyboard.nextLine();
                                }
                            }
                        }
                        if(choice == 1) exit = true;
                    }
                    else if(choice == 2)
                    {
                        System.out.println("Press 1 for ascending and 2 for descending order by GPA: ");
                        choiceCheck = keyboard.nextLine();
                        verify = false;
                        while(verify != true){
                            try{
                                choice = Integer.parseInt(choiceCheck);
                                verify = true;
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("Not a valid input");
                                System.out.print("Please input a valid choice(1 or 2): ");
                                choiceCheck = keyboard.nextLine();
                            }
                            if(verify == true)
                            {
                                if(choice != 1 && choice != 2)
                                {
                                    verify = false;
                                    System.out.print("Please input a valid choice(1 or 2): ");
                                    choiceCheck = keyboard.nextLine();
                                }
                            }
                        }
                        if(choice == 1) my.ascendingOrderGPA();
                        else if(choice == 2) my.descendingOrderGPA();
                        else System.out.println("Not  a valid choice!");
                        System.out.println();
                        System.out.println(my);
                        System.out.println();
                        System.out.println("Would you like to exit? press 1 for yes: ");
                        choiceCheck = keyboard.nextLine();
                        verify = false;
                        while(verify != true){
                            try{
                                choice = Integer.parseInt(choiceCheck);
                                verify = true;
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("Not a valid input");
                                System.out.print("Please input a valid choice(1 or any other number): ");
                                choiceCheck = keyboard.nextLine();
                            }
                            if(verify == true)
                            {
                                if(choice != 1 && !choiceCheck.matches("[0-9]+"))
                                {
                                    verify = false;
                                    System.out.print("Please input a valid choice(1 or any other number): ");
                                    choiceCheck = keyboard.nextLine();
                                }
                            }
                        }
                        if(choice == 1) exit = true;
                    }
                    else if(choice == 3)
                    {
                        System.out.println("Press 1 for ascending and 2 for descending order by DOB: ");
                        choiceCheck = keyboard.nextLine();
                        verify = false;
                        while(verify != true){
                            try{
                                choice = Integer.parseInt(choiceCheck);
                                verify = true;
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("Not a valid input");
                                System.out.print("Please input a valid choice(1 or 2): ");
                                choiceCheck = keyboard.nextLine();
                            }
                            if(verify == true)
                            {
                                if(choice != 1 && choice != 2)
                                {
                                    verify = false;
                                    System.out.print("Please input a valid choice(1 or 2): ");
                                    choiceCheck = keyboard.nextLine();
                                }
                            }
                        }
                        if(choice == 1) my.ascendingDOB();
                        else if(choice == 2) my.descendingDOB();
                        else System.out.println("Not  a valid choice!");
                        System.out.println();
                        System.out.println(my);
                        System.out.println();
                        System.out.println("Would you like to exit? press 1 for yes: ");
                        choiceCheck = keyboard.nextLine();
                        verify = false;
                        while(verify != true){
                            try{
                                choice = Integer.parseInt(choiceCheck);
                                verify = true;
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("Not a valid input");
                                System.out.print("Please input a valid choice(1 or any other number): ");
                                choiceCheck = keyboard.nextLine();
                            }
                            if(verify == true)
                            {
                                if(choice != 1 && !choiceCheck.matches("[0-9]+"))
                                {
                                    verify = false;
                                    System.out.print("Please input a valid choice(1 or any other number): ");
                                    choiceCheck = keyboard.nextLine();
                                }
                            }
                        }
                        if(choice == 1) exit = true;
                    }
                    else{
                        System.out.println("Not a valid choice");
                        System.out.println("Would you like to exit? press 1 for yes or any other number for no: ");
                        choiceCheck = keyboard.nextLine();
                        verify = false;
                        while(verify != true){
                            try{
                                choice = Integer.parseInt(choiceCheck);
                                verify = true;
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("Not a valid input");
                                System.out.print("Please input a valid choice: ");
                                choiceCheck = keyboard.nextLine();
                            }
                        
                        }
                        if(choice == 1) exit = true;
                    }
                    System.out.println();
                
                }
            }
            else if(choice==5){
                String choiceCheck;
                System.out.print("If you would like a list of student's in a specific major then type 1, if by ID then press 2: ");
                choiceCheck = keyboard.nextLine();
                int searchMID = -1;
                boolean verify = false;
                while(verify != true)
                {
                    try{
                        searchMID = Integer.parseInt(choiceCheck);
                        verify = true;
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("Not valid input");
                    }
                    if(verify == true)
                    {
                        if(searchMID != 1 && searchMID != 2)
                        {
                            verify = false;
                            System.out.print("Please enter a valid input: ");
                            choiceCheck = keyboard.nextLine();
                        }
                    }
                    else if(verify == false){
                        System.out.print("Please enter a valid input: ");
                        choiceCheck = keyboard.nextLine();
                    }
                }
                if(searchMID == 1){
                    System.out.print("Please input the major you would like to serach for: ");
                    String majorSearchC = keyboard.nextLine();
                    my.majorList(majorSearchC);
                    System.out.println();
                    System.out.println();
                }
                else if(searchMID == 2){
                    System.out.println("Please input the 8 digit ID you would like to search for: ");
                    //int searchById = keyboard.nextInt();
                    choiceCheck = keyboard.nextLine();
                    verify = false;
                    while(verify != true)
                    {
                        try{
                            searchMID = Integer.parseInt(choiceCheck);
                            verify = true;
                        }
                        catch(NumberFormatException e)
                        {
                            System.out.println("Not valid input");
                        }
                        if(verify == true)
                        {   
                            if(choiceCheck.length() != 8)
                            {
                            verify = false;
                            System.out.print("Please enter a valid input(8 digit number): ");
                            choiceCheck = keyboard.nextLine();
                            }
                        }
                        else if(verify == false){
                            System.out.print("Please enter a valid input(8 digit number):: ");
                            choiceCheck = keyboard.nextLine();
                        }
                }
                    System.out.println(my.findID(searchMID));
                    System.out.println();
                }
            }
            
        }
        my.ascendingOrderOriginal();
        my.outPutFile();
    }
}
