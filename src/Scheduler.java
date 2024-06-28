

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;




public class Scheduler {
    
    
    // Private class to store task details.
    private class Task implements Comparable<Task>{ // implementing to be able use in MinPQ<>();

        String name; // task name (e.g shipmentA)
        long deadline; // task deadline
        long duration;  //task duration
    
        // contructor with appropriate parameters
        public Task(String name, long deadline, long duration) {


            //appointin parameters to new task object to be created

            this.name = name;
            this.deadline = deadline;
            this.duration = duration;
        }
    
        @Override
        public int compareTo(Task t){
            
            if(this.deadline < t.deadline){

                return -1;

            }else if(this.deadline > t.deadline){

                return 1;

            }else{

                return 0;

            }
    
        }
    }

    private MinPQ<Task> taskQueue;
    private long currentTime;

    public Scheduler() {
        
        taskQueue =new MinPQ<Task>(); // Using Minimum based Priority Queue because deadlines should be ascending
        currentTime = 0; // current time when executing tasks. TIme Counter like usage
    }






    /**
     * Schedules a task with given {@code name}, {@code deadline}, {@code duration}.
     * 
     * </p>Firstly, creates a {@code Task} object with given parameters.
     * </p>Then, inserts the new {@code task object} it created into the {@code taskQueue}.     
     * </p>Lastly prints the task input message (e.g adding shipmentA with deadline 1300 and duration 30)
     * 
     * </p> Prints error if at least one parameter is null, as {@code "One or more of the parameters are null. Can't schedule a new task."}
     * 
     * 
     * 
     * @param name
     * @param deadline
     * @param duration
     * @throws Exception 
     *   
     * @return {@code 1} if no errors;
     *         {@code -1} if gives error
     * 
     */
    public int schedule(String name, long deadline, long duration){


        // checking if any of the parameters is null.
        if(isNull(name, deadline, duration)){

            // if one or more of them are null, it prints error message and doesn't schedule any task.

            System.err.println("One or more of the parameters are null. Cannot schedule a new task.");
            return -1;
            

        }else{
            // if no null parameter

            Task task = new Task(name, deadline, duration); // creatin a Task object

            taskQueue.insert(task); // inserting it into task queue

            // Printing regular add line
            System.out.println(currentTime + ": adding " + name + " with deadline " + deadline + " and duration " + duration);
            return 1;
        }
    }




    /**
     * Executes given {@code schedules} in {@code taskQueue} from, smallest to biggest {@code deadline}. As this system uses 
     * smallest based {@code Priority Queue}, we can use the root and remove it from the tree afterwards,
     * to go smallest -> biggest {@code deadline}. If the {@code currentTime} goes beyond the given {@code time} 
     * or {@code Priority Queue} becomes empty, method stops execution. At the and of the method, updates {@code currentTime} as 
     * given {@code time}.
     * 
     * </p> Prints error if given {@code time} is null, as {@code "Time is null. Can't execute with null time."}
     * 
     *  
     * @return {@code 1} if no errors;
     *         {@code -1} if gives error
     * 
     * @param time given time limit while executing tasks 
     */
    public int execute(long time){

        //checking if any null parameter
        if(isNull(time)){

            //given time is null

            System.err.println("Time is null. Can't execute with null time."); // printing error line if any null parameter
            return -1; // error code
            
        }else{

        // no null input

        // execution until list empties or time's up
        while(!taskQueue.isEmpty() && currentTime < time){
            
            
            Task task = taskQueue.delMin(); //taking task with smallest deadline value, which is root everytime in minimum Priority Queue case

            // printing info about task to be executed
            System.out.println(currentTime + ": busy with " + task.name + " with deadline " + task.deadline + " and duration " + task.duration);
            
            // checking if the task is executable in remaining time
            if(currentTime + task.duration <= time){

                //time is enough to execute the task
                
                currentTime += task.duration;
                
                //checks if task will be done before the deadline of the task or after it
                if (currentTime <= task.deadline) {
                    System.out.println(currentTime + ": done with " + task.name);
                } else {
                    System.out.println(currentTime + ": done with " + task.name + " (late)");
                }

            }else{

                // time is not enough to execute the task

                
                task.duration -= (time - currentTime);
                currentTime = time; // current time is at limited time after task if the task can't be executed in time.
                taskQueue.insert(task);// re-putting task into queue for exetuin at a later time.

                //printing regular task insertion message
                System.out.println(currentTime + ": adding " + task.name + " with deadline " + task.deadline + " and duration " + task.duration);
            }

        }

        
        
        currentTime = time;

        return 1; //no error

    }

    }


    /**
     * Reads the file at the location given as {@code FileLocation} and prints error if such file doesn't exists.
     * If the file exists, puts words into an array and looks the first word. </p>
     * If the first word is;
     * </p>{@code schedule:} proceeds with {@link #schedule(String, long, long)} method, using other words in the rest of the line as parameters. 
     * </p>{@code run:} proceeds with {@link #execute(long)} method, using other word in the rest of the line as parameters
     * </p>{@code something else:} then prints error, as {@code "There is a line with wrong syntax"}
     * 
     * </p>
     * </p>Repeats this process until it uses all the lines in the file.
     * 
     * @see #schedule(String, long, long)
     * @see #execute(long)
     * 
     * @param FileLocation source of file as {@code String}
     *   
     * @return {@code 1} if no errors;
     *         {@code -1} if gives error
     * 
     */
    public int getInstructions(String FileLocation){

        if(!new File(FileLocation).exists() || FileLocation == null){

            System.err.println("There is no such file.");
            return -1; // error code

        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FileLocation))) {
            String line;

            while((line = reader.readLine()) != null){
                
                String[] shipmentDatas = line.split(" "); // will divide command line to parts followingly schedule - task - deadline - duration (e.g schedule shipmentA 1300 30)
                                                                // OR execute_time - deadline (e.g run 2400)    

                if(shipmentDatas[0].equalsIgnoreCase("schedule")){
                    
                    // this means that given line has the command to schedule a shipment SO, we will schedule a shipment using schedule method

                    //command  -  name  -  deadline  -  duration
                    //  [0]       [1]          [2]         [3]

                    String name = shipmentDatas[1];

                    long deadline = Long.valueOf(shipmentDatas[2]); // using value of because, String -> long
                    long duration = Long.valueOf(shipmentDatas[3]); //same reason with 1 line above

                    int state = schedule(name, deadline, duration); // scheduling with appropriate parameters
                    
                    if(state == -1){
                        return -1; // means that schedule method gave error
                    }


                }else if(shipmentDatas[0].equalsIgnoreCase("run")){

                    // this means that this line wants the program to execute added shipments

                    // command  -  deadline  
                    //   [0]          [1]


                    long deadline = Long.valueOf(shipmentDatas[1]);

                    int state = execute(deadline); // executing task until given time limit

 
                    if(state == -1){
                        return -1; // means that schedule method gave error
                    }

                }else{
                    
                    // The case when there is some wrong line
                    
                    System.err.println("There is a line with wrong syntax"); // error messafe
                    return -1; // error code

                }


            }

            reader.close(); // reader gave warning, to suppress it

        } catch (NumberFormatException | IOException e) {
            // means that something went wrong while trying these commands above
            e.printStackTrace();
            return -1; // error code
        }

        return 1; // successfully works

    }


    /**
     * To check if there are any null value in given (unknown number of) parameters.
     * 
     * @param args given parameters to chech if null
     * @return {@code true} if there is one or more null variable given;
     *         {@code false} if there is no null in variables given
     */
    boolean isNull(Object... args) {
        for (Object arg : args) {
            if (arg == null) {
                return true;
            }
        }
        return false;
    }




}
