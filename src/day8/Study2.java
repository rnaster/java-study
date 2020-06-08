/* java study day 8
 * multi-thread
 * re-entrant lock
 * atomic integer(thread-safe)
 * */
package day8;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Data3 {
    int num = 0;

    void increment() {
        num++;
    }
}

class Executor extends Thread {
    Data3 data3;

    public Executor(Data3 data) {
        this.data3 = data;
    }

    @Override
    public void run() {
        long start = Instant.now().toEpochMilli();
        for (int i = 0; i < 1000; i++) {
            data3.increment();
            try {
                sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = Instant.now().toEpochMilli();
        System.out.printf("Thread elapsed time: %gs\n",
                (end - start) / 1000.);
    }
}

class Executor2 extends Thread {
    AtomicInteger ordinal;

    public Executor2(AtomicInteger ordinal) {
        this.ordinal = ordinal;
    }

    @Override
    public void run() {
        long start = Instant.now().toEpochMilli();
        for (int i = 0; i < 1000; i++) {
            ordinal.getAndIncrement();
            try {
                sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = Instant.now().toEpochMilli();
        System.out.printf("Thread elapsed time: %gs\n",
                (end - start) / 1000.);
    }
}

public class Study2 {

    public static void main(String[] args) {
        List<Executor> list = new ArrayList<>();
        long start = Instant.now().toEpochMilli();
        Data3 data = new Data3();
        for (int i = 0; i < 30; i++) {
            Executor executor = new Executor(data);
            executor.start();
            list.add(executor);
        }
        for (Executor exec : list) {
            try {
                exec.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = Instant.now().toEpochMilli();
        System.out.printf("num: %d\n", data.num);
        System.out.printf("Total elapsed time: %gs\n",
                (end - start) / 1000.);
        System.out.println("#####################################\n");
        List<Executor2> list2 = new ArrayList<>();
        long start2 = Instant.now().toEpochMilli();
        AtomicInteger ordinal = new AtomicInteger(0);
        for (int i = 0; i < 30; i++) {
            Executor2 executor2 = new Executor2(ordinal);
            executor2.start();
            list2.add(executor2);
        }
        for (Executor2 exec : list2) {
            try {
                exec.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end2 = Instant.now().toEpochMilli();
        System.out.printf("num: %d\n", ordinal.get());
        System.out.printf("Total elapsed time: %gs\n",
                (end2 - start2) / 1000.);
    }
}
