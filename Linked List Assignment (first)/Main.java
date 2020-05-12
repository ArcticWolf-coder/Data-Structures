import java.util.*;
public class Main{
    public static void main (String [] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        Object []a=new Object[num];
        for(int i=0;i<a.length;i++){
            a[i]=(Object)sc.nextInt();
        }
        LinkedList b=new LinkedList(a);
        Node n=b.reverseList();
        Node m=b.head;
        boolean c=true;
        for(;;){
            if(n.next==null || m.next==null){
                break;
            }
            if(m.element==n.element){
            } else {
                c=false;
                break;
            }
        }
        if(c){
            System.out.println("it is a palindrome");
        }else {
            System.out.println("it is a palindrome");
        }
    }
}
            