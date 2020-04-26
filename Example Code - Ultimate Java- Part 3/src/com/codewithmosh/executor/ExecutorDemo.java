package com.codewithmosh.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExecutorDemo {

    public static void exceptions()
    {
        var future = CompletableFuture.supplyAsync(() ->
        {
            System.out.println(" Done with this");

            if(System.currentTimeMillis()%2 == 0)
            {
                throw new IllegalStateException();
            }
            else
            {
                return 5;
            }


        });

        try {
            var o = (Integer) future.exceptionally(ex -> {
                System.out.println("we have called something good");
                return 1;
            }).get();
            System.out.println("Value: " + o  + "<----------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("our exception");
            System.out.println(e.getClass());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }
    public static void runAsync()
    {

        System.out.println("Before calling sleep async");
        var result = sleepAsync();
        result.thenRun(() -> System.out.println("It has been called"));
        result.thenAccept((i) -> System.out.println("It has been called: " + i));
        System.out.println("After calling sleep async");

    }

    private static CompletableFuture<Integer> sleepAsync() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Before sleep");
                Thread.sleep(3000);

                System.out.println("!!!!!! After sleep !!!!!!!");
                return 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return -1;
            }
        });
    }

    public static void run()
    {

        for(int i = 0;i<5;i++)
        {
            int finalI = i;
            CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(1500);
                    System.out.println("Finished: " + finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            });

            var endResult = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(1500);
                    return finalI;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return -1;
                }


            });
            try {
                var value = endResult.get();
                System.out.println("Futurable: " + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            /*
            var executor = Executors.newFixedThreadPool(5);
            var execResult = executor.submit(getResultsAfterTime);
            Integer resultFromExec = null;
            System.out.println("Waiting for : " + i);
            try {
                resultFromExec = execResult.get(10000, TimeUnit.SECONDS);
            } catch (InterruptedException e) {


            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            System.out.println("Done: " + resultFromExec);
            executor.shutdown();
            */

        }

        try {
            System.out.println("Before 5000");
            Thread.sleep(5000);
            System.out.println("Finished 5000");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private static Callable<Integer> getIntegerCallable(int finalValue1) {

        return () -> {
            try {
                Thread.sleep(1500);
                return finalValue1;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return -1;
            }


        };
    }
}
