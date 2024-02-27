public class OddGenerator implements Runnable{
    private EvenOddGenerator evenOddGenerator;

    public OddGenerator(EvenOddGenerator evenOddGenerator) {
        this.evenOddGenerator = evenOddGenerator;
    }

    @Override
    public void run() {
        evenOddGenerator.oddPrinter();
    }
}
