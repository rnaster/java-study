/* java study day 8
 * synchronized
 * */
package day8;

import java.util.Scanner;

class Data {
    int num1 = 0, num2 = 0;
    Object key = new Object();

    void addOneNum1() {
        synchronized (this) {
            num1 += 1;
        }
    }

    void addTwoNum1() {
        synchronized (this) {
            num1 += 2;
        }
    }

    void addOneNum2() {
        synchronized (key) {
            num2 += 1;
        }
    }

    void addTwoNum2() {
        synchronized (key) {
            num2 += 2;
        }
    }

    void print() {
        System.out.printf("num1: %d, num2: %d\n", num1, num2);
    }
}

class RunThread extends Thread {
    Data data;

    public RunThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            data.addOneNum1();
            data.addOneNum2();
            data.addTwoNum1();
            data.addTwoNum2();
        }
    }
}

class Data2 extends Thread {
    static final Scanner sc = new Scanner(System.in);
    String val;
//    Object key = new Object();

    void setVal() {
        System.out.print("insert: ");
        val = sc.nextLine();
        System.out.println();
        synchronized (this) {
            notify();
        }
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void getVal() {
        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("val: %s\n", val);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            setVal();
        }
    }
}

class Print extends Thread {
    Data2 data2;

    public Print(Data2 data2) {
        this.data2 = data2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            data2.getVal();
        }
    }
}

public class Study1 {

    public static void main(String[] args) {
        Data data = new Data();
        RunThread thread1 = new RunThread(data);
        RunThread thread2 = new RunThread(data);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        data.print();
        Data2 data2 = new Data2();
        Print pt = new Print(data2);
        pt.start();
        data2.start();
        try {
            pt.join();
            data2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
