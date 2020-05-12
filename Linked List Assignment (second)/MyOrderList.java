package adt;

public class MyOrderList {

    public Node cursor;

    public MyOrderList(){

    }

    public void insert (Node newElement) {
        if (cursor == null) {
            cursor = newElement;
            cursor.next = cursor;
        }else if(cursor==cursor.next) {
            if (newElement.key == cursor.key) {
                return;
            } else {
                newElement.next = cursor;
                cursor.next = newElement;

            }

        }else {
            Node h=cursor;
            Node t=cursor.next;
            for(;;){
                if(newElement.key==h.key || newElement.key==t.key){
                    return;
                }
                if(newElement.key>h.key && newElement.key<t.key){
                    h.next=newElement;
                    newElement.next=t;
                    break;
                }
                if(h.key>t.key){
                    if(newElement.key>h.key){
                        h.next=newElement;
                        newElement.next=t;
                        break;
                    } else if(newElement.key<t.key){
                        h.next=newElement;
                        newElement.next=t;
                        break;
                    }
                }
                h=h.next;
                t=t.next;
            }
        }


    }
    public void showList(){
        Node n=cursor;
        if(cursor==null){
            System.out.println("Empty list");
            return;
        }
        System.out.print("[ ");
        for(;;){
            if(n.next.key<n.key){
                n=n.next;
                break;
            }
            n=n.next;
        }
        Node h=n;
        for(;;){
            if(n.next==h){
                System.out.print(n.key+" ");
                break;
            }
            System.out.print(n.key+" ");
            n=n.next;
        }
        System.out.println("]");
    }
    public boolean isEmpty(){
        if(cursor==null){
            return true;
        }else {
            return false;
        }
    }
    public Node gotoBeginning(){
        Node n=cursor;
        if(isEmpty()){
            return null;
        }
        for(;;){
            if(n.next.key<n.key){
                cursor=n.next;
                return cursor;
            }
            n=n.next;
        }
    }
    public Node gotoEnd(){
        Node n=cursor;
        if(isEmpty()){
            return null;
        }
        for(;;){
            if(n.next.key<n.key){
                cursor=n;
                return cursor;
            }
            n=n.next;
        }
    }
    public Node gotoNext(){
        if(isEmpty()){
            return null;
        }
        cursor=cursor.next;
        return cursor;
    }
    public Node gotoPrior(){
        if(isEmpty()){
            return null;
        }
        Node n=cursor;
        for(;;){
            if(n.next==cursor){
                cursor=n;
                return cursor;
            }
            n=n.next;
        }
    }
    public Node getCursor(){
        if(isEmpty()){
            return null;
        }
        return cursor;
    }
    public void clear(){
        if(isEmpty()){
            return;
        }
        cursor=null;
    }
    public Node remove(){

        if(isEmpty()){
            return null;
        }
        Node n=cursor;
        for(;;){
            if(n.next==cursor){
                Node c=cursor;
                n.next=cursor.next;
                cursor=n.next;
                return c;
            }
            n=n.next;
        }
    }
    public Node remove(int deleteKey){
        if(isEmpty()){
            return null;
        }
        Node n=cursor;
        for(;;){
            if(n.next.key==deleteKey){
                Node m=n.next;
                n.next=m.next;
                cursor=n.next;
                return m;
            }
            if(n.next==cursor){
                return null;
            }

            n=n.next;
        }
    }
    public Node retrieve(int searchKey){
        if(isEmpty()){
            return null;
        }
        Node n=cursor;
        for(;;){
            if(n.key==searchKey){
                cursor=n;
                return cursor;
            }
            if(n.next==cursor){
                return null;
            }
            n=n.next;
        }
    }


}
