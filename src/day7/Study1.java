/* java study day 7
 *
 * */
package day7;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

class MyClass implements Comparable<MyClass> {
    String val1;
    String val2;

    public MyClass(String val1, String val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    @Override
    public int compareTo(MyClass o) {
        return val1.compareTo(o.val1);
    }

    @Override
    public String toString() {
        return String.format("val1: %s, val2:%s", val1, val2);
    }
}

class MyClass2 implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length())
            return 1;
        else if (o1.length() < o2.length())
            return -1;
        return 0;
    }
}

public class Study1 {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1818);
        treeSet.add(-2);
        treeSet.add(-9);
        treeSet.add(-1818);
        treeSet.add(0);
        treeSet.add(1818);
        System.out.printf("TreeSet size: %d\n", treeSet.size());
        for (int i: treeSet) {
            System.out.println(i);
        }
        TreeSet<MyClass> test = new TreeSet<>();
        test.add(new MyClass("asd", "kdkd"));
        test.add(new MyClass("kkgkg", "1244"));
        test.add(new MyClass("ZXC", "podke"));
        test.add(new MyClass("PPAP", "like"));
        for (MyClass m: test) {
            System.out.println(m);
        }
        TreeSet<String> test2 = new TreeSet<>(new MyClass2().reversed());
        test2.add("a");
        test2.add("3kjk");
        test2.add("mxcvsdf");
        for (String a: test2) {
            System.out.println(a);
        }
        HashMap<String, Integer> test3 = new HashMap<>();
        test3.put("b", 2);
        test3.put("a", 1);
        test3.put("c", 99);
        test3.put("a", 1818);
        for (String a: test3.keySet()) {
            System.out.printf("key: %s, value: %s\n", a, test3.get(a));
        }

    }
}
