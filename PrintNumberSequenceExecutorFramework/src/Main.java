import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int MAX_SEQUENCE_NUMBER = 20;
        int TOTAL_NO_OF_THREADS = 3;
        NumberGenerator numberGenerator = new NumberGenerator(MAX_SEQUENCE_NUMBER, TOTAL_NO_OF_THREADS);

        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(TOTAL_NO_OF_THREADS);
            executorService.submit(new SequenceGenerator(numberGenerator, 1));
            executorService.submit(new SequenceGenerator(numberGenerator, 2));
            executorService.submit(new SequenceGenerator(numberGenerator, 0));
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