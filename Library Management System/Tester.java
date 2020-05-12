package Assignment01;
import java.util.*;
public class Tester {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);

        BookRecord b=new BookRecord();
        for(;;){
            System.out.println("Enter 1 to Add a Record\nEnter 2 to Print the Records\nEnter 3 to Delete a Record\nEnter 4 to Edit a Record");
            int n=sc.nextInt();
            switch(n){
                case 1:
                    System.out.println("Name please");
                    String name = sc.next();
                    System.out.println("Id please");
                    int id = sc.nextInt();
                    System.out.println("Author please");
                    String author = sc.next();
                    System.out.println("Publisher please");
                    String publisher = sc.next();
                    b.AddRecord(new Book(name,id,author,publisher));
                    break;
                case 2:
                    b.PrintRecord();
                    break;
                case 3:
                    System.out.println("Give me Id of the book you want to delete");
                    int num=sc.nextInt();
                    b.DeleteRecord(num);
                    break;
                case 4:
                    System.out.println("Give me Id of the book you want to edit");
                    int d=sc.nextInt();
                    System.out.println("Edited Name please");
                    String m=sc.next();
                    System.out.println("Edited Publisher please");
                    String p=sc.next();
                    b.EditRecord(d,m,p);
                    break;
            }

            System.out.println("Do you want to continue?");
            String s=sc.next();
            if(s.equalsIgnoreCase("Y")){

            }else {
                break;
            }
        }
    }
}
