package assignment3;

public class WRM {
    public Queue a;
    public int d;
    public WRM(int b){

        if(b==0){
            a=new ArrayQueue();
        } else {
            a=new ListQueue();
        }

    }
    public void RegisterPatient(Patient p) throws QueueOverflowException{
        p.id=++d;
        a.enqueue(p);

    }
    public void ServePatient() throws QueueUnderflowException{
        a.dequeue();
    }
    public void CancelAll(){
        a=null;
    }
    public boolean CanDoctorGoHome(){
        if(a.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    public void ShowAllPatient(){
        Patient [] c= (Patient[]) a.toArray();
        for(int i=0;i<c.length;i++){
            System.out.println("Id "+c[i].id+" Name "+c[i].name+" Age "+c[i].age+" Blood Group "+c[i].bg);

        }
    }
}
