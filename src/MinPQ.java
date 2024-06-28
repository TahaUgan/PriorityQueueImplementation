
import java.util.Comparator;

public class MinPQ<Key extends Comparable<Key>>{
    private Key[] pq;                    // array to store Key's
    private int n;                      // number of elements
    private Comparator<Key> comparator;  // optional comparator
    

    public MinPQ(int initCapacity) {
        pq = (Key[]) new Comparable[initCapacity + 1];
        n = 0;
    }

    
    public MinPQ() {
        this(1);
    }


    /**
     * returns true-false according to numberof elements in array
     * 
     * @return {@code true} if the array is empty;
     *         {@code false} if the array is not empty
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of keys in this array.
     *
     * @return the number of elements
     */
    public int size() {
        return n;
    }

    /**
     * Gets minimum element in the array, which is root also. Prints error if no element in array.
     *
     * @return smallest element(Key) in the array, which is root alsoi.
     */
    public Key min() {
        if (isEmpty()){
            System.out.println("No element in the array");
        }

        return pq[1];
    }

    
    private void resize(int capacity) {
        
        Key[] temp = (Key[]) new Comparable[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    /**
     * Adds element <code>x</code> to the array. if size is not enough, expandsss the array using <href>{@link #resize(int)}</href> method.
     *
     * @param  x the element, Key, to be added in the array
     */
    public void insert(Key x) {
        
        if (n == pq.length - 1){
            resize(2 * pq.length);
        }

        pq[++n] = x; // added the element
        swim(n); // now rellocates the elements to correct places of there is something is in a way that we don't want to
        
    }

    /**
     * Returns the min element(the root in minHeap case) in this MinPQ array and removes from the array.
     * Prints error if there is no element in the Array
     * 
     * @return a smallest key on this priority queue which is root
     */
    public Key delMin() {
        if (isEmpty()){
            System.out.println("Heap is Empty");
        }

        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;     //memory cleaning here
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        
        return min;
    }


 
    private void swim(int k){
        while(k > 1 && greater(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while(2*k <= n){
            int j = 2*k;

            if (j < n && greater(j, j+1)){
                j++;
            }

            if (!greater(k, j)){    
                break;
            }

            exch(k, j);
            k = j;
        }
    }

    
    // private boolean greater(int i, int j) {
      
    //     return Integer.compare(i, j) > 0;

    // }

    private boolean greater(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }



    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }



}
