public class Recursion {

  public static void main(String[] args){
    // countDown(10);
    // display(new Integer[]{1, 6, 7, 10});
    // int n = 5;
    // System.out.println(n + "! = " + factorial(n));
    // n = 1;
    // System.out.println(n + "! = " + factorial(n));
    // int x=2;
    // int y=8;
    // System.out.println(x+"^"+y+" = " + power(x, y));
    // x=2;
    // y=9;
    // System.out.println(x+"^"+y+" = " + power(x, y));
    // n = 10;
    // System.out.println("fib("+n+") = " + fib(n));
    // displayArray2(new Integer[]{1, 6, 7, 10});
    // displayArray2(new Integer[]{1, 13, 6, 7, 10});
    // towersOfHanoi(3, 0, 2, 1);
    //towersOfHanoi2(4, 0, 2, 1);
    Integer[] data = {10, 5, -1, 6, 7, 8};
    assert search(data, -1, 0, data.length-1)==true;
    assert search(data, 11, 0, data.length-1) == false;
    assert search(data, 10, 1, data.length-1)==false;
    assert search(data, 8, 1, 4)==false;
    assert search(data, 6, 3, 3)==true;
    assert search(data, 10, 5, 4) == false;


    Node<Integer> chain = new Node<>(10);
    chain.next = new Node<>(5);
    chain.next.next = new Node<>(-1);
    chain.next.next.next = new Node<>(6);
    chain.next.next.next.next = new Node<>(7);
    chain.next.next.next.next.next = new Node<>(8);

    assert search(chain, -1) == true;
    assert search(chain, 11) == false;
    assert search(chain.next, 10) == false;
    assert search(chain.next.next.next, 6) == true;

  }

  private static void countDown(int n){
    System.out.println(n);
    if(n > 1 ){
      countDown(n-1);
    }
  }

  public static <T> void display(T[] array){
    displayHelper(array, 0);
  }

  private static <T> void displayHelper(T[] array, int start){
    if(array.length != 0){
      System.out.println(array[start]);
      if(start != array.length-1){
        displayHelper(array, start+1);
      }
    }
  }

  public static int factorial(int n){
    if(n < 0){
      throw new IllegalArgumentException("Cannot compute factorial of a negative number");
    }
    int result = 1;
    if(n > 0){//base case
      result = n * factorial(n-1);
    }
    return result;
  }

  public static int powerIterative(int x, int n){
    assert(n >= 0);
    int result = 1;
    for(int i=0; i<n; i++){
      result *= x;
    }
    return result;
  }

  public static int power(int x, int n){
    int result = 1;
    if(n > 0){
      int temp = power(x, n/2);
      result = temp * temp;
      if(n%2 == 1){ //is n odd?
        result = x * result;
      }
    }
    return result;
  }

  public static int fib(int n){
    int result = 1;
    if(n >= 1){
      result = 1;
    } else {
      result = fib(n-1) + fib(n-2);
    }
    return result;
  }

  public static <T> void displayArray2(T[] array){
    displayArrayHelper2(array, 0, array.length-1);
  }

  private static <T> void displayArrayHelper2(
              T[] array, int start, int end){
      if(start == end){
        System.out.println(array[start]);
      } else {
        int mid = start + (end-start)/2;
        displayArrayHelper2(array, start, mid);
        displayArrayHelper2(array, mid+1, end);
        // displayArrayHelper2(array, mid+1, end);
        // displayArrayHelper2(array, start, mid); //<== DISPLAY IN REVERSE*/
      }
  }

  public static void towersOfHanoi(
            int n, int start, int end, int aux){
      if(n == 1){
        System.out.println(
        "Move one disk from " + start + " to " + end);
      } else{
        towersOfHanoi(n-1, start, aux, end);
        System.out.println(
          "Move one disk from " + start + " to " + end);
        towersOfHanoi(n-1, aux, end, start);
      }
  }

  public static void towersOfHanoi2(
    int n, int start, int end, int aux){
    while(n > 0){
      towersOfHanoi2(n-1, start, aux, end);
      System.out.println(
        "Move one disk from " + start + " to " + end);
      n = n-1;
      int t = start;
      start = aux;
      aux = t;
    }
  }

  public static <T> boolean search(T[] data, T target){
    return search(data, target, 0, data.length-1);
  }

  /*
   * searches for target inside the region of array 
   * between start and end inclusive
   * @param array: collection of items to search within
   * @param target: the desired item to find
   * @param start: the inlcusive starting index of the search region
   * @param end: the inclusive ending index of the search region
   * @return true if item is found in array; false otherwise
   */
  private static <T> boolean search(T[] array, T target, int start, int end){
    boolean result = false;

    if(start > end){ //empty region
      result = false;
    } else if(array[start].equals(target)){
      result = true;
    } else {
      result = search(array, target, start+1, end);
    }

    return result;

  }

  /*
   * searches for target inside the region of array 
   * between start and end inclusive
   * @param array: collection of items to search within
   * @param target: the desired item to find
   * @param start: the inlcusive starting index of the search region
   * @param end: the inclusive ending index of the search region
   * @return true if item is found in array; false otherwise
   */
  private static <T> boolean search(Node<T> firstNode, T target){
    boolean result = false;

    if(firstNode == null){
      result = false;
    } else if(firstNode.data.equals(target)){
      result = true;
    } else {   
      result = search(firstNode.next, target);
    }
    return result;

  }

  private static class Node<T>{
    private T data;
    private Node<T> next;

    private Node(T data){
      this(data, null);
    }

    private Node(T data, Node<T> next){
      this.data = data;
      this.next = next;
    }
  }
}
