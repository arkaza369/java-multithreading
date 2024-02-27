import java.util.LinkedList;

public class Consumer extends Thread{
    private LinkedList<Integer>queue;
    public Consumer(LinkedList<Integer>queue){
        this.queue = queue;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                synchronized (queue){
                    while(queue.isEmpty()){
                        System.out.println("Consumer is on wait as queue is empty... ");
                        queue.wait();
                    }
                    //remove first item from queue
                    int item = queue.remove();
                    System.out.println("Consumer is consuming currently: " + item);
                    queue.notify();
                }
            }
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}
