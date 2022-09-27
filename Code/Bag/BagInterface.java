/**
  * An interface for a bag (multiset) of items
  **/
public interface BagInterface<T> {

    /** Adds item to the bag.
     *  @return true if the insertion was successful
     *          and false otherwise.
     */
    public boolean add(T item);

    /** Removes an arbitrary instance of item from the bag
     * @param item is the item to be removed
     * @return the item that was removed.
     *         or null if item is not in the bag
     **/
    public T remove(T item);

    public T remove();

    public boolean contains(T item);

    public int getFrequencyOf(T item);

    public T[] toArray();

    public boolean isEmpty();

    public boolean isFull();

    public int size();

    public void clear();

    public BagInterface<T> intersection(BagInterface<T> anotherBag);

    public BagInterface<T> union(BagInterface<T> anotherBag);

    public BagInterface<T> difference(BagInterface<T> anotherBag);


}
