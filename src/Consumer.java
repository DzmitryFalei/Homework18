import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{

    Buffer buffer;
    Semaphore sem;

    public Consumer(Buffer store, Semaphore sem) {
        this.buffer = store;
        this.sem = sem;
    }

    @Override
    public void run() {

        try {
            sem.acquire();
            for (int i = 1; i < 10; i++) {
                buffer.get();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
