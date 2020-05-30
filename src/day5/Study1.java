/* java study day 5
 * exception
 * jvm memory area: method, stack, heap
 * comparing to other instance; equals
 * shallow copy, deep copy; cloneable, clone
 * */
package day5;

class Point implements Cloneable {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Point other) {
        return x == other.x && y == other.y;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", x, y);
    }
}

class Rectangle implements Cloneable {
    Point lowerLeft, upperRight;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.lowerLeft = new Point(x1, y1);
        this.upperRight = new Point(x2, y2);
    }

    public boolean equals(Rectangle other) {
        return lowerLeft.equals(other.lowerLeft)
                && upperRight.equals(other.upperRight);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Rectangle copy = (Rectangle) super.clone();
        copy.lowerLeft = (Point) copy.lowerLeft.clone();
        copy.upperRight = (Point) copy.upperRight.clone();
        return copy;
    }
}

class Business implements Cloneable {
    private final String corp;
    private String job;

    public Business(String corp, String job) {
        this.corp = corp;
        this.job = job;
    }

    void showBusinessInfo() {
        System.out.printf("corporation: %s, job: %s\n", corp, job);
    }

    void changeJob(String job) {
        this.job = job;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class PersonalInfo implements Cloneable {
    private String name;
    private int age;
    private Business business;

    public PersonalInfo(String name, int age, String corp, String job) {
        this.name = name;
        this.age = age;
        business = new Business(corp, job);
    }

    void showPersonalInfo() {
        System.out.printf("name: %s, age: %d, ", name, age);
        business.showBusinessInfo();
    }

    void changeJob(String job) {
        business.changeJob(job);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        PersonalInfo copy = (PersonalInfo) super.clone();
        copy.business = (Business) business.clone();
        return copy;
    }
}

public class Study1 {

    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 0;
        int num3;
        try {
            num3 = num1 / num2;
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass().getSimpleName());
            e.printStackTrace();
        }
        Rectangle rec1 = new Rectangle(1, 1, 2, 2);
        Rectangle rec2 = new Rectangle(1, 1, 2, 2);
        Rectangle rec3 = new Rectangle(2, 2, 1, 1);
        System.out.printf("rec1 is equal to rec2: %s\n", rec1.equals(rec2));
        System.out.printf("rec1 is equal to rec3: %s\n", rec1.equals(rec3));
        Point a = new Point(18, 28);
        Point c = a;
        try {
            Point b = (Point) a.clone();
            a.x = 38;
            System.out.printf("a: %s, b: %s, c: %s\n", a, b, c);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        try {
            PersonalInfo pInfo = new PersonalInfo("lee", 22,
                    "na2year", "ds");
            PersonalInfo copy = (PersonalInfo) pInfo.clone();
            pInfo.changeJob("back-end");
            pInfo.showPersonalInfo();
            copy.showPersonalInfo();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
