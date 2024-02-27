public class EvenNumberGenerator implements Runnable{
    private NumberGenerator numberGenerator;

    public EvenNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }


    @Override
    public void run() {
        numberGenerator.generateEvenNumber();
    }
}
