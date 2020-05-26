/* java study day2
 * what is static
 * static variable, method는 memory에 하나만 존재하며,
 * 해당 class의 여러 instance가 접근할 수 있다.
 * */
package day2;

class SimpleNumber {
    int num = 0;
    private static final SimpleNumber inst = new SimpleNumber();
    public void addNum(int n) { num += n; }
    public void printNum() { System.out.printf("num: %d\n", num); }
    public static SimpleNumber getInst() {
        return inst;
    }
}

public class Study3 {

    public static void main(String[] args) {
        SimpleNumber num1 = SimpleNumber.getInst();
        num1.addNum(18);
        SimpleNumber num2 = SimpleNumber.getInst();
        num2.addNum(28);

        num1.printNum();
        num2.printNum();
    }
}
