package Concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ThreadDemo {
    public static void main(String[] args) {
        //createThread();
        //raceConditions();
        //lockThreadSafety();
        volatileThreadSafety();
        threadSignalling();
        atomicObjects();
        synchronizedCollections();
    }    


    /* public static void createThread() {
        System.out.println(Thread.currentThread().getName());
        
        var thread = new Thread(new DownloadFileTask());
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    } */

    /* public static void raceConditions() {
        //Confinement
        List<Thread> threads = new ArrayList<>();
        List<DownloadFileTask> tasks = new ArrayList<>();

        for (var i = 0; i < 10; i++) {
            var task = new DownloadFileTask();
            tasks.add(task);
            var thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads)
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        
        var totalBytes = tasks.stream()
        .map(t -> t.getStatus().getTotalByte())
        .reduce(Integer::sum);

        System.out.println(totalBytes);
    } */

    public static void lockThreadSafety() {
        //Synchronization
        var status = new DownloadStatus();

        List<Thread> threads = new ArrayList<>();
        for (var i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads)
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println(status.getTotalByte());
    }

    //adding the volatile keyword to the isDone field
    public static void volatileThreadSafety() {
        var status = new DownloadStatus();

        var thread1 = new Thread(new DownloadFileTask(status));
        var thread2 = new Thread(() -> {
            while (!status.isDone()) {}
            System.out.println(status.getTotalByte());
        });

        thread1.start();
        thread2.start();

    }

    public static void threadSignalling() {
        var status = new DownloadStatus();

        var thread1 = new Thread(new DownloadFileTask(status));
        var thread2 = new Thread(() -> {
            while (!status.isDone()) {
                synchronized(status) {
                    try {
                        status.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(status.getTotalByte());
        });        

        thread1.start();
        thread2.start();
    }

    public static void atomicObjects() {
        var status = new DownloadStatus();

        var thread1 = new Thread(new DownloadFileTask(status));
        var thread2 = new Thread(() -> {
            while (!status.isDone()) {}
            System.out.println(status.getTotalByte());
        });

        thread1.start();
        thread2.start();
    }

    public static void synchronizedCollections() {
        Collection<Integer> collection = Collections.synchronizedCollection(new ArrayList<>());

        var thread1 = new Thread(() -> collection.addAll(Arrays.asList(1, 2, 3)));
        var thread2 = new Thread(() -> collection.addAll(Arrays.asList(4, 5, 6)));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(collection);


    }
}
