import java.util.Iterator;

public class Driver {

    public static void main(String[] args){
        IterableLinkedList<String> list = 
            new IterableLinkedList<>();
        
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
            Iterator<String> iterator2 = list.iterator();
            while(iterator2.hasNext()){
                String s2 = iterator2.next();
                System.out.println(s2);
            }    
        }


    }
    
}
