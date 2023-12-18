package College;

import java.util.Scanner;

public class Library 
{
    public static void main(String[] args)
    {
         Scanner scn = new Scanner(System.in);
 
        System.out.println( "                            Welcome to the Library!                         ");
        System.out.println("                        Select From The Following Options:                   ");
        System.out.println( "      ________________________________________________________________________    ");
 
        books ob = new books();
        
        Students obStudent = new Students();
 
        int choice;
        int searchChoice;
        do 
        {
            ob.dispMenu();
            choice = scn.nextInt();
            switch (choice) 
            {
                case 1:
                    book b = new book();
                    ob.addBook(b);
                    break;
    
                case 2:
                    ob.updateBookQty();
                    break;
 
                case 3:
                    System.out.println("    1: Search with Book Serial No");
                    System.out.println("    2: Search with Book's Author Name");
                    searchChoice = scn.nextInt();
                
                    switch (searchChoice)
                    {
                        case 1:
                            ob.searchBySno();
                            break;
                        case 2:
                            ob.searchByAuthorName();
                    }
                    break;
 
                case 4:
                    ob.showAllBooks();
                    break;
 
                case 5:
                    student s = new student();
                    obStudent.addStudent(s);
                    break;
 
                case 6:
                    obStudent.showAllStudents();
                    break;
 
                case 7:
                    obStudent.checkOutBook(ob);
                    break;
 
                case 8:
                    obStudent.checkInBook(ob);
                    break;
                
                default:
                    System.out.println("Thank you !!");
            }
 
        }
        while (choice != 0);
    }
}
