import java.util.concurrent.Semaphore;

public class Buffer {

    private int messageCount = 0;
    Semaphore sem;

    public Buffer(Semaphore sem) {
        this.sem = sem;
    }

    public void get() {

        while (messageCount < 1) {

            try {
                System.out.println("Consumer: Нет сообщений");
                Thread.sleep(2000);
                sem.release();
            } catch (InterruptedException e) {
                System.out.println("Consumer: Ошибка");
            }
        }

        System.out.println("Consumer: Читаю сообщение");
        messageCount--;
    }

    public void put() {

        while (messageCount >= 3) {

            try {
                System.out.println("Producer: Буффер переполнен");
                Thread.sleep(2000);
                sem.release();
            } catch (InterruptedException e) {
                System.out.println("Producer: Ошибка");
            }
        }

        System.out.println("Producer: Сообщение добавлено");
        messageCount++;
    }
}
