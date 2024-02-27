public class NumberGenerator {
    private int number = 1;
    private int maxNumber;

    public NumberGenerator(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public void generateNumber(int threadNumber){
        synchronized (this){
            while(number < maxNumber - 1){
                while(number % 2 != threadNumber){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Number: " + number + Thread.currentThread().getName());
                number++;
                notify();
            }
        }

    }
}
