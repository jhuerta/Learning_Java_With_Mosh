package com.codewithmosh.threads;

import com.codewithmosh.ByteCount;

public class ThreadsDemo implements Runnable {
    private ByteCount status;

    public ThreadsDemo() {
        status = new ByteCount();
    }

    public void run()
    {
        try {
            downloadFile();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void downloadFile() throws InterruptedException {
//            System.out.println(Thread.currentThread().getName());
            for (var i = 0;i< 100;i++)
            {
                status.increment();
                if(Thread.currentThread().isInterrupted()) return;
                //System.out.println("Byte: " + totalBytes.getCount() + " (" + Thread.currentThread().getName() + ")");
            }

        //System.out.println("Download finished: " + Thread.currentThread().getName());
    }

    public ByteCount getByteCount() {
        return status;
    }
}
