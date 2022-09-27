import java.util.Arrays;

public class ResizableArrayBag<T> implements BagInterface<T>{

  private static final int DEFAULT_CAPACITY = 10;
  private static final int MAX_CAPACITY = 1000;
  private T[] bag;
  private int size;
  private boolean initialized;

  public ResizableArrayBag(){
    this(DEFAULT_CAPACITY);
  }

  public ResizableArrayBag(int initialCapacity){
    checkCapacity(initialCapacity);
    int size = 0;
    @SuppressWarnings("unchecked")
    T[] temp = (T[])new Object[initialCapacity];
    bag = temp;
    initialized = true;
  }

  //Copy constructor
  public ResizableArrayBag(ResizableArrayBag<T> other){
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
    bag[size] = item;
    size++;
    if(size == bag.length){
      doubleCapacity();
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
    return false;
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
    ResizableArrayBag<T> result = new ResizableArrayBag<>(newSize);

    ResizableArrayBag<T> copyOfAnotherBag =
      new ResizableArrayBag<>((ResizableArrayBag<T>)anotherBag);

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
    ResizableArrayBag<T> result = new ResizableArrayBag<>(this.size + anotherBag.size());

    //copy the items from Bag B into result
    for(int i=0; i<anotherBag.size(); i++){
      T item = ((ResizableArrayBag<T>)anotherBag).bag[i];
      result.add(item);
    }

    //create a copy of the B Bag
    ResizableArrayBag<T> copyOfAnotherBag =
      new ResizableArrayBag<T>((ResizableArrayBag<T>)anotherBag);

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
    ResizableArrayBag<T> result = new ResizableArrayBag<>(this); //copy of A
    ResizableArrayBag<T> copyOfAnotherBag = //copy of B
      new ResizableArrayBag<T>((ResizableArrayBag<T>) anotherBag);

    for(int i=0; i< size; i++){
      if(copyOfAnotherBag.contains(bag[i])){
        copyOfAnotherBag.remove(bag[i]);
        result.remove(bag[i]);
      }
    }
    return result;
  }


  private void checkCapacity(int capacity){
    if(capacity <= 0 || capacity > MAX_CAPACITY){
      throw new IllegalStateException("Attempting to intialize an ResizableArrayBag with an incorrect capacity.");
    }
  }

  private void checkIntegrity(){
    if(!initialized){
      throw new SecurityException("Attempting to operate on an uninitialized ResizableArrayBag.");
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

  private void doubleCapacity(){
    int newCapacity = 2*bag.length;
    checkCapacity(newCapacity);
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Object[newCapacity];
    for(int i=0; i<size; i++){
      temp[i] = bag[i];
    }
    bag = temp;
    //bag = Arrays.copyOf(bag, newCapacity);
  }

}
