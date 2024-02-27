import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       int TOTAL_NO_THREADS = 2;
       int MAX_NUMBER = 20;
       EvenOddGenerator evenOddGenerator = new EvenOddGenerator(TOTAL_NO_THREADS, MAX_NUMBER);
       ExecutorService executorService = null;
       try {
           executorService = Executors.newFixedThreadPool(TOTAL_NO_THREADS);
           executorService.submit(new EvenGenerator(evenOddGenerator));
           executorService.submit(new OddGenerator(evenOddGenerator));
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