// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentAdder concurrentAdder1 = new ConcurrentAdder(1,5);
        ConcurrentAdder concurrentAdder2 = new ConcurrentAdder(6,10);

        Thread thread1 = new Thread(concurrentAdder1);
        Thread thread2 = new Thread(concurrentAdder2);

        thread1.start();
        thread2.start();

        //main thread may terminate early before completion of thread 1 and 2.In this case we will get wrong sum. This is why we apply join on thread1 and thread2 so that main thread will wait for these threads completion.
        thread1.join();
        thread2.join();

        System.out.println(concurrentAdder1.getSum() + concurrentAdder2.getSum());
    }
}