/* java study day2
 * String: immutable, 문자열이 같다면 같은 주소를 참조한다.
           hashCode로 두 객체가 다름을 확인할 수 없다.
 * StringBuilder: mutable
 * StringBuffer: mutable, thread-safe
 * Scanner: user input
 * array: {}, int[][]
 * */
package day2;

import java.util.Arrays;
//import java.util.Scanner;

class ArrayOps {

    static void addNum(int[] arr, int num) {
        for (int i=0; i < arr.length; i++) {
            arr[i] += num;
        }
    }

    static void addNum(int[][] arr, int num) {
        for (int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[i].length; j++) {
                arr[i][j] += num;
            }
        }
    }

    static int[][] roll(int[][] arr) {
        int[][] newArr = new int[arr.length][];
        newArr[0] = arr[arr.length-1];
        System.arraycopy(arr, 0, newArr, 1, arr.length - 1);
        return newArr;
    }
}

public class Study4 {

    public static void main(String[] args) {
        String a = "aa";
        String b = "bb";
        String c = "aa";
        String d = new String(b);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(a.compareTo(b));
        System.out.println(d.hashCode());

        String str = "ABCDEFGH";
        StringBuilder stringBuilder = new StringBuilder(str);
        System.out.println(stringBuilder.reverse());

//        Scanner sc = new Scanner(System.in);
//        for (int i = 0; i < 3; i++) {
//            System.out.printf("num: %d\n", sc.nextInt());
//        }
        int[][] arr = {{1, 2, 3}, {3, 4}, {99, 3, 2}};
        for (int[] row : ArrayOps.roll(arr)) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        ArrayOps.addNum(arr, 18);
        for (int[] row: arr) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        ArrayOps.addNum(arr, -2);
        for (int[] row: arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
