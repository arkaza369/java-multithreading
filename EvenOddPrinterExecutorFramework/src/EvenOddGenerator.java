public class EvenOddGenerator {
    private int totalNumThreads;
    private int num = 1;
    private int maxNumber;
    private boolean isEven = true;

    public EvenOddGenerator(int totalNumThreads, int maxNumber) {
        this.totalNumThreads = totalNumThreads;
        this.maxNumber = maxNumber;
    }

    public void evenPrinter(){
        synchronized (this){
            while(num < maxNumber - 1){
                while(!isEven){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Number: " + num + " :" + Thread.currentThread().getName());
                num++;
                isEven = false;
                notify();
            }
        }
    }

    public void oddPrinter(){
        synchronized (this){
            while(num < maxNumber - 1){
                while(isEven){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Number: " + num + " :" + Thread.currentThread().getName());
                num++;
                isEven = true;
                notify();
            }
        }
    }
}
