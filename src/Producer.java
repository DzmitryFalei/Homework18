import java.util.concurrent.Semaphore;

public class Producer implements Runnable{

    Buffer store;
    Semaphore sem;

    public Producer(Buffer buffer, Semaphore sem) {
        this.store = buffer;
        this.sem = sem;
    }

    @Override
    public void run() {

        try {
            sem.acquire();
            for (int i = 1; i < 10; i++) {
                store.put();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
