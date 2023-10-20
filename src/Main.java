import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Semaphore sem = new Semaphore(2);
        Buffer store = new Buffer(sem);
        Producer producer = new Producer(store, sem);
        Consumer consumer = new Consumer(store, sem);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}