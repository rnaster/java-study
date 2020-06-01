/* java study2 day 6
 * generic class
 * collection; ArrayList, LinkedList, Iterator
 * */
package day6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

class FruitBox<T> {
    T item;

    public FruitBox(T item) {
        this.item = item;
    }

    void store(T item) {
        this.item = item;
    }

    T pullOut() {
        return item;
    }
}

class Orange {
    int brix;

    public Orange(int brix) {
        this.brix = brix;
    }

    void printSugar() {
        System.out.printf("orange brix: %d\n", brix);
    }
}

class Apple {
    int weight;

    public Apple(int weight) {
        this.weight = weight;
    }

    void printWeight() {
        System.out.printf("apple weight: %d\n", weight);
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Person o = (Person) obj;
        return this.name.equals(o.name) && this.age == o.age;
    }

    @Override
    public String toString() {
        return String.format("%s(%d)", name, age);
    }
}

public class Study2 {

    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>(new Apple(10));
        FruitBox<Orange> orangeBox = new FruitBox<>(new Orange(20));
        appleBox.pullOut().printWeight();
        orangeBox.pullOut().printSugar();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(1818);
        list.add(2424);
        list.add(Integer.valueOf("10"));
        System.out.printf("ArrayList: %s\n", list);

        HashSet<Integer> set = new HashSet<>();
        set.add(3);
        set.add(1);
        set.add(5);
        set.add(1);
        set.add(10);
        System.out.printf("HashSet: %s\n", set);
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.printf("HashSet element: %d\n", iter.next());
        }
        HashSet<String> set2 = new HashSet<>();
        set2.add("faker");
        set2.add("T1");
        System.out.printf("set2 hash code: %d\n", set2.hashCode());
        for (String string: set2) {
            System.out.printf("%s hash code: %d\n", string, string.hashCode());
        }
        HashSet<Person> t1 = new HashSet<>();
        t1.add(new Person("faker", 20));
        t1.add(new Person("canna", 20));
        t1.add(new Person("teddy", 20));
        t1.add(new Person("faker", 20));
        t1.add(new Person("kim", 25));
        t1.add(new Person("kim", 20));
        t1.add(new Person("kim", 20));
        System.out.printf("t1 members: %d\n", t1.size());
        for (Person p: t1) {
            System.out.println(p);
        }
    }
}
