public class LinkedBag<T> implements BagInterface<T>{

  private int numberOfItems;
  private Node firstNode;

  public LinkedBag(){
   firstNode = null;
   numberOfItems = 0;
  }

  /** Adds an item to the bag if possible
    * @param item the item to be added
    * @return true if adding was sucessful, or false otherwise
    */
  public boolean add(T item){
    boolean result = false;
    Node newNode = new Node(item);
    newNode.next = firstNode;
    firstNode = newNode;
    numberOfItems++;
    return true;
  }

  /** Removes an aribtrary instance of a given item from the bag.
    * @param item the item to be removed
    * @return the removed item, or null if item is not in the bag
    */
  public T remove(T item){
    T result = null;
    Node ref = referenceTo(item);
    if(ref != null){
      result = ref.data;
      ref.data = firstNode.data;
      firstNode = firstNode.next;
    }
    return result;
  }

  /** Removes an arbitrary item from the Bag
    * @return the removed item, or null if the bag is empty
    */
  public T remove(){
    T result = null;
    if(!isEmpty()){
      result = firstNode.data;
      firstNode = firstNode.next;  
    }   
    return result;
  }

  public int size(){
    return numberOfItems;
  }

  public boolean isEmpty(){
    return numberOfItems == 0;
  }

  public boolean isFull(){
    //TODO
    return false;
  }

  public int getFrequencyOf(T item){
   int result = 0;
   Node current = firstNode;
   int index = 0;
   while(current != null && index < numberOfItems){
    if(item.equals(current.data)){
      result++;
    }
    index++;
    current = current.next;
   }

   return result;
  }

  public boolean contains(T item){
    //TODO
  }

  public void clear(){
    //TODO

  public T[] toArray(){
    @SuppressWarnings("unchecked")
    T[] result = (T[])new Object[numberOfItems];
    int i = 0;
    Node current = firstNode;
    while(current != null && i < numberOfItems){
      result[i] = current.data;
      i++;
      current = current.next;
    }
    return result;
  }

  public BagInterface<T> intersection(BagInterface<T> anotherBag){
    return null;
  }

  public BagInterface<T> union(BagInterface<T> anotherBag){
    return null;
  }

  public BagInterface<T> difference(BagInterface<T> another){
    return null;
  }

  private Node referenceTo(T item){
    Node result = null;
    boolean found = false;
    Node current = firstNode;
    while(!found && current != null){
      if(item.equals(current.data)){
        found = true;
        result = current;
      }
      current = current.next;
    }
    return result;
  }

  //nested class
  private class Node {
    T data;
    Node next;

    private Node(T data){
      this(data, null);
    }
    private Node(T data, Node next){
      this.data = data;
      this.next = next;
    }
  }
}
