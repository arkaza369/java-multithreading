import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    BlockingQueue<Integer> queue;
    int maxSixe;
    Consumer(BlockingQueue<Integer>queue, int maxSixe){
        this.queue = queue;
        this.maxSixe = maxSixe;
    }

    @Override
    public void run() {
        try{
            while(queue.size() != 4){
                //E take() throws InterruptedException returns head of the queue InterruptedException is thrown if the thread is interrupted while waiting
                int item = queue.take();
                System.out.println("Consuming Item: "+ item);
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
