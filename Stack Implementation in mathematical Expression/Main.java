package mid;
import java.util.*;
public class Main {
    public static void main(String [] args) throws StackUnderflowException,StackOverflowException{
        Scanner sc=new Scanner(System.in);

        String s[]=sc.next().split("");
        int a[]=new int [s.length];
        int x=0;
        System.out.println("ENTER 0 for array based stack or others for linkedlist based stack");
        int y=sc.nextInt();
        Stack b;
        if(y==0) {
            b = new ArrayStack();
        } else {
            b=new ListStack();
        }
        String d="";
        String o="";
        int count=-1;
        int num=-1;
        boolean c=true;
        z: for(int i=0;i<s.length;i++){


            switch(s[i]){
                case "[": case "(": case "{":
                    b.push(s[i]);

                    o=b.peek();
                    a[x++]=(i+1);
                    break;
                case "]":
                    if(o.equals("[")){
                        b.pop();
                        x--;
                        try {
                            o = b.peek();
                        } catch(Exception e){
                            o="";
                        }
                    } else if(o.equals("")) {
                        d += "Error at character # " + (i+1) + ". '" + s[i] + "'-not opened.\n";
                        c = false;
                        break z;
                    }else {

                        d += "Error at character # " + (a[x-1]) + ". '" + o + "'-not closed.\n";
                        c=false;
                        break z;
                    }
                    break;
                case "}":
                    if(o.equals("{")){
                        b.pop();
                        x--;
                        try {
                            o = b.peek();
                        } catch(Exception e){
                            o="";
                        }
                    } else if(o.equals("")) {
                        d += "Error at character # " + (i+1) + ". '" + s[i] + "'-not opened.\n";
                        c = false;
                        break z;
                    }else {

                        d += "Error at character # " + (a[x-1]) + ". '" + o + "'-not closed.\n";
                        c=false;

                        break z;
                    }
                    break;
                case ")":
                    if(o.equals("(")){
                        b.pop();
                        x--;
                        try {
                            o = b.peek();
                        } catch(Exception e){
                            o="";
                        }
                    } else if(o.equals("")) {

                        d += "Error at character # " + (i+1) + ". '" + s[i] + "'-not opened.\n";
                        c = false;
                        break z;
                    }else {

                        d += "Error at character # " + (a[x-1]) + ". '" + o + "'-not closed.\n";
                        c=false;
                        break z;
                    }
                    break;
                default:
                    break;
            }
        }
        if(!(o.equals(""))){
            c=false;
        }
        System.out.println("This expression is "+(c?"":"NOT")+" correct.");
        System.out.print(d);
    }
}
