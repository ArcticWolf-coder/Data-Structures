package assignment3;
public class ArrayQueue implements Queue{
    int size;
    int front;
    int rear;
    Object [] data;

    public ArrayQueue(){
        size=0;
        front = -1;
        rear = -1;
        data = new Object[5];
    }
    public void enqueue(Object o) throws QueueOverflowException{
        if(size==data.length){
            throw new QueueOverflowException();
        }
        data[size++]=o;
    }
    public int size(){
        return size;
    }

    // Returns true if the queue is empty
    public boolean isEmpty(){
        if(size==0){
            return true;
        } else {
            return false;
        }
    }

    // Adds the new item on the back of the queue, throwing the
// QueueOverflowException if the queue is at maximum capacity. It
// does not throw an exception for an "unbounded" queue, which
// dynamically adjusts capacity as needed.


    // Removes the item in the front of the queue, throwing the
// QueueUnderflowException if the queue is empty.
    public Object dequeue() throws QueueUnderflowException{
        if(isEmpty()){
            throw new QueueUnderflowException();
        }
        Object a=data[0];
        for(int i=0;i<size-1;i++){
            data[i]=data[i+1];
        }
        data[size-1]=0;
        size--;
        return a;
    }

    // Peeks at the item in the front of the queue, throwing
// QueueUnderflowException if the queue is empty.
    public Object peek() throws QueueUnderflowException{
        if(isEmpty()){
            throw new QueueUnderflowException();
        }
        return data[0];
    }

    // Returns a textual representation of items in the queue, in the
// format "[ x y z ]", where x and z are items in the front and
// back of the queue respectively.
    public String toString(){
        if(isEmpty()){
            return "Empty Queue";
        }
        String s="";
        s+="[ ";
        for(int i=0;i<size;i++){
            s+=data[i]+" ";
        }
        s+="]";

        return s;
    }

    // Returns an array with items in the queue, with the item in the
// front of the queue in the first slot, and back in the last slot.
    public Object[] toArray(){
        Object [] a=new Object [size];
        for(int i=0;i<size;i++){
            a[i]=data[i];
        }
        return a;
    }

    // Searches for the given item in the queue, returning the
// offset from the front of the queue if item is found, or -1
// otherwise.
    public int search(Object o){
        for(int i=0;i<size;i++){
            if(data[i]==o){
                return i;
            }
        }
        return -1;
    }
//TO DO

}