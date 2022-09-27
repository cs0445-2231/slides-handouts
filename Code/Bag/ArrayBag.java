public class ArrayBag<T> implements BagInterface<T>{

  private static final int DEFAULT_CAPACITY = 10;
  private static final int MAX_CAPACITY = 1000;
  private final T[] bag;
  private int size;
  private boolean initialized;

  public ArrayBag(){
    this(DEFAULT_CAPACITY);
  }

  public ArrayBag(int initialCapacity){
    checkCapacity(initialCapacity);
    int size = 0;
    @SuppressWarnings("unchecked")
    T[] temp = (T[])new Object[initialCapacity];
    bag = temp;
    initialized = true;
  }

  //Copy constructor
  public ArrayBag(ArrayBag<T> other){
    size = other.size;
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Object[other.bag.length];
    bag = temp;
    for(int i=0; i<size; i++){
      bag[i] = other.bag[i];
    }
    initialized = true;
  }
  /** Adds item to the bag.
   *  @return true if the insertion was successful
   *          and false otherwise.
   */
  public boolean add(T item){
    checkIntegrity();
    boolean result = false;
    if(!isFull()){
      bag[size] = item;
      size++;
    }
    return result;
  }

  /** Removes an arbitrary instance of item from the bag
   * @param item is the item to be removed
   * @return the item that was removed.
   *         or null if item is not in the bag
   **/
  public T remove(T item){
    checkIntegrity();
    T result = null;
    int index = indexOf(item);
    if(index != -1){
      result = bag[index];
      bag[index] = bag[size-1];
      bag[size-1] = null;
      size--;
    }
    return result;
  }

  public T remove(){
    checkIntegrity();
    T result = null;
    if(!isEmpty()){
      result = bag[size-1];
      bag[size-1] = null;
      size--;
    }
    return result;
  }

  public boolean contains(T item){
    checkIntegrity();

    return indexOf(item) != -1;
  }

  public int getFrequencyOf(T item){
    checkIntegrity();
    int result = 0;
    for(int i=0; i<size; i++){
      if(bag[i].equals(item)){
        result++;
      }
    }
    return result;
  }

  public T[] toArray(){
    @SuppressWarnings("unchecked")
    T[] result = (T[]) new Object[size];
    for(int i=0; i<size; i++){
      result[i] = bag[i];
    }
    return result;
    //return bag; <= VERY INSECURE!
  }

  public boolean isEmpty(){
    return (size == 0);
  }

  public boolean isFull(){
    return (size == bag.length);
  }

  public int size(){
    return size;
  }

  public void clear(){
    // for(int i=0; i<size; i++){
    //   bag[i] = null;
    // }
    // size = 0;
    while(!isEmpty()){
      remove();
    }
    //bag = null; <= DON'T DO THAT
  }

  public BagInterface<T> intersection(BagInterface<T> anotherBag){
    checkIntegrity();
    int newSize = Math.min(size, anotherBag.size());
    ArrayBag<T> result = new ArrayBag<>(newSize);

    ArrayBag<T> copyOfAnotherBag =
      new ArrayBag<>((ArrayBag<T>)anotherBag);

    for(int i=0; i<size; i++){
      if(copyOfAnotherBag.contains(bag[i])){
        result.add(bag[i]);
        copyOfAnotherBag.remove(bag[i]);
      }
    }
    return result;
  }

  public BagInterface<T> union(BagInterface<T> anotherBag){
    checkIntegrity();
    //Bag A is the this bag and Bag B is the anotherBag
    //create a result object with size = size of A + size of B
    ArrayBag<T> result = new ArrayBag<>(this.size + anotherBag.size());

    //copy the items from Bag B into result
    for(int i=0; i<anotherBag.size(); i++){
      T item = ((ArrayBag<T>)anotherBag).bag[i];
      result.add(item);
    }

    //create a copy of the B Bag
    ArrayBag<T> copyOfAnotherBag =
      new ArrayBag<T>((ArrayBag<T>)anotherBag);

    //loop over Bag A: if the item exists in the copy of B, remove import junit.framework.TestCase;
    //else add it to the result
    for(int i=0; i<size; i++){
      if(copyOfAnotherBag.contains(bag[i])){
        copyOfAnotherBag.remove(bag[i]);
      } else {
        result.add(bag[i]);
      }
    }

    return result;
  }

  public BagInterface<T> difference(BagInterface<T> anotherBag){
    checkIntegrity();
    ArrayBag<T> result = new ArrayBag<>(this); //copy of A
    ArrayBag<T> copyOfAnotherBag = //copy of B
      new ArrayBag<T>((ArrayBag<T>) anotherBag);

    for(int i=0; i< size; i++){
      if(copyOfAnotherBag.contains(bag[i])){
        copyOfAnotherBag.remove(bag[i]);
        result.remove(bag[i]);
      }
    }
    return result;
  }


  private void checkCapacity(int capacity){
    if(capacity < 0 || capacity > MAX_CAPACITY){
      throw new IllegalStateException("Attempting to intialize an ArrayBag with an incorrect capacity.");
    }
  }

  private void checkIntegrity(){
    if(!initialized){
      throw new SecurityException("Attempting to operate on an uninitialized ArrayBag.");
    }
  }

  private int indexOf(T item){
    int result = -1;
    for(int i=0; i<size; i++){
      if(bag[i].equals(item)){
        result = i;
        break;
      }
    }
    return result;
  }

}
