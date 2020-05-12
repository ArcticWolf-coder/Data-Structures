

public class ArrayStack implements Stack {
    int size;
    Object [] data;

    public ArrayStack(){
        size=0;
        data = new Object[5];
    }
    public int search(Object e){
        for(int i=0;i<size;i++){
            if(e==data[i]){
                return size-i-1;
            }
        }
        return -1;
    }
    public Object[] toArray(){
        Object []a=new Object[size];
        for(int i=0;i<a.length;i++){
            a[a.length-
                    i-1]=data[i];
        }
        return a;
    }
    public Object peek() throws StackUnderflowException{
        if(size==0){
            throw new StackUnderflowException();
        }

        return data[size];
    }
    public Object pop() throws StackUnderflowException{
        if(size==0){
            throw new StackUnderflowException();
        } else {
            size--;
            Object a=data[size];
            data[size]=null;


            return a;
        }
    }
    public void push(Object e) throws StackOverflowException{
        if(size==5){
            throw new StackOverflowException();
        } else {
            data[size]=e;
            size++;
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