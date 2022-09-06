/**
  * An interface for a bag (multiset) of items with a maximum capacity
  */

public interface BagInterface<T>  {

  /** Adds an item to the bag if possible
    * @param item the item to be added
    * @return true if adding was sucessful, or false otherwise
    */
  public boolean add(T item);

  /** Removes an aribtrary instance of a given item from the bag.
    * @param item the item to be removed
    * @return the removed item, or null if item is not in the bag
    */
  public T remove(T item);

  /** Removes an arbitrary item from the Bag
    * @return the removed item, or null if the bag is empty
    */
  public T remove();

  public int size();

  public boolean isEmpty();

  public boolean isFull();

  /** 
    * @return the number of times (including 0) an item occurs inside the bag
    */
  public int getFrequencyOf(T item);

  /** 
    * @return true if item is in the bag; false otherwise
    */
  public boolean contains(T item);

  /** reset the bag to an empty one
    */
  public void clear();

  /** 
    * @return an array containing all items in the bag 
    * in no particular order
    */
  public T[] toArray();

  /** 
    * @return the intersection between this and anotherBag
    */
  public BagInterface<T> intersection(BagInterface<T> anotherBag);

  public BagInterface<T> union(BagInterface<T> anotherBag);

  public BagInterface<T> difference(BagInterface<T> another);

}
