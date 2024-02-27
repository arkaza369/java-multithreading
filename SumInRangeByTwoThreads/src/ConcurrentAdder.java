public class ConcurrentAdder implements Runnable{
    private int start;
    private int end;
    private int counter = 0; //shared by both threads

    public ConcurrentAdder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for(int i = start; i<=end;i++){
            this.counter += i;
        }
    }
    public int getSum(){
        return this.counter;
    }
}
