import java.util.concurrent.Semaphore;

public class NumberGenerator {
    private int maxNumberInSequence;
    private Semaphore evenSemaphore = new Semaphore(0);
    //we want first odd number to be printed this is why giving permit to odd semaphore
    private Semaphore oddSemaphore = new Semaphore(1);

    public NumberGenerator(int maxNumberInSequence) {
        this.maxNumberInSequence = maxNumberInSequence;
    }
    public void generateEvenNumber(){
        for(int i=2;i<=maxNumberInSequence;i+=2){
            try {
                evenSemaphore.acquire();
                System.out.println("Number: " + i + ": " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                //next odd should be printed so release the lock of it so that odd thread can acquire it.
                oddSemaphore.release();
            }
        }
    }

    public void generateOddNumber(){
        for(int i=1;i<=maxNumberInSequence;i+=2){
            try {
                oddSemaphore.acquire();
                System.out.println("Number: " + i + ": " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                //next odd should be printed so release the lock of it so that odd thread can acquire it.
                evenSemaphore.release();
            }
        }
    }
}
