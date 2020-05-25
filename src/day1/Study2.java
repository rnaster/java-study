/* java study day 1
* 생성자, instance 변수 초기화
* */
package day1;

import java.util.Random;

class Triangle {
    int bottom;
    int height;

    public Triangle(int bot, int hei) {
        bottom = bot;
        height = hei;
    }

    public void setParams(int bot, int hei) {
        bottom = bot;
        height = hei;
    }

    public double getArea() {
        return bottom * height * 0.5;
    }
}

class BeadsBattle {
    int num_beads;
    String name;

    public BeadsBattle(String name, int beads) {
        num_beads = beads;
        this.name = name;
    }

    public void battle(BeadsBattle other) {
        Random rand = new Random();
        float prob = rand.nextFloat();
        int beads = Math.min(this.num_beads, other.num_beads);

        if (beads == 0) {
            System.out.println("not enough beads");
        } else if (prob > 0.5) {
            beads = rand.nextInt(beads);
            this.num_beads += beads;
            other.num_beads -= beads;
            System.out.printf("%s takes %d beads from %s\n",
                    this.name, beads, other.name);
        } else{
            beads = rand.nextInt(beads);
            this.num_beads -= beads;
            other.num_beads += beads;
            System.out.printf("%s takes %d beads from %s\n",
                    other.name, beads, this.name);
        }
    }

    public void printBeads() {
        System.out.printf("%s beads: %d\n", name, num_beads);
    }
}

public class Study2 {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(2, 3);
        System.out.printf("Triangle area: %.2f\n", triangle.getArea());
        triangle.setParams(7, 3);
        System.out.printf("Triangle area: %.2f\n", triangle.getArea());
        BeadsBattle player1 = new BeadsBattle("Min8", 10);
        BeadsBattle player2 = new BeadsBattle("Jin9", 32);
        player1.battle(player2);
        player1.printBeads();
        player2.printBeads();
        player1.battle(player2);
        player1.printBeads();
        player2.printBeads();
    }
}
