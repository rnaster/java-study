/* java study day 7
 * thread
 * synchronized
 * */
package day7;

import static java.lang.Thread.sleep;

class ThreadTest extends Thread {

    public ThreadTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i=0; i < 5; i++) {
            System.out.printf("%d Thread name: %s\n", i, getName());
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Data {
    int num = 0;

    void increment(int i) {
        num += i;
    }
}

class ThreadTest2 extends Thread {
    static int num = 0;
    int a, b;
    static Data data = new Data();

    public ThreadTest2(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = a; i < b+1; i++) {
            num += i;
            data.increment(i);
        }
    }
}

class Data2 {
    int num = 0;
    void increment() {
        num += 1;
    }
}

class ThreadTest3 extends Thread {
    Data2 data;

    ThreadTest3(Data2 data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            data.increment();
        }
    }
}

public class Study2 {

    public static void main(String[] args) {
        ThreadTest test1 = new ThreadTest("test1");
        ThreadTest test2 = new ThreadTest("test2");
        ThreadTest test3 = new ThreadTest("test3");
        test1.start();
        test2.start();
        test3.start();
        for (int i=0; i < 5; i++) {
            System.out.println("###########################################");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ThreadTest2 test21 = new ThreadTest2(1, 250);
        ThreadTest2 test22 = new ThreadTest2(251, 500);
        test21.start();
        test22.start();
        try{
            test21.join();
            test22.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("ThreadTest2 num: %d\n", ThreadTest2.num);
        System.out.printf("ThreadTest2 Data num: %d\n", ThreadTest2.data.num);
        Data2 data2 = new Data2();
        ThreadTest3 threadTest31 = new ThreadTest3(data2);
        ThreadTest3 threadTest32= new ThreadTest3(data2);
        ThreadTest3 threadTest33 = new ThreadTest3(data2);
        threadTest31.start();
        threadTest32.start();
        threadTest33.start();
        try {
            threadTest31.join();
            threadTest32.join();
            threadTest33.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Data num: %d\n", data2.num);
    }
}
