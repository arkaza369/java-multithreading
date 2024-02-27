public class NumberGenerator {
    private int number = 1;
    private int maxNumber;
    private int totalNumOfThreads;

    public NumberGenerator(int maxNumber, int totalNumOfThreads) {
        super();
        this.maxNumber = maxNumber;
        this.totalNumOfThreads = totalNumOfThreads;
    }
    /*
    Thread-1 will print 1, 4, 7
    Thread-2 will print 2, 5, 8
    Thread-3 will print 3, 6, 8
     1 2 3
     4 5 6
     7 8 9
     */
    public void generateNumber(int numForCurrentThread){
        synchronized (this){
            while(number < maxNumber - 1){
                while(number % totalNumOfThreads != numForCurrentThread){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Number generated: " + number++ + " by thread: " + Thread.currentThread().getName());
                notifyAll();
            }
        }

    }
}