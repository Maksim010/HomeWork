package Threads;

public class HomeThreads {

    public static void main(String[] args) throws InterruptedException {

        Guard2 guard2=new Guard2();

        Guard2.Watches watches=new Guard2.Watches();
        guard2.start();

        watches.start();



    }
}
class Guard2 extends Thread {

    private static final Object lock = new Object();

    public void run() {
        synchronized (lock) {
            while(true){
                    try {
                        System.out.println( "1 Охранник встал на пост");
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                lock.notifyAll();

                        try {
                            System.out.println("2 Охранник встал на пост");
                            lock.wait();
                            lock.notifyAll();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                }
            }
        }

    static class Watches extends Thread {
        public void run() {
            synchronized (lock) {
                while (true) {
                    try {
                        for(int i=1;i<=11;i++){
                            System.out.println(i+" hour");
                            sleep(1000);
                        }
                        System.out.println("Будильник!");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}


