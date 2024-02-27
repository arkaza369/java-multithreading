import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    BlockingQueue<Integer>queue;
    int maxSize;
    Producer(BlockingQueue<Integer>queue, int maxSize){
        this.queue = queue;
        this.maxSize = maxSize;
    }
    @Override
    public void run() {
        //produce [o-4) items.
        try{
            for(int i=0;i<4;i++){
                //void put(E e) throws InterruptedException e is the element to be added InterruptedException is thrown if the thread is interrupted while waiting.
                queue.put(i);
                System.out.println("Producer is producing: " + i);
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
