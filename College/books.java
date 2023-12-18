package College;
import java.util.Scanner;
public class books
{
    book theBooks[] = new book[50];
    public static int count;
 
    Scanner scn = new Scanner(System.in);
 
    public int compareBookObjects(book b1, book b2) //comparing the book objects
    {
    
        if(b1.bookName.equalsIgnoreCase(b2.bookName))
         {
            System.out.println("Book of this Name Already Exists");
            return 0;
        }
 
        if(b1.sNo == b2.sNo) 
        {
             System.out.println("Book of this Serial No Already Exists");
                return 0;
        }
        return 1;
    }
 
    
    public void addBook(book b) //adding a book
    {
        for(int i = 0; i < count; i++)
        {
            if(this.compareBookObjects(b, this.theBooks[i])== 0)
            return;
        }
 
        if(count < 50) 
        {
            theBooks[count] = b;
            count++;
        }
        else 
        {
             System.out.println("No Space to Add More Books");
        }
    }
 
    
    public void searchBySno() //search a book by serial number of book
    {
        System.out.println("SEARCH BY SERIAL NUMBER \n");
        int sNo;
        System.out.println("Enter Serial No of Book:");
        sNo = scn.nextInt();
 
        int flag = 0;
        System.out.println( "S.No\t\t\tName\t\t\tAuthor\t\t\tAvailable Qty\t\t\tTotal Qty");
 
        for(int i = 0; i < count; i++) 
        {
            if(sNo == theBooks[i].sNo) 
            {
                System.out.println( theBooks[i].sNo + "\t\t\t"+ theBooks[i].bookName + "\t\t\t"+ theBooks[i].authorName + "\t\t\t"+ theBooks[i].bookQtyCopy + "\t\t\t"+ theBooks[i].bookQty);
                flag++;
                return;
            }
        }
        if(flag == 0)
            System.out.println("No Book for Serial No "+ sNo + " Found");
    }
 
    
    public void searchByAuthorName() //searching a book by Author name of book
    {
        System.out.println( "SEARCH BY AUTHOR'S NAME\n"     );
        scn.nextLine();
 
        System.out.println("Enter Author Name:");
        String authorName = scn.nextLine();
 
        int flag = 0;
        System.out.println("S.No\t\t\tName\t\t\tAuthor\t\t\tAvailable Qty\t\t\tTotal Qty");
 
        for(int i = 0; i < count; i++) 
        {
            if(authorName.equalsIgnoreCase(theBooks[i].authorName)) 
            {
                System.out.println( theBooks[i].sNo + "\t\t\t"+ theBooks[i].bookName + "\t\t\t"+ theBooks[i].authorName + "\t\t\t"+ theBooks[i].bookQtyCopy + "\t\t\t"+ theBooks[i].bookQty);
                flag++;
            }
        }
            if(flag == 0)
            System.out.println("No Books of " + authorName+ " Found");
    }
 
    
    public void showAllBooks() // showing all book records
    {
        System.out.println("SHOWING ALL BOOKS\n");
        System.out.println("S.No\t\t\tName\t\t\tAuthor\t\t\tAvailable Qty\t\t\tTotal Qty");
 
        for(int i = 0; i < count; i++) 
        {
            System.out.println( theBooks[i].sNo + "\t\t\t"+ theBooks[i].bookName + "\t\t\t"+ theBooks[i].authorName + "\t\t\t"+ theBooks[i].bookQtyCopy + "\t\t\t"+ theBooks[i].bookQty);
        }
    }
 
    
    public void updateBookQty() //update the quantity of book
    {
        System.out.println("UPGRADE QUANTITY OF A BOOK\n");
        System.out.println("Enter Serial No of Book");
 
        int sNo = scn.nextInt();
 
        for(int i = 0; i < count; i++) 
        {
            if(sNo == theBooks[i].sNo)
             {
                System.out.println("Enter No of Books to be Added:");
                int addingQty = scn.nextInt();

                theBooks[i].bookQty += addingQty;
                theBooks[i].bookQtyCopy += addingQty;
 
                return;
            }
        }
    }
 
     public int isAvailable(int sNo) // book is avalible or not
    {
 
        for(int i = 0; i < count; i++) 
        {
            if(sNo == theBooks[i].sNo)
             {
                if(theBooks[i].bookQtyCopy > 0) 
                {
                    System.out.println("Book is Available.");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }
        System.out.println("No Book of Serial Number "+ " Available in Library");
        return -1;
    }
 

    public book checkOutBook() //checking out the book
    {
 
        System.out.println("Enter Serial No of Book to be Checked Out");
        int sNo = scn.nextInt();
 
        int bookIndex = isAvailable(sNo);
 
        if(bookIndex != -1) 
        {
            theBooks[bookIndex].bookQtyCopy--;
            return theBooks[bookIndex];
        }
        return null;
    }
 
    
    public void checkInBook(book b) // checking in the book
    {
        for(int i = 0; i < count; i++) 
        {
            if(b.equals(theBooks[i])) 
            {
                theBooks[i].bookQtyCopy++;
                return;
            }
        }
    }

    public void dispMenu()
    {
 
        
        System.out.println("   ");
        System.out.println("    1: Add new Book"    );
        System.out.println("    2: Update Quantity of a Book"  );
        System.out.println("    3: Search a Book"  );
        System.out.println("    4: Show All Books" );
        System.out.println("    5: Register Student"   );
        System.out.println("    6: Show All Registered Students"   );
        System.out.println("    7: Check Out Book"    );
        System.out.println("    8: Check In Book"   );
        System.out.println("    0: Exit"    );
        System.out.println("     ");
    }
}
