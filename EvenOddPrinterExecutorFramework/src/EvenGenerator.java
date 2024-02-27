public class EvenGenerator implements Runnable{
    private EvenOddGenerator evenOddGenerator;

    public EvenGenerator(EvenOddGenerator evenOddGenerator) {
        this.evenOddGenerator = evenOddGenerator;
    }

    @Override
    public void run() {
        evenOddGenerator.evenPrinter();
    }
}
