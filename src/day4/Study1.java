/* java study day 4
 * abstract class, interface
 * outer, inner class
 * local, anonymous
 * */
package day4;

interface TV {
    void onTV();
}

class TVImp {
    void onTV() {
        System.out.println("Sending video");
    }
}

interface Computer{
    void dataReceive();
}

class ComputerImp {

    public void dataReceive() {
        System.out.println("Receiving video");
    }
}

class IPTV implements TV, Computer {
    ComputerImp comp = new ComputerImp();
    TVImp tv = new TVImp();

    @Override
    public void onTV() {
        tv.onTV();
    }

    @Override
    public void dataReceive() {
        comp.dataReceive();
    }

    public void powerOn() {
        dataReceive();
        onTV();
    }
}

class OuterClass {
    private final int num;

    public OuterClass(int num) {
        this.num = num;
    }

    void print() {
        System.out.printf("%s - num: %d, %s - num: %d\n",
                this.getClass().getSimpleName(), num,
                InnerClass.class.getSimpleName(), InnerClass.num2);
    }

    class InnerClass {
        private static final int num2 = 1818;
        private final int num3;

        public InnerClass(int num3) {
            this.num3 = num3;
        }

        void print() {
            System.out.printf("%s - num: %d\n",
                    this.getClass().getSimpleName(), num2);
        }

        void printNum() {
            System.out.println(num3);
        }
    }
}

public class Study1 {

    public static void main(String[] args) {
        IPTV iptv = new IPTV();
        iptv.powerOn();

        TV tv = iptv;
        Computer comp = iptv;
        comp.dataReceive();
        tv.onTV();

        OuterClass cls = new OuterClass(28);
        cls.print();
        OuterClass.InnerClass cls2 = cls.new InnerClass(3838);
        cls2.print();
    }
}
