import java.util.Arrays;

public final class ArrayList<T> implements ListInterface<T> {

    private T[] list;
    int numberOfEntries;
    boolean initialized;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 100000;

    public ArrayList(){
      this(DEFAULT_CAPACITY);
    }
    public ArrayList(int initialCapacity){
      if(initialCapacity < DEFAULT_CAPACITY){
        initialCapacity = DEFAULT_CAPACITY;
      } else {
        checkCapacity(initialCapacity);
      }
      @SuppressWarnings("unchecked")
      T[] temp = (T[])new Object[initialCapacity];
      list = temp;
      numberOfEntries = 0;
      initialized = true;
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
      add(numberOfEntries+1, newEntry);
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
      checkIntegrity();
      if((newPosition >= 1) && (newPosition <= numberOfEntries+1)){

        if(newPosition < numberOfEntries+1){
          makeRoom(newPosition);
        }
        list[newPosition] = newEntry;
        numberOfEntries++;
        ensureCapacity();

      } else {
        throw new IndexOutOfBoundsException("wrong position in add");
      }

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
      T result = null;
      if(givenPosition >= 1 && givenPosition <= numberOfEntries){

        result = list[givenPosition];
        if(givenPosition < numberOfEntries){
          removeGap(givenPosition);
        }
        numberOfEntries--;
      } else {
        throw new IndexOutOfBoundsException("illegal position at remove");
      }
      return result;
     }
     
     /** Removes all entries from this list. */
     public void clear(){

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
      T result = list[givenPosition];
      if(givenPosition >= 1 && givenPosition <= numberOfEntries){

        list[givenPosition] = newEntry;
      } else {
        throw new IndexOutOfBoundsException("illegal position at replace");
      }

      return result;
     }
     
     /** Retrieves the entry at a given position in this list.
        @param givenPosition  An integer that indicates the position of
                               the desired entry.
         @return  A reference to the indicated entry.
         @throws  IndexOutOfBoundsException if either
                 givenPosition < 1 or givenPosition > getLength(). */
     public T getEntry(int givenPosition){
      if(givenPosition >= 1 && givenPosition <= numberOfEntries){

        return list[givenPosition];
      } else {
        throw new IndexOutOfBoundsException("illegal position at getEntry");
      }
     }
     
     /** Retrieves all entries that are in this list in the order in which
        they occur in the list.
         @return  A newly allocated array of all the entries in the list.
                 If the list is empty, the returned array is empty. */
     public T[] toArray(){
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries];
      for(int i=1; i<=numberOfEntries; i++){
        result[i-1] = list[i];
      }
      return result;
     }
   
     /** Sees whether this list contains a given entry.
      @param anEntry  The object that is the desired entry.
      @return  True if the list contains anEntry, or false if not. */
      public boolean contains(T anEntry){
        boolean found = false;
        for(int i=1; !found && i<=numberOfEntries; i++){
          if(list[i].equals(anEntry)){
            found = true;
          }
        }
        return found;
      }
      
      /** Gets the length of this list.
         @return  The integer number of entries currently in the list. */
      public int getLength(){
        return numberOfEntries;
      }

      private void checkCapacity(int capacity){
        if (capacity > MAX_CAPACITY){
          throw new IllegalStateException("Too large array");
        }
      }

      private void checkIntegrity(){
        if(!initialized){
          throw new SecurityException("list is not initialized");
        }
      }

      private void makeRoom(int position){
        for(int index = numberOfEntries; index >= position; index--){
         list[index+1] = list[index];
        }
      }

      private void removeGap(int givenPosition){
        for(int i=givenPosition; i<numberOfEntries; i++){
          list[i] = list[i+1];
        }
      }

      private void ensureCapacity(){
        int capacity = list.length - 1;
        if(numberOfEntries >= capacity){
          int newCapacity = 2*capacity;
          checkCapacity(newCapacity);
          list = Arrays.copyOf(list, newCapacity+1);
        }
      }
}