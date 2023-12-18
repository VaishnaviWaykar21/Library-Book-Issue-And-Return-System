package College;
import java.util.Scanner;
public class book 
{
    public int sNo;
    public String bookName;
    public String authorName;
    public int bookQty;
    public int bookQtyCopy;

    Scanner scn = new Scanner(System.in);

    public book()
    {
        
        System.out.println("Enter Serial No of Book:");
        this.sNo = scn.nextInt();
        scn.nextLine();
 
        System.out.println("Enter Book Name:");
        this.bookName = scn.nextLine();
 
        System.out.println("Enter Author Name:");
        this.authorName = scn.nextLine();
 
        System.out.println("Enter Quantity of Books:");
        this.bookQty = scn.nextInt();
        bookQtyCopy = this.bookQty;
    }
}
