public class CircularArray{
  
  private int start;
  private int size;
  private Object [] cir;
  
  /*
   * if Object [] lin = {10, 20, 30, 40, null}
   * then, CircularArray(lin, 2, 4) will generate
   * Object [] cir = {40, null, 10, 20, 30}
   */
  public CircularArray(Object [] lin, int st, int sz){
    cir=new Object[lin.length];
    this.size=sz;
    this.start=st;
    for(int i=start,j=0;j<size;j++){
      i%=lin.length;
      cir[i++]=lin[j];
    }
    //TO DO
  }
  
  //Prints from index --> 0 to cir.length-1
  public void printFullLinear(){
    for(int i=0;i<cir.length;i++){
      System.out.print(cir[i]+" ");
    }
    System.out.println();
  }
  
  // Starts Printing from index start. Prints a total of size elements
  public void printForward(){
    for(int i=start,j=0;j<size;j++){
      i%=cir.length;
      System.out.print(cir[i++]+" ");
    }
    System.out.println();
  }
  
  
  public void printBackward(){
    for(int i=start-1-(cir.length-size),j=0;j<size;j++){
      if(i<0){
        i=cir.length+i;
      }
      i%=cir.length;
      System.out.print(cir[i--]+" ");
    }
    System.out.println();
  }
  
  // With no null cells
  public void linearize(){
    //TO DO
    Object [] l=new Object[size];
    for(int i=start,j=0;j<size;i++){
      i%=cir.length;
      l[j++]=cir[i];
    }
    cir=l;
  }
  
  // Do not change the Start index
  public void resizeStartUnchanged(int newcapacity){
    Object [] o=new Object[newcapacity];
    for(int j=0,i=start,k=start;j<size;j++){
      k=k%cir.length;
      o[i++]=cir[k++];
      
    }
    cir=o;
  }
  
  // Start index becomes zero
  public void resizeByLinearize(int newcapacity){
    //TO DO
    Object o[]=new Object[newcapacity];
    for(int i=0,j=start;i<size;i++){
      j=j%cir.length;
      o[i]=cir[j++];
    }
    cir=o;
  }
  
  /* pos --> position relative to start. Valid range of pos--> 0 to size.
   * Increase array length by 3 if size==cir.length
   * use resizeStartUnchanged() for resizing.
   */
  public void insertByRightShift(Object elem, int pos){
    
       
       if(size==cir.length){
        resizeStartUnchanged(cir.length+3);
        }
       size++;
       Object temp=elem;
       for(int i=start+pos,j=pos;j<size;j++){
         i%=cir.length;
         Object t=cir[i];
         cir[i++]=temp;
         temp=t;
       }
       
       
         
         
       
      


    
  }
  
  public void insertByLeftShift(Object elem, int pos){
   
    if(size==cir.length){
        resizeStartUnchanged(cir.length+3);
        }
       size++;
       Object temp=elem;
       int i=start+pos;
       for(int j=pos;j>=0;j--){
         i%=cir.length;
         Object t=cir[i];
         cir[i--]=temp;
         temp=t;
       }
       start--;
       cir[i]=temp;
  }
  
  /* parameter--> pos. pos --> position relative to start.
   * Valid range of pos--> 0 to size-1
   */
  public void removeByLeftShift(int pos){
      int i=start+pos;
      int k=start+pos+1;
      for(int j=pos;j<size;j++,k++,i++){
          i=i%cir.length;
          k=k%cir.length;
          cir[i]=cir[k];
      }
      cir[i]=null;
      size--;
      
  }
  
  /* parameter--> pos. pos --> position relative to start.
   * Valid range of pos--> 0 to size-1
   */
  public void removeByRightShift(int pos){
    int i=start+pos;
    int j=start+pos-1;
    for(int k=pos;k>=1;i--,j--,k--){
        i%=cir.length;
        j%=cir.length;
        cir[i]=cir[j];
    }
    cir[i]=null;
    start++;
    size--;
        
  }
  
  
  //This method will check whether the array is palindrome or not
  public void palindromeCheck(){
    boolean b=true;
    int i=start;
    int j=start+size-1;
    for(int k=0;k<size/2;k++,j--,i++){
        i%=cir.length;
        if(j<0){
            j+=cir.length;
        } else {
            j%=cir.length;
        }
        if(cir[i]==cir[j]){
        } else {
            b=false;
            break;
        }
    }
    System.out.print("This array is ");
    System.out.println(b?"a palindrome.":"NOT a palindrome.");
        
  
  }
  
  
  //This method will sort the values by keeping the start unchanged
  public void sort(){
      for(int i=0,k=start+i;i<size-1;i++,k++){
          
          k%=cir.length;
          Object max=cir[k];
          int pos=k;
          for(int j=k+1,l=i+1;l<size;l++,j++){
              j%=cir.length;
              if((int)cir[j]<(int)max){
                  max=cir[j];
                  pos=j;
              }
          }
          Object temp=cir[k];
          cir[k]=max;
          cir[pos]=temp;
      }
  }
  
  //This method will check the given array across the base array and if they are equivalent interms of values return true, or else return false
  public boolean equivalent(CircularArray k){
    boolean b=true;
    if(size!=k.size){
        return false;
    }
    for(int i=0,j=start,l=k.start;i<size;j++,l++,i++){
        j%=cir.length;
        l%=k.cir.length;
        if(cir[j]==k.cir[l]){
        } else {
            b=false;
            break;
        }
    }
    return b;
  }
}