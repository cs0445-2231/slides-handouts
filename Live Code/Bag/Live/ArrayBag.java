public final class ArrayBag<T> implements BagInterface<T> {
  final private int DEFAULT_CAPACITY = 10;
  private T[] bag; //physical size is bag.length
  private int numberOfItems; //logical size

  public ArrayBag(){
    this(DEFAULT_CAPACITY);
  }

  public ArrayBag(int initialCapacity){
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Object[initialCapacity];
    bag = temp;
    numberOfItems = 0;
  }

  //Copy constructor
  public ArrayBag(ArrayBag<T> other){
    //TODO
  }

    /** Adds an item to the bag if possible
    * @param item the item to be added
    * @return true if adding was sucessful, or false otherwise
    */
    public boolean add(T item) {
      return false;
    }
  

  /** Removes an aribtrary instance of a given item from the bag.
    * @param item the item to be removed
    * @return the removed item, or null if item is not in the bag
    */
  public T remove(T item){
    //TODO
    return null;
  }

  public T remove(){
    //TODO
    return null;
  }


  public int size(){
    return 0;
  }

  public boolean isEmpty(){
    return false;
  }

  public boolean isFull() {
    return false;
  }

  public int getFrequencyOf(T item) {
    return 0;
  }

  public void clear(){
  }

  public T[] toArray(){
   return null;
  }

  public boolean contains(T item){
    return false;
  }



  public BagInterface<T> intersection(BagInterface<T> anotherBag){
    
    return null;
  }

public BagInterface<T> union(BagInterface<T> anotherBag){
    return null;
}

public BagInterface<T> difference(BagInterface<T> anotherBag){
 return null;
}

  private void checkCapacity(int capacity){
    
  }

  private void checkIntegrity(){
    
  }

  private int indexOf(T item){
    return 0;
  }
}
