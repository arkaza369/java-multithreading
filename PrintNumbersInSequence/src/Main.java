public class Main {
    public static void main(String[] args) {
        //Reference: https://kkjavatutorials.com/java-program-to-print-numbers-in-sequence-using-3-threads/
        int MAX_SEQUENCE_NUMBER = 20;
        int TOTAL_NO_OF_THREADS = 3;
        NumberGenerator numberGenerator = new NumberGenerator(MAX_SEQUENCE_NUMBER, TOTAL_NO_OF_THREADS);
        Thread thread1 = new Thread(new SequenceGenerator(numberGenerator, 1), "Thread-1");
        Thread thread2 = new Thread(new SequenceGenerator(numberGenerator, 2), "Thread-2");
        Thread thread3 = new Thread(new SequenceGenerator(numberGenerator, 0), "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}