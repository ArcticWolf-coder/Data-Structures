package Assignment01;

public class BookRecord {
    public Book[] BookArray;
    public BookRecord(){
        BookArray =new Book[0];
    }
    public void AddRecord(Book b){
        Book[] a=new Book[BookArray.length+1];
        for(int i=0;i<BookArray.length;i++){
            a[i]=BookArray[i];
        }
        a[a.length-1]=b;
        BookArray=a;

    }

    public void PrintRecord(){
        for(int i=0;i<BookArray.length-1;i++){
            Book max=BookArray[i];
            int pos=i;
            for(int j=i+1;j<BookArray.length;j++){
                if(BookArray[j].Name.compareTo(max.Name)<0){
                    max=BookArray[j];
                    pos=j;

                }else if(BookArray[j].Name.compareTo(max.Name)==0){
                    if(BookArray[j].Id<max.Id){
                        max=BookArray[j];
                        pos=j;
                    }
                }
            }
            Book temp=BookArray[i];
            BookArray[i]=max;
            BookArray[pos]=temp;
        }
        for(Book x:BookArray){
            System.out.println("Name "+x.Name+" Id "+x.Id+" Author "+x.Author+" Publisher "+x.Publisher);

        }

    }
    public void DeleteRecord(int n){
        int sum=-1;
        for(int i=0;i<BookArray.length;i++){
            if(BookArray[i].Id==n){
                sum=i;
                break;
            }
        }
        if(sum==-1){
            System.out.println("ID "+n+" does not exist.");
        } else {
            Book []a=new Book[BookArray.length-1];
            int j=0;
            for(int i=0;i<BookArray.length;i++){
                if(i==sum){

                } else {
                    a[j++]=BookArray[i];
                }
            }
            BookArray=a;
            System.out.println("ID "+n+" deleted.");
        }

    }
    public void EditRecord(int n,String num, String p ){
        int sum=-1;
        for(int i=0;i<BookArray.length;i++){
            if(BookArray[i].Id==n){
                sum=i;
                BookArray[i].Name=num;
                BookArray[i].Publisher=p;
                break;
            }
        }
        if(sum==-1){
            System.out.println("ID "+n+" does not exist.");
        } else {

        }

    }

}
