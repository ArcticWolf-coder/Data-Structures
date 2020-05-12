package assignment3;


import java.util.*;
public class Tester{
    public static void main (String[]args) throws QueueOverflowException,QueueUnderflowException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter 0 for ArrayQueue and enter others for ListQueue");
        int num=sc.nextInt();
        WRM z=new WRM(num);
        x:for(;;) {
            System.out.println("Enter 1 to RegisterPatient\nEnter 2 to ServePatient\nEnter 3 to CancelAll\nEnter 4 for CanDoctorGoHome\nEnter 5 to ShowAllPatient");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Enter name,age,bloodgroup");
                    String name = sc.next();
                    int m = sc.nextInt();
                    String bg = sc.next();
                    Patient p = new Patient(name, m, bg);
                    z.RegisterPatient(p);
                    break;
                case 2:
                    z.ServePatient();
                    break;
                case 3:
                    z.CancelAll();
                    break x;
                case 4:
                    boolean s = z.CanDoctorGoHome();
                    System.out.println("The doctor " + (s ? "can" : "cannot") + " go home.");
                    if(s){
                        break x;
                    }
                    break;
                case 5:
                    z.ShowAllPatient();
                    break;
            }

        }





    }
}
