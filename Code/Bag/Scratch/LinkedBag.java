public class LinkedBag<T> implements BagInterface<T>{

//TODO

  public LinkedBag(){
   //TODO
  }

  /** Adds an item to the bag if possible
    * @param item the item to be added
    * @return true if adding was sucessful, or false otherwise
    */
  public boolean add(T item){
    //TODO
  }

  /** Removes an aribtrary instance of a given item from the bag.
    * @param item the item to be removed
    * @return the removed item, or null if item is not in the bag
    */
  public T remove(T item){
    //TODO
  }

  /** Removes an arbitrary item from the Bag
    * @return the removed item, or null if the bag is empty
    */
  public T remove(){
    //TODO
  }

  public int size(){
    return size;
  }

  public boolean isEmpty(){
    return size == 0;
  }

  public boolean isFull(){
    //TODO
  }

  public int getFrequencyOf(T item){
   //TODO
  }

  public boolean contains(T item){
    //TODO
  }

  public void clear(){
    //TODO

  public T[] toArray(){
    //TODO
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
    //TODO

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
