public final class ListStack<T>
                   implements StackInterface<T>{
  private ListInterface<T> list;

  public ListStack(){
    list = new LinkedList<>();
  }

  public void push(T item){
    list.add(1, item);
  }

  public T pop(){
    if(isEmpty()){
      throw new StackEmptyException("stack is empty while popping");
    }
    assert !isEmpty();
    return list.remove(1);
  }

  public T peek(){
    if(isEmpty()){
      throw new StackEmptyException("stack is empty while popping");
    }
    assert !isEmpty();

    return list.getEntry(1);
  }

  public void clear(){
    list.clear();
  }

  public boolean isEmpty(){
    return list.isEmpty();
  } 
 
}
