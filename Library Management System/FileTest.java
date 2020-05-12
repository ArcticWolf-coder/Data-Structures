package Assignment01;
import java.util.*;
import java.io.*;
public class FileTest {
    public static void main (String [] args) throws FileNotFoundException, IOException{
        FileReader f=new FileReader("F:\\Varsity\\src\\Assignment01\\z.txt");
        Scanner sc=new Scanner(f);
        BookRecord b=new BookRecord();
        String sum="";
        while(sc.hasNext()){
            String st=sc.nextLine();
            String s[]=st.split(",");
            sum+=st;
            String name=s[0];
            int id=Integer.parseInt(s[1]);
            String author=s[2];
            String publisher=s[3];
            b.AddRecord(new Book(name,id,author,publisher));
            sum+="\n";

        }
        FileOutputStream o=new FileOutputStream("F:\\Varsity\\src\\Assignment01\\a.txt");
        byte c[]=sum.getBytes();
        o.write(c);
        o.close();

    }
}
