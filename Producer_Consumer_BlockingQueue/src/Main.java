import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Producer Consumer Blocking Queue...");
        //wait, notify, synchronized, everything taken care by BlockingQueue
        int maxSize = 4;
        BlockingQueue<Integer>buffer = new ArrayBlockingQueue<>(maxSize);
        Producer producer = new Producer(buffer, maxSize);
        Consumer consumer = new Consumer(buffer, maxSize);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();
    }
}