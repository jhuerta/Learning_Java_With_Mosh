package com.codewithmosh;

import com.codewithmosh.executor.ExecutorDemo;
import com.codewithmosh.juancode.IPrintable;
import com.codewithmosh.streams.StreamsDemo;
import com.codewithmosh.threads.ThreadsDemo;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

import static java.lang.System.out;

public class Main {
    private static Object syncAdd = new Object();
    private static Lock lockSyncAdd = new ReentrantLock();
    public static void main(String[] args) {

        todo();

    }

    private static void todo()
    {

        var task1 = CompletableFuture.supplyAsync(() -> 1);
        var task2 = CompletableFuture.supplyAsync(() -> 2);
        var task3 = CompletableFuture.supplyAsync(() -> 3);
        var result = CompletableFuture.allOf(task1, task2, task3).thenRun( () -> out.println("finished"));
    }



    private static Supplier<String> getEmail(String id) {
        return () -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String s = id + "@.com";
            out.println(s);
            return s;};
    }

    private static void Executors2() {
        ExecutorDemo.exceptions();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void Executors()

    {
        out.println("About to call executor");
        ExecutorDemo.runAsync();
        out.println("Finished calling executor");

        try {
            Thread.sleep(7500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static void Streams() {
        StreamsDemo.show();
    }

    private static void Threads2() {

        Collection<Integer> numbers = Collections.synchronizedCollection(new ArrayList<>());

        var thread1 = new Thread( () -> {
            addNumbers(numbers, 1, 2, 3);
        });

        var thread2 = new Thread( () -> {
            addNumbers(numbers, 4, 5, 6);
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        out.println(numbers);



    }

    private /*synchronized*/ static void addNumbers(Collection<Integer> numbers, int i, int i2, int i3) {
        numbers.addAll(Arrays.asList(i, i2, i3));
//        synchronized(syncAdd)
//        {
//            numbers.addAll(Arrays.asList(i, i2, i3));
//        }

//        try{
//            lockSyncAdd.lock();
//            numbers.addAll(Arrays.asList(i, i2, i3));
//        }
//        finally {
//            lockSyncAdd.unlock();
//        }



    }

    private static void Threads() {

        List<ByteCount> totalBytes = new ArrayList<>();


        List<Thread> threads = new ArrayList<>();

        for(var i = 0;i<10;i++)
        {

            ThreadsDemo target = new ThreadsDemo();
            var thread = new Thread(target);
        totalBytes.add(target.getByteCount());
            thread.start();
            threads.add(thread);
        }

        for(var thread :threads)
        {
            try {
                thread.join();
            } catch (InterruptedException e) {

            }
        }

       out.println(totalBytes.stream().map(x -> x.getCount()).reduce(0,Integer::sum));



//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        thread.interrupt();

    }

    private static void go(IPrintable printer)
    {
        out.println("Inside");
        printer.print("message");
    }
}
