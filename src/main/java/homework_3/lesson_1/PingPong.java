package homework_3.lesson_1;

public class PingPong {

    public static void main(String[] args) {
        Object monitor = new Object();

        Thread ping = new Thread(() -> {
            synchronized (monitor) {
            while (true) {
                    System.out.println("Ping");
                    monitor.notify();
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            }
        });

        Thread pong = new Thread(() -> {
            synchronized (monitor) {
            while (true) {
                    System.out.println("Pong");
                    monitor.notify();
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            }
        });

        ping.start();
        pong.start();

    }
}
