public final class LinkedStack<T>
                   implements StackInterface<T>{
  private Node topNode;

  public LinkedStack(){
    initializeFields();
  }

  public void push(T item){
    //TODO
  }

  public T pop(){
    //TODO
    return null;
  }

  public T peek(){
    //TODO
    return null;
  }

  public void clear(){
    //TODO
  }

  public boolean isEmpty(){
    //TODO
    return false;
  }

  
 private void initializeFields(){
  topNode = null;
 }

  private class Node{
    private T data;
    private Node next;

    private Node(T data){
      this(data, null);
    }

    private Node(T data, Node next){
      this.data = data;
      this.next = next;
    }
  }

}
