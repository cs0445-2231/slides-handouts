import java.util.Arrays;

public final class ArrayStack<T>
             implements StackInterface<T> {
      private final static int MAX_CAPACITY = 1000;
      private final static int DEFAULT_CAPACITY = 10;
      private T[] stack;
      private int topIndex; //the top of the stack in the array
      private boolean initialized;

      public ArrayStack(){
        this(DEFAULT_CAPACITY);
      }
      public ArrayStack(int capacity){
          if(capacity < DEFAULT_CAPACITY){
            capacity = DEFAULT_CAPACITY;
          } else {
            checkCapacity(capacity);
          }
          
          @SuppressWarnings("unchecked")
          T[] temp = (T[]) new Object[capacity];
          stack = temp;

          topIndex = -1;
          initialized = true;
      }

      public void push(T item){
        checkInitialized();
        stack[topIndex + 1] = item;
        ensureCapacity();
      }

      public T pop(){
        checkInitialized();
        if(isEmpty()){
          throw new StackEmptyException("stack is empty");
        }
        T result = stack[topIndex];
        stack[topIndex] = null;
        topIndex--;
        return result;
      }

      public T peek(){
        checkInitialized();
        if(isEmpty()){
          throw new StackEmptyException("stack is empty");
        }
        
        return stack[topIndex];
      }

      public void clear(){
        checkInitialized();
        while(!isEmpty()){
          pop();
        }
      }

      public boolean isEmpty(){
        return topIndex == -1;
      }


      private void checkCapacity(int capacity){
        if(capacity <= 0 || capacity > MAX_CAPACITY){
          throw new IllegalStateException(
                "Attempting to create an ArrayStack with invalid capacity.");
        }
      }

      private void checkInitialized(){
        if(!initialized){
          throw new SecurityException(
                "Attempting to access an uninitialized ArrayStack");
        }
      }

      private void ensureCapacity(){
        if(topIndex >= stack.length-1){//array is full
          checkCapacity(2*stack.length);
          stack = Arrays.copyOf(stack, 2*stack.length);
        }
      }
}
