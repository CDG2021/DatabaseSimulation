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
public class DLinkedList {
    private class Node
    {
        int studentID, yearOfBirth, monthOfBirth, dateOfBirth, pos;
        double gpa;
        String lName, fName, major, address, phoneNumber;
        Node next;
        Node prev;
        public Node(int id, String fn, String ln, String pn, String m, double GPA, int yob, int mob, int dob, String hAddress)
        {
            pos = length + 1;
            studentID = id;
            fName = fn;
            lName = ln;
            phoneNumber = pn;
            major = m;
            gpa = GPA;
            yearOfBirth = yob;
            monthOfBirth = mob;
            dateOfBirth = dob;
            address = hAddress;
            next = null;
            prev = null;
        }
    }
    
    private Node first;
    private Node last;
    private int length;
    private Node curPos;
    
    public DLinkedList()
    {
        length = 0;
        first = last = curPos = null;
    }
    
    public void makeEmpty()
    {
        length = 0;
        first = last = curPos = null;
    }
    public int lengthIs()
    {
        return length;
    }
    public boolean checkIfUsed(int idSearch)
    {
        Node current = first;
        while(current != null)
        {
            if(current.studentID == idSearch)
            {
                System.out.println("ID is already used");
                return false;
            }
            current = current.next;
        }
        return true;
    }
    public void insert(int id, String fn, String ln, String pn, String m, double GPA, int yob, int mob, int dob, String hAddress)
    {
        Node newNode = new Node(id, fn, ln, pn, m, GPA, yob, mob, dob, hAddress);
        if(length==0)
        {
            first = last = newNode;
            length++;
            return;
        }
        last.next = newNode;
        newNode.prev = last;
        last = newNode;
        length++;
    }
    public void DeleteAt(int record)
    {
        Node current = first;
        int rank = 0;
        if(record < 9999999) return;
        
        while(current != null)
        {
            if(current.studentID == record) 
            { 
                if(current.next == null && current.prev == null)
                {
                    
                System.out.println("User deleted!");
                makeEmpty();
                return;
                }
                if(current.prev == null)
                { 
                    System.out.println("User deleted!");
                    deleteFromFirst();
                    return;
                }
                if(current.next == null)
                {
                    System.out.println("User deleted!");
                    deleteFromLast();
                    return;
                }
                else
                {
                current.next.prev = current.prev;
                current.prev.next = current.next;
                length--;
                return;
                }
            }
            current = current.next;
            rank++;
            if(current == null)
            {
                
            System.out.println("User not found!");
            return;
            }
        }
    }
    public void addToLast(int id, String fn, String ln, String pn, String m, double GPA, int yob, int mob, int dob, String hAddress)
    {
        Node newNode = new Node(id, fn, ln, pn, m, GPA, yob, mob, dob, hAddress);
        if(length==0)
        {
            first = last = newNode;
            length++;
            return;
        }
        last.next = newNode;
        newNode.prev = last;
        last = newNode;
        length++;
        
    }
    /*
    public int Find(int s)
    {
        Node current = first;
        while(current!=null)
        {
            if(current.id.equals(s)) return current;
            else
            {
                current = current.next;
            }
        }
        return -1;
    }
    
    public void Insert(String s, int rank)
    {
        if(rank<=0) 
        {
            addToFirst(s);
            return;
        }
        if(rank>=length)
        {
            addToLast(s);
            return;
        }
        Node newNode = new Node(s);
        Node current = first;
        for(int i=0;i<rank-1;i++)
            current = current.next;
        
        newNode.next = current.next;
        current.next = newNode;
        newNode.prev = current;
        newNode.next.prev = newNode;
        
        length++;
    }
    */
    public void deleteFromFirst()
    {
        if(length==0) return;
        if(curPos == first) curPos = null;
        first = first.next;
        if(first!=null) first.prev = null;
        length--;
        if(length==0) last = null;
    }
    public void deleteFromLast()
    {
        if(length==0) return;
        if(length==1) 
        {
            makeEmpty();
            return;
        }
        last.prev.next = null;
        if(curPos==last) curPos = last.prev;
        last = last.prev;
        length--;
    }
    
    public boolean isLast()
    {
        return curPos == last;
    }
    public String getNext()
    {
        if(isLast()) return null;
        if(curPos==null) curPos = first;
        else curPos = curPos.next;
        return curPos.lName;
    }
    
    public void reset()
    {
        curPos = null;
    }
    public void majorList(String searchM)
    {
        Node current = first;
        String info = "List of Student by Major: ";
        System.out.println(info);
        info = "";
        for(int i = 0;i<length;i++)
        {
            if(current.major.equals(searchM))
            {
                info = info+'\n'+current.studentID + " " + current.fName + " " + current.lName +" "+ current.phoneNumber + " "+current.major+" "+current.gpa+" "+ current.yearOfBirth + '\\' +current.monthOfBirth + "\\" + current.dateOfBirth + " "+current.address;
                current = current.next;
            }
            else{
            current = current.next;
            }
        }
        System.out.print(info);
    }
    public String findID(int a){
        Node current = first;
        while(current != null)
        {
            if(current.studentID == a)
            {
               String s = current.studentID + " " + current.fName + " " + current.lName +" "+ current.phoneNumber + " "+current.major+" "+current.gpa+" "+ current.yearOfBirth + '\\' +current.monthOfBirth + "\\" + current.dateOfBirth + " "+current.address;
               return s;
            }
            current = current.next;
        }
        return "Not Found";
    }
    public String toString()
    {
        String output = "List of student Infomation";
        Node current = first;
        for(int i=0;i<length;i++)
        {
            output = output+'\n'+"(ID):"+current.studentID + " (First Name): " + current.fName + " (Last Name): " + current.lName +" (Phone Number): "+ current.phoneNumber + " (Major): "+current.major+" (GPA): "+current.gpa+" (Date of Birth YY/MM/DD): "+ current.yearOfBirth + '\\' +current.monthOfBirth + "\\" + current.dateOfBirth + " (Address):"+current.address;
            current = current.next;
        }
        return output;
    }
    public void ascendingDOB(){
        if(length == 1 || length == 0) return;
        
        Node current = first;
        Node temp = current.next;
        
        if(length == 2)
        {
            if(current.yearOfBirth > temp.yearOfBirth && current.yearOfBirth != temp.yearOfBirth)
            {
                Swap(current, temp);
            }
            else if(current.monthOfBirth > temp.monthOfBirth && current.monthOfBirth != temp.monthOfBirth)
            {
                Swap(current, temp);
            }
            else if(current.dateOfBirth > temp.dateOfBirth && current.dateOfBirth != temp.dateOfBirth)
            {
                Swap(current, temp);
            }
            return;
        }
        bubbleSortAscendingDOB(current);
    }
    public void bubbleSortAscendingDOB(Node a)
    {
        int counter = length;
        Node temp = a.next;
        while(counter > 0)
        {
            while(temp != null)
            {
                if(a.yearOfBirth > temp.yearOfBirth && a.yearOfBirth != temp.yearOfBirth)
                {
                    Swap(a, temp);
                    a = temp;
                    temp = temp.next;
                }
               else if(a.monthOfBirth > temp.monthOfBirth && a.yearOfBirth == temp.yearOfBirth)
                {
                    Swap(a, temp);
                    a = temp;
                    temp = temp.next;
                }
                else if(a.dateOfBirth > temp.dateOfBirth && a.yearOfBirth == temp.yearOfBirth && a.monthOfBirth == temp.monthOfBirth)
                {
                    Swap(a, temp);
                    a = temp;
                    temp = temp.next;
                }
                else{
                    a = a.next;
                    temp = a.next;
                }
            }
            counter--;
            a = first;
            temp = a.next;
        }
    }
    public void descendingDOB(){
        if(length == 1 || length == 0) return;
        
        Node current = first;
        Node temp = current.next;
        
        if(length == 2)
        {
            if(current.yearOfBirth < temp.yearOfBirth && current.yearOfBirth != temp.yearOfBirth)
            {
                Swap(current, temp);
            }
            else if(current.monthOfBirth < temp.monthOfBirth && current.monthOfBirth != temp.monthOfBirth)
            {
                Swap(current, temp);
            }
            else if(current.dateOfBirth < temp.dateOfBirth && current.dateOfBirth != temp.dateOfBirth)
            {
                Swap(current, temp);
            }
            return;
        }
        bubbleSortDescendingDOB(current);
    }
    public void bubbleSortDescendingDOB(Node a)
    {
        int counter = length;
        Node temp = a.next;
        while(counter > 0)
        {
            while(temp != null)
            {
                if(a.yearOfBirth < temp.yearOfBirth && a.yearOfBirth != temp.yearOfBirth)
                {
                    Swap(a, temp);
                    a = temp;
                    temp = temp.next;
                }
               else if(a.monthOfBirth < temp.monthOfBirth && a.yearOfBirth == temp.yearOfBirth)
                {
                    Swap(a, temp);
                    a = temp;
                    temp = temp.next;
                }
                else if(a.dateOfBirth < temp.dateOfBirth && a.yearOfBirth == temp.yearOfBirth && a.monthOfBirth == temp.monthOfBirth)
                {
                    Swap(a, temp);
                    a = temp;
                    temp = temp.next;
                }
                else{
                    a = a.next;
                    temp = a.next;
                }
            }
            counter--;
            a = first;
            temp = a.next;
        }
    }
    public void ascendingOrderID(){
       if(length ==  1 || length == 0) return;
       
       Node current = first;
       Node temp = first;
       Node temp2 = current.next;
       if(length == 2)
       {
           if(current.studentID > temp2.studentID)
           {
               Swap(current, temp2);
           }
           return;
       }
       bubbleSortAscending(current);
       
    }
    public void ascendingOrderOriginal(){
       if(length ==  1 || length == 0) return;
       
       Node current = first;
       Node temp = first;
       Node temp2 = current.next;
       if(length == 2)
       {
           if(current.pos > temp2.pos)
           {
               Swap(current, temp2);
           }
           return;
       }
       bubbleSortAscendingOrigianl(current);
       
    }
    public void ascendingOrderGPA(){
       if(length ==  1 || length == 0) return;
       
       Node current = first;
       Node temp = first;
       Node temp2 = current.next;
       if(length == 2)
       {
           if(current.gpa > temp2.gpa)
           {
               Swap(current, temp2);
           }
           return;
       }
       bubbleSortAscendingGPA(current);
       
    }
    public void descendingOrderID(){
       if(length ==  1 || length == 0) return;
        
       Node current = first;
       Node temp = first;
       Node temp2 = current.next;
       if(length == 2)
       {
           if(current.studentID < temp2.studentID)
           {
               Swap(current, temp2);
           }
           return;
       }
       bubbleSortDescending(current);
    }
    public void descendingOrderGPA(){
       if(length ==  1 || length == 0) return;
        
       Node current = first;
       Node temp = first;
       Node temp2 = current.next;
       if(length == 2)
       {
           if(current.gpa < temp2.gpa)
           {
               Swap(current, temp2);
           }
           return;
       }
       bubbleSortDescendingGPA(current);
    }
    public void bubbleSortAscending(Node a)
    {
        int counter = length;
        Node temp = a.next;
        while(counter > 0)
        {
            while(temp != null)
            {
                if(a.studentID > temp.studentID)
                {
                    Swap(a, temp);
                    a = temp;
                    temp = a.next;
                }
                else{
                    a = a.next;
                    temp = a.next;
                }
            }
            counter--;
            a = first;
            temp = a.next;
        }
    }
    public void bubbleSortAscendingOrigianl(Node a)
    {
        int counter = length;
        Node temp = a.next;
        while(counter > 0)
        {
            while(temp != null)
            {
                if(a.pos > temp.pos)
                {
                    Swap(a, temp);
                    a = temp;
                    temp = a.next;
                }
                else{
                    a = a.next;
                    temp = a.next;
                }
            }
            counter--;
            a = first;
            temp = a.next;
        }
    }
    public void bubbleSortAscendingGPA(Node a)
    {
        int counter = length;
        Node temp = a.next;
        while(counter > 0)
        {
            while(temp != null)
            {
                if(a.gpa > temp.gpa)
                {
                    Swap(a, temp);
                    a = temp;
                    temp = a.next;
                }
                else{
                    a = a.next;
                    temp = a.next;
                }
            }
            counter--;
            a = first;
            temp = a.next;
        }
    }
    public void bubbleSortDescending(Node a)
    {
        int counter = length;
        Node temp = a.next;
        while(counter > 0)
        {
            while(temp != null)
            {
                if(a.studentID < temp.studentID)
                {
                    Swap(a, temp);
                    a = temp;
                    temp = a.next;
                }
                else{
                    a = a.next;
                    temp = a.next;
                }
            }
            counter--;
            a = first;
            temp = a.next;
        }
    }
    public void bubbleSortDescendingGPA(Node a)
    {
        int counter = length;
        Node temp = a.next;
        while(counter > 0)
        {
            while(temp != null)
            {
                if(a.gpa < temp.gpa)
                {
                    Swap(a, temp);
                    a = temp;
                    temp = a.next;
                }
                else{
                    a = a.next;
                    temp = a.next;
                }
            }
            counter--;
            a = first;
            temp = a.next;
        }
    }
    public void Swap(Node a, Node b){
        Node current = a;
        Node temp = b;
        if(current.studentID == temp.studentID) return;
        
        Node temp2 = b;
        Node current2 = a;
        if(current.next == temp && temp.next == null && current.prev == null){
            first = temp;
            temp.prev = null;
            temp.next = current;
            
            last = current;
            current.prev = temp;
            current.next = null;
        }
        else if(current.prev == null && temp.next == null){
            current2 = current2.next;
            temp2 = temp2.prev;
            first = temp;
            temp.prev = null;
            temp.next = current2;
            current2.prev = temp;
            
            last = current;
            current.next = null;
            current.prev = temp2;
            temp2.next = current;
        }
        else if(current.prev == null && current.next == temp && temp.next != null)
        {
            temp2 = temp2.next;
            first = temp;
            temp.prev = null;
            temp.next = current;
            
            current.prev = temp;
            current.next = temp2;
            
            temp2.prev = current;
        }    
        else if(current.prev == null && temp.next != null){
            current2 = current2.next;
            Node temp3 = temp2.prev;
            Node temp4 = temp2.next;
            
            first = temp;
            temp.prev = null;
            temp.next = current2;
            current2.prev = temp;
            
            current.prev = temp3;
            current.next = temp4;
            temp3.next = current;
            temp4.prev = current;
        }
        
        else if(current.prev != null && temp.next != null && current.next != temp)
        {
            current2 = current2.next;
            Node current3 = current.prev;
            Node temp3 = temp2.prev;
            Node temp4 = temp2.next;
            
            temp.prev = current3;
            temp.next = current2;
            current3.next = temp;
            current2.prev = temp;
            
            current.prev = temp3;
            current.next = temp4;
            temp4.prev = current;
            temp3.next = current;
        }      
        else if(current.prev != null && temp.next != null && current.next == temp)
        {
            current2 = current2.prev;
            temp2 = temp2.next;
            
            temp.prev = current2;
            temp.next = current;
            current2.next = temp;
            
            current.prev = temp;
            current.next = temp2;
            temp2.prev = current;
        }      
        else if(current.prev != null && temp.next == null && temp.prev == current)
        {
            current2 = current2.prev;
            
            temp.next = current;
            temp.prev = current2;
            current2.next = temp;
            
            last = current;
            current.next = null;
            current.prev = temp;
        }
        else if(current.prev != null && temp.next == null)
        {
            current2 = current.prev;
            Node current3 = current.next;
            temp2 = temp.prev;
            
            temp.prev = current2;
            temp.next = current3;
            
            last = current;
            current.prev = temp2;
            current.next = null;
        }
    }
    public void outPutFile() throws IOException
    {
        Node current = first;
        PrintWriter outputFile = new PrintWriter("DataForClients.txt");
        PrintWriter outputFile2 = new PrintWriter("DataForClientsBackUpDoNotAlter.txt");
        while(current!=null)
        {
            outputFile.write(current.studentID+","+ current.fName + "," + current.lName +","+ current.phoneNumber + ","+current.major+","+current.gpa+","+ current.yearOfBirth + ',' +current.monthOfBirth + "," + current.dateOfBirth + ","+current.address + '\n');
            outputFile2.write(current.studentID+","+ current.fName + "," + current.lName +","+ current.phoneNumber + ","+current.major+","+current.gpa+","+ current.yearOfBirth + ',' +current.monthOfBirth + "," + current.dateOfBirth + ","+current.address + '\n');
            current = current.next;
        }
        outputFile2.close();
        outputFile.close();
    }
}
