import java.util.LinkedList;

public class Producer extends Thread{
    private LinkedList<Integer>queue;
    private int currValue = 0;
    private int maxSize = 5;
    public Producer(LinkedList<Integer>queue){
        this.queue = queue;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                synchronized (queue){
                    while(queue.size() == maxSize){
                        System.out.println("Producer on wait as queue is full.. ");
                        queue.wait();
                    }
                    System.out.println("Producer is producing currently: " + currValue);
                    currValue++;
                    queue.add(currValue);
                    queue.notify();
                }
            }
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}
