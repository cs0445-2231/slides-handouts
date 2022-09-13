import java.lang.reflect.Constructor;

public final class ArrayBag<T> implements BagInterface<T> {
  final static private int DEFAULT_CAPACITY = 10;
  final private int MAX_CAPACITY = 100000;
  private T[] bag; //physical size is bag.length
  private int numberOfItems; //logical size
  private boolean initialized = false;

  public ArrayBag(){
    this(DEFAULT_CAPACITY);
  }

  public ArrayBag(int initialCapacity){
    checkCapacity(initialCapacity);
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Object[initialCapacity];
    bag = temp;
    numberOfItems = 0;
    initialized = true;
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
      checkIntegrity();
      boolean result = false;
      if(!isFull()){
        bag[numberOfItems] = item;
        numberOfItems++;
        result = true;
      }
      return result;
    }
  

  /** Removes an aribtrary instance of a given item from the bag.
    * @param item the item to be removed
    * @return the removed item, or null if item is not in the bag
    */
  public T remove(T item){
    checkIntegrity();

    T result = null;

    int index = indexOf(item);
    if(index >= 0){
      result = bag[index];
      bag[index] = bag[numberOfItems-1];
      bag[numberOfItems-1] = null;
      numberOfItems--;
    }  

    return result;
  }

  public T remove(){
    checkIntegrity();
    T result = null;
    if(!isEmpty()){
      result = bag[numberOfItems-1];
      bag[numberOfItems-1] = null;
      numberOfItems--;  
    }
    return result;
  }


  public int size(){
    return numberOfItems;
  }

  public boolean isEmpty(){
    return numberOfItems == 0;
  }

  public boolean isFull() {
    return numberOfItems >= bag.length;
  }

  public int getFrequencyOf(T item) {
    checkIntegrity();
    int result = 0;
    for(T entry : bag){
      if(entry.equals(item)){ //Don't use entry == item
        result++;
      }
    }

    return result;
  }

  public void clear(){
    //bag = null; <== WRONG!
    //numberOfItems = 0;

    while(!isEmpty()){
      remove();
    }
  }

  public T[] toArray(){
    checkIntegrity();
    @SuppressWarnings("unchecked")
    T[] result = (T[])new Object[numberOfItems];
    for(int i=0; i<numberOfItems; i++){
      Class<?> c = bag[i].getClass();
      try{
        Constructor<?> copyConstructor = c.getConstructor(c);
        @SuppressWarnings("unchecked")
        T copy = (T) copyConstructor.newInstance(bag[i]);
        result[i] = copy;//deep copy of array elements
      } catch (Exception e){
        result[i] = bag[i]; //do a shallow copy if no copy constructor defined in T
      }
    }
     return result;
  }

  public boolean contains(T item){
    return getFrequencyOf(item) > 0;
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
    if(capacity > MAX_CAPACITY){
      throw 
        new IllegalStateException("Trying to allocate a too big ArrayBag object.");
    }
  }

  private void checkIntegrity(){
    if(!initialized){
      throw new SecurityException
        ("Trying to operate on a non-initialized ArrayBag object.");
    }
    
  }

  private int indexOf(T item){
    int result = -1;
    for(int i=0; i<numberOfItems; i++){
      if(bag[i].equals(item)){
        result = i;
        break;
      }
    }
    return result;
  }
}
