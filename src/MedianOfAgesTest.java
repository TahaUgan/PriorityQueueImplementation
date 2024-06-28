


import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

import org.junit.Test;


public class MedianOfAgesTest {
    
    @Test
    public static void medianTestInManual(){

        MedianOfAges medianOfAges = new MedianOfAges();

        medianOfAges.insertNum(22);
        assertEquals(22, medianOfAges.findMedian(), 0);
        
        medianOfAges.insertNum(35);
        assertEquals(28.5, medianOfAges.findMedian(), 0);
        
        medianOfAges.insertNum(30);
        assertEquals(30, medianOfAges.findMedian(), 0);
        
        medianOfAges.insertNum(35);
        assertEquals(32.5, medianOfAges.findMedian(), 0);

        System.out.println("MedianTestInManualExample has succesfully completed");
        
    }
    
    
    
    
    /**
     * Test MedianOfAges with insertation of some numbers and calculating median every time while comparing with expected value.
     */
    @Test
    public static void testMedianOfAgesCase1(){
        
        MedianOfAges medianOfAges = new MedianOfAges();
        
        medianOfAges.insertNum(22);
        assertEquals(22, medianOfAges.findMedian(), 0);
        
        
        medianOfAges.insertNum(41);
        assertEquals(31.5, medianOfAges.findMedian(), 0);
        
        
        medianOfAges.insertNum(50);
        assertEquals(41, medianOfAges.findMedian(), 0);
        
            
        medianOfAges.insertNum(10);
        assertEquals(31.5, medianOfAges.findMedian(), 0);
        
        
        medianOfAges.insertNum(15);
        assertEquals(22, medianOfAges.findMedian(), 0);
        
        
        medianOfAges.insertNum(95);
        assertEquals(31.5, medianOfAges.findMedian(), 0);
        
        
        medianOfAges.insertNum(5);
        assertEquals(22, medianOfAges.findMedian(), 0);
        
        System.out.println("test Median Of Ages Case 1 has succesfully completed");
    }
    


    @Test
    public static void testMedianOfAgesCase2(){
        
        MedianOfAges medianOfAges = new MedianOfAges();
        
        medianOfAges.insertNum(30);
        assertEquals(30, medianOfAges.findMedian(), 0);
        
        medianOfAges.insertNum(10);
        assertEquals(20, medianOfAges.findMedian(), 0);
        
        medianOfAges.insertNum(20);
        assertEquals(20, medianOfAges.findMedian(), 0);
        
        medianOfAges.insertNum(40);
        assertEquals(25, medianOfAges.findMedian(), 0);
        
        medianOfAges.insertNum(50);
        assertEquals(30, medianOfAges.findMedian(), 0);
        
        System.out.println("test Median Of Ages Case 2 has successfully completed");
    }


    @Test
    public static void testMedianOfAgesCase3(){
        
        MedianOfAges medianOfAges = new MedianOfAges();

        medianOfAges.insertNum(5);
        assertEquals(5, medianOfAges.findMedian(), 0);

        medianOfAges.insertNum(15);
        assertEquals(10, medianOfAges.findMedian(), 0);

        medianOfAges.insertNum(1);
        assertEquals(5, medianOfAges.findMedian(), 0);

        medianOfAges.insertNum(3);
        assertEquals(4, medianOfAges.findMedian(), 0);

        medianOfAges.insertNum(8);
        assertEquals(5, medianOfAges.findMedian(), 0);

        System.out.println("test Median Of Ages Case 3 has successfully completed");
    }


    @Test
    public static void testMedianOfAgesCase4(){
        
        MedianOfAges medianOfAges = new MedianOfAges();

        medianOfAges.insertNum(100);
        assertEquals(100, medianOfAges.findMedian(), 0);

        medianOfAges.insertNum(200);
        assertEquals(150, medianOfAges.findMedian(), 0);

        medianOfAges.insertNum(300);
        assertEquals(200, medianOfAges.findMedian(), 0);

        medianOfAges.insertNum(400);
        assertEquals(250, medianOfAges.findMedian(), 0);

        medianOfAges.insertNum(500);
        assertEquals(300, medianOfAges.findMedian(), 0);

        System.out.println("test Median Of Ages Case 4 has successfully completed");
    }


    @Test
    public static void testMedianOfAgesCase5(){

        MedianOfAges medianOfAges = new MedianOfAges();

        medianOfAges.insertNum(7);
        assertEquals(7, medianOfAges.findMedian(), 0);

        medianOfAges.insertNum(3);
        assertEquals(5, medianOfAges.findMedian(), 0);

        medianOfAges.insertNum(1);
        assertEquals(3, medianOfAges.findMedian(), 0);

        medianOfAges.insertNum(9);
        assertEquals(5, medianOfAges.findMedian(), 0);

        medianOfAges.insertNum(8);
        assertEquals(7, medianOfAges.findMedian(), 0);

        System.out.println("test Median Of Ages Case 5 has successfully completed");
    }



}
