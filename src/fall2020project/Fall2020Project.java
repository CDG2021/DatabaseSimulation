/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fall2020project;
import java.io.*;
import java.io.File;
import java.util.Scanner;
/**
 *
 * @author Carlos Garcia
 */
public class Fall2020Project{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        String fileName;
        DLinkedList myList = new DLinkedList();
        Scanner keyboard = new Scanner(System.in);
        File myFile = new File("DataForClients.txt");
        Scanner inputFile = new Scanner(myFile);
        String line = inputFile.nextLine();
        String[] Data = line.split(",", 10);
        int id=0, yob=0, mob=0, dob=0;
        String fn ="", ln="", pn="", m="", hAddress="";
        double GPA=0;
        
        
        while(inputFile.hasNext())
        {
            for(int a = 0; a < Data.length+1; a++)
            {
                if(a == 0) id = Integer.parseInt(Data[a]);
                else if(a ==1) fn = Data[a];
                else if(a ==2) ln = Data[a];
                else if(a ==3) pn = Data[a];
                else if(a ==4) m = Data[a];
                else if(a ==5) GPA = Double.parseDouble(Data[a]);
                else if(a ==6) yob = Integer.parseInt(Data[a]);
                else if(a ==7) mob = Integer.parseInt(Data[a]);
                else if(a ==8) dob = Integer.parseInt(Data[a]);
                else if(a ==9) hAddress = Data[a];
            }
            myList.insert(id, fn, ln, pn, m, GPA, yob, mob, dob, hAddress);
            line = inputFile.nextLine();
            Data = line.split(",", 10);
            if(inputFile.hasNext() == false)
            {
                for(int a = 0; a < Data.length+1; a++)
                {
                    if(a == 0) id = Integer.parseInt(Data[a]);
                    else if(a ==1) fn = Data[a];
                    else if(a ==2) ln = Data[a];
                    else if(a ==3) pn = Data[a];
                    else if(a ==4) m = Data[a];
                    else if(a ==5) GPA = Double.parseDouble(Data[a]);
                    else if(a ==6) yob = Integer.parseInt(Data[a]);
                    else if(a ==7) mob = Integer.parseInt(Data[a]);
                    else if(a ==8) dob = Integer.parseInt(Data[a]);
                    else if(a ==9) hAddress = Data[a];
                }
                myList.insert(id, fn, ln, pn, m, GPA, yob, mob, dob, hAddress);
            }
        }
        
        inputFile.close();
        Option choices = new Option();
        choices.choices(myList);
        System.out.println(myList);
    }
}
    

