package assignment3;
public  class ListQueue implements Queue{
    int size;
    Node front;
    Node rear;


    public ListQueue(){
        size = 0;
        front = null;
        rear = null;
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
    public void enqueue(Object o) throws QueueOverflowException{
        if(size==6){
            throw new QueueOverflowException();
        }
        Node n=new Node(o,null);
        if(isEmpty()){

            front=n;
            rear=n;
        }else {
            rear.next=n;
            rear=n;
        }
        size++;

    }

    // Removes the item in the front of the queue, throwing the
// QueueUnderflowException if the queue is empty.
    public Object dequeue() throws QueueUnderflowException{
        if(isEmpty()){
            throw new QueueUnderflowException();
        }
        Object a=front.val;
        front=front.next;
        size--;
        return a;
    }

    // Peeks at the item in the front of the queue, throwing
// QueueUnderflowException if the queue is empty.
    public Object peek() throws QueueUnderflowException{
        if(isEmpty()){
            throw new QueueUnderflowException();
        }
        return front.val;
    }

    // Returns a textual representation of items in the queue, in the
// format "[ x y z ]", where x and z are items in the front and
// back of the queue respectively.
    public String toString(){
        if(isEmpty()){
            return "Empty Queue";
        }
        String s="[ ";
        Node h=front;
        for(int i=0;i<size;i++){
            s+=h.val+" ";
            h=h.next;
        }
        s+="]";
        return s;

    }

    // Returns an array with items in the queue, with the item in the
// front of the queue in the first slot, and back in the last slot.
    public Object[] toArray(){
        Node h=front;
        Object []a=new Object[size];
        for(int i=0;i<size;i++){
            a[i]=h.val;
            if(h.next==null){
                break;
            }

            h=h.next;
        }
        return a;
    }

    // Searches for the given item in the queue, returning the
// offset from the front of the queue if item is found, or -1
// otherwise.
    public int search(Object o){
        Node h=front;

        for(int i=0;i<size;i++){
            if(h.val==o){
                return i;
            }
            if(h.next==null){
                break;
            }

            h=h.next;
        }
        return -1;
    }

//TO DO
}