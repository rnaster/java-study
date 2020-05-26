/* java study day2
 * encapsulation
 * */
package day2;

class Point {
    final int x;
    final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void printInfo() { System.out.printf("[%d, %d]", x, y); }
}

class Ring {
    Point point1;
    Point point2;
    int radius1, radius2;

    Ring(int x1, int y1, int r1, int x2, int y2, int r2) {
        point1 = new Point(x1, y1);
        radius1 = r1;
        point2 = new Point(x2, y2);
        radius2 = r2;
    }

    void printInfo() {
        System.out.printf("Inner Circle Info...\nradius: %d\n", radius1);
        point1.printInfo();
        System.out.printf("\nOuter Circle Info...\nradius: %d\n", radius2);
        point2.printInfo();
    }
}

public class Study2 {
    public static void main(String[] args) {
        Ring ring = new Ring(1, 1, 4, 2, 2, 9);
        ring.printInfo();
    }
}
