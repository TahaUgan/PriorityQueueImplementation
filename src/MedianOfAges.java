

public class MedianOfAges {
    
    
    private MinPQ<Integer> minHeap;
    private MaxPQ<Integer> maxHeap;

    public MedianOfAges(){

        maxHeap = new MaxPQ<Integer>();
        minHeap = new MinPQ<Integer>();

    }



    /**
     * Inserts a number to appropriate heap PQ.
     * </p>if MaxHeap is empty or {@code num} is smaller than maxHeap root then is is inserted into maxHeap. 
     * {@code Otherwise} inserted in minHeap.
     * 
     * </p> Then, it calculates maxHeap's size substracted from minHeap's size. if it it more than 1, it sends root of maxHeap to minHeap. And if the reverse happens, minHeap root is sent to maxHeap  
     * 
     * 
     * @param num
     */
    public void insertNum(int num){

        if(maxHeap.isEmpty() || num <= maxHeap.max()){

            maxHeap.insert(num);

        }else{
            
            minHeap.insert(num);

        }
        
        //checking size differences
        if(maxHeap.size() > minHeap.size() + 1){

            minHeap.insert(maxHeap.delMax());
            
        }else if(minHeap.size() > maxHeap.size()){

            maxHeap.insert(minHeap.delMin());
            
        }
    }


    
    /**
     * returns medianof all inserted numbers
     * 
     * @return {@code avg of roots from min and max heaps} if sizes are equal.
     *  
     *         </p>{@code maxheap root} if max heap has more elements.
     */
    public double findMedian(){

        if(maxHeap.size() == minHeap.size()){
            
            return (maxHeap.max() + minHeap.min()) / 2.0;

        }else{

            return maxHeap.max();

        }
    }

}
