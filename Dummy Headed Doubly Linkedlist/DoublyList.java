package ass;

import java.util.*;

public class DoublyList{
    public Node head;


    /* First Constructor:
     * Creates a linked list using the values from the given array. head will refer
     * to the Node that contains the element from a[0]
     */
    public DoublyList(Object [] a){
        head = new Node(null, null, null);
        Node tail = head;

        for(int i = 0; i<a.length; i++){
            Node mn = new Node(a[i], null, null);
            tail.next = mn;
            mn.prev=tail;
            tail=tail.next;
        }
        tail.next=head; // Making it circular
        head.prev=tail;
    }

    /* Second Constructor:
     * Sets the value of head. head will refer
     * to the given LinkedList
     */
    public DoublyList(Node h){
        head = h;
    }

    /* Counts the number of Nodes in the list */
    public int countNode(){
        int sum=0;
        for(Node n=head.next;;n=n.next){
            sum++;
            if(n.next==head){
                break;
            }
        }

        return sum; // please remove this line!
    }

    /* prints the elements in the list */
    public void forwardprint(){
        for(Node n=head.next;;n=n.next){
            if(n.next==head){
                System.out.println(n.element+".");
                break;
            }
            System.out.print(n.element+",");



        }
    }

    public void backwardprint(){
        for(Node n=head.prev;;n=n.prev){
            if(n.prev==head){
                System.out.println(n.element+".");
                break;
            }
            System.out.print(n.element+",");
        }
    }


    // returns the reference of the Node at the given index. For invalid index return null.
    public Node nodeAt(int idx){
        Node n=head.next;
        for(int i=0;;n=n.next,i++){
            if(i==idx){
                break;
            }
            if(n==head){

                return null;
            }

        }
        return n;

        // please remove this line!
    }



    /* returns the index of the Node containing the given element.
     if the element does not exist in the List, return -1.
     */
    public int indexOf(Object elem){
        // TO DO
        int i=0;
        for(Node n=head.next;;n=n.next,i++){
            if(n.element==elem){
                return i;
            }
            if(n.next==head){
                return -1;
            }

        }


    }



    /* inserts Node containing the given element at the given index
     * Check validity of index.
     */
    public void insert(Object elem, int idx){
        Node n=new Node(elem,null,null);
        if(idx==0){
            n.next=head.next;
            n.next.prev=n;
            head.next=n;
            n.prev=head;

        } else {
            int i=0;
            for(Node num=head.next;;num=num.next,i++){
                if(i==idx){
                    n.next=num;
                    n.prev=num.prev;
                    num.prev.next=n;
                    num.prev=n;
                    break;
                }
            }
        }

    }




    /* removes Node at the given index. returns element of the removed node.
     * Check validity of index. return null if index is invalid.
     */
    public Object remove(int index){
        Node n=head.next;
        if(index==0){
            head.next=n.next;

            n.next.prev=head;
            return n.element;
        }
        n=n.next;
        for(int i=1;;i++){
            if(i==index){
                n.prev.next=n.next;
                n.next.prev=n.prev;
                return n.element;
            }


            if(n.next==head){
                return null;
            }
            n=n.next;
        }



    }



}