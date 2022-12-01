public final class LinkedStack<T>
                   implements StackInterface<T>{
  private Node topNode;

  public LinkedStack(){
    initializeFields();
  }

  public void push(T item){
    Node newNode = new Node(item);
    newNode.next = topNode;
    topNode = newNode;
  }

  public T pop(){
    if(isEmpty()){
      throw new StackEmptyException("empty stack while attempting to pop");
    }
    assert topNode != null;
    T result = topNode.data;
    topNode = topNode.next;
    return result;
  }

  public T peek(){
    if(isEmpty()){
      throw new StackEmptyException("empty stack while attempting to pop");
    }
    return topNode.data;
  }

  public void clear(){
    topNode = null;
  }

  public boolean isEmpty(){
    return topNode == null;
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
