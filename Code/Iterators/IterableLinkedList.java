import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableLinkedList<T> implements Iterable<T>{
    private Node firstNode;


    private class LLIterator implements Iterator<T>{
        private Node next;
        private LLIterator(){
            next = firstNode;
        }
        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            if(next == null){
                throw new NoSuchElementException("no more items");
            }
            T result = next.data;
            next = next.next;
            return result;
        }
        
    }

    private class Node {
        private T data;
        private Node next;
    }

    @Override
    public Iterator<T> iterator() {
        return new LLIterator();
    }
    
}
