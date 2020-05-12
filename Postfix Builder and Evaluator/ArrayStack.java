package assignment4;

public class ArrayStack implements Stack {
    public int size=0;
    public String [] data=new String[15];

    public ArrayStack(){
        size=0;

        for(int i=0;i<data.length;i++){
            data[i]="";
        }
    }
    public int search(String e){
        for(int i=0;i<size;i++){
            if(e==data[i]){
                return size-i-1;
            }
        }
        return -1;
    }
    public String[] toArray(){
        String []a=new String[size];
        for(int i=0;i<a.length;i++){
            a[a.length-
                    i-1]=data[i];
        }
        return a;
    }
    public String peek() throws StackUnderflowException {
        if(size==0){
            throw new StackUnderflowException();
        }

        return data[size-1];
    }
    public String pop() throws StackUnderflowException {
        if(size==0){
            throw new StackUnderflowException();
        } else {
            size--;
            String a=data[size];
            data[size]="";


            return a;
        }
    }
    public void push(String e) throws StackOverflowException {
        if(size==15){
            throw new StackOverflowException();
        } else {

            data[size++]=e;


        }

    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        } else {
            return false;
        }
    }
    public int size(){
        return size;
    }
    public String toString(){
        if(size==0){
            return "Empty Stack\n";
        }
        String s="[ ";
        for(int i=size-1;i>=0;i--){
            s+=data[i]+" ";
        }
        s+="]\n";
        return s;
    }
}