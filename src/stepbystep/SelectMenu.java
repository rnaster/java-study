/* java study day 3
 * step: 3
 * */
package stepbystep;

import java.util.Scanner;

class SelectMenu {

    static int select(Scanner sc) {
        int menu;
        System.out.println("Select menu.");
        System.out.println("0. Exit");
        System.out.println("1. Insert data");
        System.out.println("2. Search data");
        System.out.println("3. Delete data");
        System.out.print("Select: ");
        menu = sc.nextInt();
        sc.nextLine();
        System.out.println();
        return menu;
    }

}
