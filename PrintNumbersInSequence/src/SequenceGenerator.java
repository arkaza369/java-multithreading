public class SequenceGenerator implements Runnable{
    private NumberGenerator numberGenerator;
    int numForCurrentThread;

    public SequenceGenerator(NumberGenerator numberGenerator, int numForCurrentThread) {
        super();
        this.numberGenerator = numberGenerator;
        this.numForCurrentThread = numForCurrentThread;
    }

    @Override
    public void run() {
        numberGenerator.generateNumber(numForCurrentThread);
    }
}
