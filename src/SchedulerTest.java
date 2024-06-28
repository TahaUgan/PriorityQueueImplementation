

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class SchedulerTest {

    
    
    /**
     * If this method {@code works}, this means that {@code every other method in Scheduler class works ass well}.
     * Because, {@link Scheduler#getInstructions(String)} method in Scheduler class uses every method in that class.
     * 
     * @see Scheduler#getInstructions(String) 
     */
    @Test
    public static void testSchedulerWithManualExamples(){

        Scheduler scheduler = new Scheduler();

        System.out.println(); // empty line to achieve clear output
        assertEquals(1, scheduler.getInstructions("sampleinput1.txt"));
        System.out.println(); // empty line to achieve clear output
        
        
        
    }
    
    
    /**
     * If this method {@code works}, this means that {@code every other method in Scheduler class works ass well}.
     * Because, {@link Scheduler#getInstructions(String)} method in Scheduler class uses every method in that class.
     * 
     * @see Scheduler#getInstructions(String) 
     */
    @Test
    public static void testGetInstructions(String location){
        
        Scheduler scheduler = new Scheduler();
        
        System.out.println(); // empty line to achieve clear output
        assertEquals(1, scheduler.getInstructions(location));
        System.out.println(); // empty line to achieve clear output

        
        
    }
    
    
    /**
     * Tests Scheduler with 5 different inputs.
     * Checks for errors.
     */
    @Test
    public static void testSchedulerWithSeveralInputs(){

        System.out.println();
        
        for(int i = 1; i <= 5; i++){
            
            Scheduler scheduler = new Scheduler();
            String fileName = "sampleInput" + i + ".txt";
            
            
            System.out.println("Test case " + i); // empty line to achieve clear output
            assertEquals(1, scheduler.getInstructions(fileName));
            System.out.println(); // empty line to achieve clear output
        

        }

    }


}
