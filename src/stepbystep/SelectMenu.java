/* java study day 5
 * step: 6
 * exception
 * */
package stepbystep;

import java.util.Scanner;

class SelectMenu {

    static int select(Scanner sc) throws PhoneBookException {
        int menu;
        System.out.println("Select menu.");
        System.out.println("0. Exit");
        System.out.println("1. Insert data");
        System.out.println("2. Search data");
        System.out.println("3. Delete data");
        System.out.println("4. Print all data");
        System.out.print("Select: ");
        menu = sc.nextInt();
        sc.nextLine();
        if (isWrongNumber(menu)) { throw new PhoneBookException(); }
        System.out.println();
        return menu;
    }

    static boolean isWrongNumber(int menu) {
        return 0 > menu || 4 < menu;
    }

}
