public final class LinkedBag<T> implements BagInterface<T>{

  private int size;
  private Node firstNode;

  public LinkedBag(){
    size = 0;
    firstNode = null;
  }
  /** Adds item to the bag.
   *  @return true if the insertion was successful
   *          and false otherwise.
   */
  public boolean add(T item){
    firstNode = new Node(item, firstNode);
    size++;
    return true;
  }

  /** Removes an arbitrary instance of item from the bag
   * @param item is the item to be removed
   * @return the item that was removed.
   *         or null if item is not in the bag
   **/
  public T remove(T item){
    T result = null;
    if(!isEmpty()){
      Node toRemove = referenceTo(item);
      if(toRemove != null){
        result = toRemove.data;
        toRemove.data = firstNode.data;
        firstNode = firstNode.next;
        size--;
      }
    }
    return result;
  }

  public T remove(){
    T result = null;
    if(!isEmpty()){
      result = firstNode.data;
      firstNode = firstNode.next;
      size--;
    }
    return result;
  }

  public boolean contains(T item){
    return referenceTo(item) != null;
  }
  //run-time = 3 + 3*n + x <= the frequency of item
  // run-time = O(n)
  public int getFrequencyOf(T item){
    int result = 0;
    Node current = firstNode;
    while(current != null){ //number of items in the bag <= problem size (input size) (n)
      if(current.data.equals(item)){
        result++;
      }
      current = current.next;
    }

    /* DON'T DO THAT
    while(firstNode != null){
      firstNode = firstNode.next;
    }
    */

    return result;
  }

  public T[] toArray(){
    @SuppressWarnings("unchecked")
    T[] result = (T[]) new Object[size];
    int index = 0;
    Node current = firstNode;
    while(current != null){
      result[index] = current.data;
      current = current.next;
      index++;
    }
    return result;
  }

  public boolean isEmpty(){
    return size != 0;
  }

  public boolean isFull(){
    return false;
  }

  public int size(){
    return size;
  }

  public void clear(){
    firstNode = null;
    size = 0;
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

  private Node referenceTo(T item){
    Node result = null;
    Node current = firstNode;
    while(current != null){
      if(current.data.equals(item)){
        result = current;
        break;
      }
      current = current.next;
    }
    return result;
  }

  //nested class
  private class Node {
    private T data;
    private Node next;

    private Node (T data){
      this(data, null);
    }

    private Node(T data, Node next){
      this.data = data;
      this.next = next;
    }
  }

}
