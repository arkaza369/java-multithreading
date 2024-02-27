// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int MAX_NUMBER = 20;
        NumberGenerator numberGenerator = new NumberGenerator(MAX_NUMBER);
        Thread thread1 = new Thread(new EvenOddSequenceGenerator(numberGenerator,1),"Thread-1");
        Thread thread2 = new Thread(new EvenOddSequenceGenerator(numberGenerator,0), "Thread-2");
        thread1.start();
        thread2.start();
    }
}