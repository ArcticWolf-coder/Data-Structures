public class LinkedList{
  public Node head;
  
  
  /* First Constructor:
   * Creates a linked list using the values from the given array. head will refer
   * to the Node that contains the element from a[0]
   */ 
  public LinkedList(Object [] a){
    // TO DO
      head=new Node(a[0],null);
      Node tail=head;
      
      for(int i=1;i<a.length;i++){
         Node n=new Node(a[i],null);
          tail.next=n;
          tail=tail.next;
        
          
      }
     
      
      
  }
  
  /* Second Constructor:
   * Sets the value of head. head will refer
   * to the given LinkedList
   */
  public LinkedList(Node h){
    head=h;
    
    
  }
  
  /* Counts the number of Nodes in the list */
  public int countNode(){
      int sum=0;
      Node a=head;
      for(;;){
          sum++;
          if(a.next==null){
              break;
          }
          a=a.next;
      }
    return sum; // please remove this line!
  }
  
  /* prints the elements in the list */
  public void printList(){
    // TO DO
      Node temp=head;
      for(;;){
          System.out.print(temp.element);
          if(temp.next==null){
              break;
          }
          System.out.print(",");
          temp=temp.next;
      }
      
      System.out.println(".");
      
  }
  
  // returns the reference of the Node at the given index. For invalid index return null.
  public Node nodeAt(int idx){
    Node n=head;
    for(int i=0;;i++){
        
        
        if(i==idx){
            
            break;
        }
        n=n.next;
    }
        
    return n; // please remove this line!
  }
  
  
// returns the element of the Node at the given index. For invalid idx return null.
  public Object get(int idx){
    Node n=head;
    for(int i=0;;i++){
        if(i==idx){
            break;
        }
        n=n.next;
    }
    return n.element; // please remove this line!
  }
  
  
  
  /* updates the element of the Node at the given index. 
   * Returns the old element that was replaced. For invalid index return null.
   * parameter: index, new element
   */
  public Object set(int idx, Object elem){
      Node n=head;
      Object e=null;
      
      for(int i=0;;i++){
          if(n==null){
              break;
          }
          if(i==idx){
              
              e=n.element;
              n.element=elem;
              
              return e;
          }
          n=n.next;
      }
      return null;
     // please remove this line!
  }
  
  
  /* returns the index of the Node containing the given element.
   if the element does not exist in the List, return -1.
   */
  public int indexOf(Object elem){
    Node n=head;
    for(int i=0;;i++){
        if(n==null){
            return -1;
        }
        if(n.element==elem){
            return i;
        }
        n=n.next;
    }
     // please remove this line!
  }
  
  // returns true if the element exists in the List, return false otherwise.
  public boolean contains(Object elem){
    Node n=head;
    for(int i=0;;i++){
        if(n==null){
            break;
        }
        if(n.element==elem){
            return true;
        }
        n=n.next;
    }
                           
    return false; // please remove this line!
  }
  
  // Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
  public Node copyList(){
    
      Node n=head;
      Node h=new Node(head.element,null);
      Node t=h;
      for(Node num=n.next;;num=num.next){
          
          Node m=new Node(num.element,null);
          t.next=m;
          t=t.next;
          if(num.next==null){
              break;
          }
      }
      return h;
          
     // please remove this line!
  }
  
  // Makes a reversed copy of the given List. Returns the head reference of the reversed list.
  public Node reverseList(){
    //
    Node n=head;
    int sum=0;
    for(Node num=n;;num=num.next){
        sum++;
        if(num.next==null){
            break;
        }
    }
    Object[] a=new Object[sum];
    
    int i=0;
    for(Node num=n;;num=num.next){
        a[i++]=num.element;
        if(num.next==null){
            break;
        }
    }
    i=a.length-1;
    Object []c=new Object[a.length];
    for(int j=0;i>=0;j++,i--){
        c[j]=a[i];
    }
    LinkedList b=new LinkedList(c);
    
    return b.head; // please remove this line!
  }
  
  /* inserts Node containing the given element at the given index
   * Check validity of index.
   */
  public void insert(Object elem, int idx){
    Node h=head;
    Node n=head.next;
    if(idx==0){
        Node num=new Node(elem,h);
        head=num;
    } else {
        for(int i=1;;i++){
            if(i==idx){
               Node num=new Node(elem,n);
               h.next=num;
               break;
            }
            if(n==null){
                break;
            }
            h=h.next;
            n=n.next;
        }
    }  
  }
  
  
  /* removes Node at the given index. returns element of the removed node.
   * Check validity of index. return null if index is invalid.
   */
  public Object remove(int index){
    Node h=head;
    Node n=head.next;
    if(index==0){
        head=head.next;
        return h.element;
    } else {
        for(int i=1;;i++){
            if(i==index){
                Object m=n.element;
                n=n.next;
                h.next=n;
                return m;
            }
            if(n==null){
                return null;
            }
                   
            h=h.next;
            n=n.next;
        }
    }
    
  }
  
  // Rotates the list to the left by 1 position.
  public void rotateLeft(){
    Node n=head;
    
    head=head.next;
    n.next=null;
    for(Node num=head.next;;){
        if(num.next==null){
            num.next=n;
            
            break;
        }
        num=num.next;
    }
    
    
    
  }
  
  // Rotates the list to the right by 1 position.
  public void rotateRight(){
      
      if(head.next==null){
          return;
      }
      Node n=head.next;
      Node h=head;
      for(;;n=n.next,h=h.next){
          if(n.next==null){
              n.next=head;
              h.next=null;
              head=n;
              break;
          }
      }
      
      
      
  }
  
}