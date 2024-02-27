import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       int TOTAL_NUMBER_IN_SEQUENCE = 20;
       NumberGenerator numberGenerator = new NumberGenerator(TOTAL_NUMBER_IN_SEQUENCE);
       EvenNumberGenerator evenNumberGenerator = new EvenNumberGenerator(numberGenerator);
       OddNumberGenerator oddNumberGenerator = new OddNumberGenerator(numberGenerator);
       //Thread1 will print odd numbers, Thread2 will print even numbers.
        //printing order could be anything, but it's guaranteed that 1st odd number will be printed because we
        //given permit to oddSemaphore first.[private Semaphore oddSemaphore = new Semaphore(1);]

       /*
       Thrrough creating threads...
       Thread thread1 = new Thread(oddNumberGenerator,"Thread-1");
       Thread thread2 = new Thread(evenNumberGenerator,"Thread-2");
       thread1.start();
       thread2.start();*/

        //Through Java Executor framework
       ExecutorService executorService = null;
       try {
           executorService = Executors.newFixedThreadPool(2);
           //generate odd numbers by thread 1 so submit oddNumberGenerator task first , generate even numbers by thread 2
           executorService.submit(oddNumberGenerator);
           executorService.submit(evenNumberGenerator);
       }
       catch (Exception e){
           e.printStackTrace();
       }
       finally {
           if(executorService != null){
               executorService.shutdown();
           }
       }

    }
}