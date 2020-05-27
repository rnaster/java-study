/* java study day 3
 * class inheritance, only single
 * */
package day3;

class Vehicle {
    private final String kind;

    public Vehicle(String kind) {
        this.kind = kind;
    }

    void printKind() {
        System.out.printf("%s kind: %s\n",
                this.getClass().getSimpleName(), kind);
    }

    void printSomething() {}
}

class Car extends Vehicle {

    public Car(String kind) {
        super(kind);
    }

    @Override
    void printSomething() {
        System.out.println("I`m Car!");
    }
}

class Truck extends Car {
    public Truck(String kind) {
        super(kind);
    }

    @Override
    void printSomething() {
        System.out.println("I`m Truck!");
    }
}

class Flight extends Vehicle {

    public Flight(String kind) {
        super(kind);
    }

    @Override
    void printSomething() {
        System.out.println("I`m Flight!");
    }
}


public class Study2 {

    public static void main(String[] args) {
        Vehicle[] vehicles = {new Flight("a-3"), new Car("hyundai"),
                new Car("KIA"), new Flight("b-10"), new Truck("volvo-3")};
        for (Vehicle vehicle : vehicles) {
            vehicle.printKind();
            vehicle.printSomething();
        }
    }
}
