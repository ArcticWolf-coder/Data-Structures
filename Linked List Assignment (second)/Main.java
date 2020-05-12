package adt;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        MyOrderList a=new MyOrderList();
        int []b={5,4,8,7,9,2};
        Node n=null;

        for(int i=0;i<b.length;i++){
            n=new Node(b[i],null);
            a.insert(n);
        }
        a.showList();
        System.out.println(a.getCursor().key);
        System.out.println(a.gotoPrior().key);
        System.out.println(a.gotoNext().key);
        System.out.println(a.gotoBeginning().key);
        System.out.println(a.gotoEnd().key);
        System.out.println(a.retrieve(5).key);
        System.out.println(a.getCursor().key);
        System.out.println(a.isEmpty());
        a.remove();
        a.showList();
        a.remove(8);
        a.showList();
        a.remove();
        a.showList();


    }
}