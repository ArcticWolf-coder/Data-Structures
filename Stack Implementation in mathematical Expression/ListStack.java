package mid;public class ListStack implements Stack{
    int size;
    Node top;


    public ListStack(){
        size = 0;
        top = null;
    }
    public void push(String e) throws StackOverflowException {
        top = new Node(e, top);
        ++size;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if(size==0)
            return true;
        return false;
    }
    public String pop() throws StackUnderflowException {
        if(isEmpty())
            throw new StackUnderflowException();
        String tmp = top.val;
        top = top.next;
        --size;
        return tmp;
    }
    public String peek() throws StackUnderflowException {
        if(isEmpty())
            throw new StackUnderflowException() ;
        return top.val;
    }
    public String toString(){
        if(size==0){
            return "Empty Stack";
        }
        String s ="";
        for(Node n = top; n != null ; n = n.next) {
            s+=n.val+" ";
        }return s;
    }
    public String[] toArray() {
        String[] arr = new String[size];
        Node n  = top;
        for(int i=0; i<size ; ++i) {
            arr[i] = n.val;
            n = n.next;
        }
        return arr;
    }
    public int search(String e){
        int count = 0;
        for(Node n = top ; n != null; n = n.next){
            if(n.val==e)
                return count;
            ++count;
        }
        return -1;
    }
}