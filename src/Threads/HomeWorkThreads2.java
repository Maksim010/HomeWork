package Threads;

import java.util.Scanner;
import java.util.TimerTask;
import java.util.concurrent.*;

public class HomeWorkThreads2 {
    private static volatile boolean doorOpened = false;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(() -> {
            try {
                personInside();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.execute(() -> personOutside());

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void personInside() throws InterruptedException {
        long startTime = (long) (Math.random()*10000);
        System.out.println(startTime);
        System.out.println("Человек находится в квартире");
        Thread.sleep(1000);
        if (startTime < 5000 ) {
            openDoor();
            Thread.sleep(3000);
        }

        if (!doorOpened) {
            Thread.sleep(2000);
            System.out.println("Человек в квартире не успел открыть дверь");

        }
        if (doorOpened){
            System.out.println("Человек в квартире успел открыть дверь");
        }
    }

    public static void personOutside() {
        try {
            Thread.sleep(500);
            System.out.println("Человек подходит и звонит в домофон");
            Thread.sleep(5000);// Simulating random time before calling the person inside
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!doorOpened) {
            doorOpened = true;
            System.out.println("Открыл дверь ключом");
        }
    }

    public static void openDoor() {
        doorOpened = true;

    }
}