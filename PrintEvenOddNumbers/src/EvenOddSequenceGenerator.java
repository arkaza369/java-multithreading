public class EvenOddSequenceGenerator implements Runnable{
    private NumberGenerator numberGenerator;
    private int threadNumber;

    public EvenOddSequenceGenerator(NumberGenerator numberGenerator, int threadNumber) {
        this.numberGenerator = numberGenerator;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        numberGenerator.generateNumber(threadNumber);
    }
}
