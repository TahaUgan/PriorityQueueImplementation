

import java.util.Comparator;
import java.util.NoSuchElementException;


public class MaxPQ<Key extends Comparable<Key>>{
    private Key[] pq;                    // store items at indices 1 to n
    private int n;                       // number of items on priority queue


  
    public MaxPQ(int initTahaCapacity) {
        pq = (Key[]) new Comparable[initTahaCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue.
     */
    public MaxPQ() {

        this(1);

    }

  

    /**
     * Returns true if this priority queue is empty.
     *
     * @return {@code true} if this priority queue is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Gets number of elements in MaxPQ.
     *
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns a largest key on this MaxPQ.
     *
     * @return the largest element in the array
     */
    public Key max() {
        if (isEmpty()){

            System.out.println("MaxPq has no elements");

        }
        return pq[1];
    }

    
    /**
     * resizes the array to given {@code capacity}
     * 
     * @param capacity new size of the array to be set.
     */
    private void resize(int capacity) {
        
        Key[] temp = (Key[]) new Comparable[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }


    /**
     * Inserting a new element with given type {@code (key)}.
     *
     * @param  x new element to be added
     */
    public void insert(Key x) {

        
        if (n == pq.length - 1){

            resize(2 * pq.length); // duplicating the size to have more space. Duplicate because of we increase size one-by-one, it wouldn't be effivient.
            
        }

        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        swim(n);
        
    }

    /**
     * Removes and returns a largest key on this priority queue.
     *
     * @return a largest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key delMax() {
        if (isEmpty()){

            System.out.println("No element exists in the array of MaxPq");

        }

        Key max = pq[1];

        exch(1, n--);
        sink(1);

        pq[n+1] = null;     // to clear memory a bit faster

        if ((n > 0) && (n == (pq.length - 1) / 4)){

            resize(pq.length / 2);
            
        }
        
        return max;
    }


  
    private void swim(int i) {
        while (i > 1 && less(i/2, i)) {
            exch(i/2, i);
            i = i/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }


    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }


}

