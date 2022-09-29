public class LinkedList<T> implements ListInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedList(){
        initializeFields(); //has to be private to avoid a child class from
                            //changing the constructor behavior
    }
    /** Sees whether this list is empty.
    @return  True if the list is empty, or false if not. */
    public boolean isEmpty(){
        return numberOfEntries == 0;
    }

    /** Adds a new entry to the end of this list.
         Entries currently in the list are unaffected.
            The list's size is increased by 1.
            @param newEntry  The object to be added as a new entry. */
    public void add(T newEntry){
        Node newNode = new Node(newEntry);
        if(isEmpty()){
            firstNode = newNode;
        } else {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.next = newNode;    
        }
        numberOfEntries++;

    }

    /** Adds a new entry at a specified position within this list.
         Entries originally at and above the specified position
        are at the next higher position within the list.
        The list's size is increased by 1.
        @param newPosition  An integer that specifies the desired
                            position of the new entry.
        @param newEntry     The object to be added as a new entry.
        @throws  IndexOutOfBoundsException if either
                newPosition < 1 or newPosition > getLength() + 1. */
    public void add(int newPosition, T newEntry){

    }

    /** Removes the entry at a given position from this list.
         Entries originally at positions higher than the given
        position are at the next lower position within the list,
        and the list's size is decreased by 1.
        @param givenPosition  An integer that indicates the position of
                                the entry to be removed.
        @return  A reference to the removed entry.
        @throws  IndexOutOfBoundsException if either 
                givenPosition < 1 or givenPosition > getLength(). */
    public T remove(int givenPosition){
        return null;
    }

    /** Removes all entries from this list. */
    public void clear(){
        initializeFields();
    }

    /** Replaces the entry at a given position in this list.
         @param givenPosition  An integer that indicates the position of
                                the entry to be replaced.
        @param newEntry  The object that will replace the entry at the
                        position givenPosition.
        @return  The original entry that was replaced.
        @throws  IndexOutOfBoundsException if either
                givenPosition < 1 or givenPosition > getLength(). */
    public T replace(int givenPosition, T newEntry){
        checkPosition(givenPosition);
        T result = null;
        Node current = firstNode;
        for(int i=1; i<givenPosition; i++){
            current = current.next;
        }
        result = current.data;
        current.data = newEntry;
        return result;
    }

    /** Retrieves the entry at a given position in this list.
         @param givenPosition  An integer that indicates the position of
                                the desired entry.
        @return  A reference to the indicated entry.
        @throws  IndexOutOfBoundsException if either
                givenPosition < 1 or givenPosition > getLength(). */
    public T getEntry(int givenPosition){
        checkPosition(givenPosition);
        T result = null;
        Node current = firstNode;
        for(int i=1; i<givenPosition; i++){
            current = current.next;
        }
        result = current.data;
        return result;
    }

    /** Retrieves all entries that are in this list in the order in which
         they occur in the list.
        @return  A newly allocated array of all the entries in the list.
                If the list is empty, the returned array is empty. */
    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        Node current = firstNode;
        int i = 0;
        while(current != null && i<numberOfEntries){
            result[i] = current.data;
            current = current.next;
            i++;
        }

        return result;
    } 

    /** Sees whether this list contains a given entry.
     @param anEntry  The object that is the desired entry.
    @return  True if the list contains anEntry, or false if not. */
    public boolean contains(T anEntry){
        boolean found = false;
        Node current = firstNode;
        while(!found && current != null){
            if(current.data.equals(anEntry)){
                found = true;
            }
            current = current.next;
        }
        return found;
    }
    
    /** Gets the length of this list.
    @return  The integer number of entries currently in the list. */
    public int getLength(){
        return numberOfEntries;
    }

    private void initializeFields(){
        firstNode = null;
        numberOfEntries = 0;
    }

    private void checkPosition(int position){
        if(position < 1 || position > numberOfEntries){
            throw new IndexOutOfBoundsException("invalid position");
        }
    }

    private Node getNodeAt(int givenPosition){
        Node current = firstNode;
        for(int i=1; i<givenPosition; i++){
            current = current.next;
        }
        return current;
    }

    private class Node {
        private T data;
        private Node next;

        private Node(T data){
            this(data, null)
        }

        private Node(T data, Node next){
            this.data = data;
            this.next = next;
        }

    }
      
}