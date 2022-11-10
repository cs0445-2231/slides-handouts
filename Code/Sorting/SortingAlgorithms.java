import java.util.Arrays;

public class SortingAlgorithms<T extends Comparable<? super T>> {

    public static void main(String[] args){
        Student[] students = new Student[7];
        students[0] = new Student("foo", 4.0);
        students[1] = new Student("foo2", 3.9);
        students[2] = new Student("bar2", 3.8);
        students[3] = new Student("bar", 4.0);
        students[4] = new Student("alice2", 3.95);
        students[5] = new Student("foo3", 3.89);
        students[6] = new Student("alice", 4.0);

        new SortingAlgorithms<Student>(students);   

        Integer[] array = 
        {20, 10, 0, 30, 15, 1, 2, 90, 9, 35, -1, 3, 15, 4, -4, 0};

        new SortingAlgorithms<Integer>(array);   
          

    }

    public SortingAlgorithms(T[] data){
        selectionSort(data, 0, data.length-1);
        recursiveSelectionSort(data, 0, data.length-1);
        Node chain = createChain(data, data.length);
        selectionSort(chain);
        printChain(chain);
        insertionSort(data, 0, data.length-1);
        System.out.println(Arrays.toString(data));

    }
    
    /**
     * Sort a region inside the array bewteen start and end inclusive
     * not stable
     * @param <T>
     * @param a
     * @param start
     * @param end
     */
    public void selectionSort(T[] a, int start, int end){
        int n = end - start + 1;
        for(int i=0; i<n; i++){
            //find smallest item in region starting from i
            int smallestIndex = smallestIndex(a, start+i, end);
            //swap it with a[start+i]
            swap(a, smallestIndex, start+i);
        }
    }

    /**
     * return the index of the smalles item in a's range between start and end
     * inclusive
     * @param a
     * @param start
     * @param end
     * @return
     */
    private int smallestIndex(T[] a, int start, int end){
        T smallest = a[start];
        int smallestIndex = start;
        for(int i=start+1; i<=end; i++){
            if(a[i].compareTo(smallest) < 0){
                smallest = a[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    /**
     * swaps a[first] and a[second]
     * @param array
     * @param first
     * @param second
     */
    private void swap(T[] a, int first, int second){
        T temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    private void recursiveSelectionSort(T[] a, int start, int end){
        if(start <= end){
            int smallestIndex = smallestIndex(a, start, end);
            swap(a, start, smallestIndex);
            recursiveSelectionSort(a, start+1, end);
        }
    }

    public void selectionSort(Node firstNode){
        Node current = firstNode;
        while(current != null){
            //find smallest item in the rest of the chain
            //starting from current
            Node smallest = smallestNode(current);

            //swap smallest item with current.data
            swap(current, smallest);
            current = current.next;
        }
    }

    private Node smallestNode(Node firstNode){
        Node smallest = firstNode;
        Node current = firstNode;
        while(current != null){
            if(current.data.compareTo(smallest.data) < 0){
                smallest = current;
            }
            current = current.next;
        }
        return smallest;
    }

    private Node createChain(T[] a, int n){
        if(n == 0){
            return null;
        }
        Node firstNode = new Node(a[0], null);
        Node current = firstNode;
        for(int i=1; i<n; i++){
            current.next = new Node(a[i], null);
            current = current.next;
        }
        return firstNode;
    }
    
    private void printChain(Node firstNode){
       Node current = firstNode;
       while(current != null){
        System.out.print(current.data + " ");
        current = current.next;
       }
       System.out.println();
    }
    
    /**
     * swap first's and second's data items
     * @param first
     * @param second
     */
    private void swap(Node first, Node second){
        T temp = first.data;
        first.data = second.data;
        second.data = temp;
    }

    /**
     * Insertion Sort
     */

     public void insertionSort(T[] a, int start, int end){

        for(int unsorted = start+1; unsorted <= end; unsorted++){
            //insert a[unsorted] into the sorted region 
            //between start and unsorted-1
            insertInOrder(a, start, unsorted-1, a[unsorted]);
        }

     }

     /**
      * insert item into its sorted position in the sorted region between
      * start and end inclusive
      * @param a
      * @param start
      * @param end
      * @param item
      */
     private void insertInOrder(T[] a, int start, int end, T item){
        //if item > a[end] no shifting needed
        //a[end+1] = item
        //index is to be the correct position of item
        //shifting: a[index + 1] = array[index]
        int index = end+1;
        //if(index == start || a[index-1].compareTo(item) <= 0) stop
        while(index > start && a[index-1].compareTo(item) > 0){
            a[index] = a[index-1];
            index -= 1;
        }
        a[index] = item;
     }

    private static class Student implements Comparable<Student>{
        private String name;
        private Double gpa;

        private Student(String name, Double gpa){
            this.name = name;
            this.gpa = gpa;
        }

        public int compareTo(Student other){
            return gpa.compareTo(other.gpa);
        }

        public String toString(){
            return "(" + name + " " + gpa + ")";
        }
    }

    private class Node {
        T data;
        Node next;

        private Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }
}
