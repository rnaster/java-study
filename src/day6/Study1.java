/* java study day 6
 * wrapper class; Integer, BigInteger ...
 * boxing, unboxing
 * */
package day6;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Study1 {

    public static void main(String[] args) {
        Integer val1 = new Integer(10);
        Integer val2 = new Integer(10);
        if (val1 == val2) {
            System.out.println("Same");
        } else {
            System.out.println("Different");
        }
        if (val1.equals(val2)) {
            System.out.println("Same 2");
        } else {
            System.out.println("Different 2");
        }
        Integer val3 = Integer.valueOf("10");
        Integer val4 = Integer.valueOf(10);
        if (val3 == val4) {
            System.out.println("Same 3");
        } else {
            System.out.println("Different 3");
        }
        System.out.printf("Long maximum: %d\n", Long.MAX_VALUE);
        BigInteger big1 = new BigInteger("1000000000000000000000000000");
        BigInteger big2 = new BigInteger("-999999999999999999999999999");
        System.out.printf("add: %s\n", big1.add(big2));
        System.out.printf("multiply: %s\n", big1.multiply(big2));
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        BigDecimal bigDecimal1 = new BigDecimal(a);
        BigDecimal bigDecimal2 = new BigDecimal(b);
        System.out.printf("abs: %g\n", bigDecimal2.subtract(bigDecimal1).abs());

    }
}
