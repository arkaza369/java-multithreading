public class OddNumberGenerator implements Runnable{
    private NumberGenerator numberGenerator;

    public OddNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public void run() {
        numberGenerator.generateOddNumber();
    }
}
