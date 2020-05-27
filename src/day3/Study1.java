/* java study day3
 * for-each loop
 * */
package day3;

class Example {
    int num;
    Example(int i) { num = i; }
    int get() { return num; }
}

public class Study1 {

    public static void main(String[] args) {
        Example[] arr = {new Example(3), new Example(9), new Example(18)};

        for (Example e : arr) {
            e.num++;
            System.out.printf("%d ", e.get());
        }
        System.out.println();
        for (Example e : arr) {
            e.num += -18;
        }
        for (Example e : arr) {
            System.out.printf("%d ", e.get());
        }
        System.out.println();
        int a = 10;
        for (int i = 0; i < a--; i ++) {
            System.out.printf("%d ", i);
        }
        System.out.printf("\na: %d", a);
    }
}
