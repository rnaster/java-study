/* java study day 2
 * step: 2
 * Take user input
 * */
package stepbystep;

import java.util.Scanner;

class TakePhoneInfo {
    static Scanner sc = new Scanner(System.in);

    static int chooseMenu() {
        int menu;
        System.out.println("Choose menu.");
        System.out.println("1. Insert data");
        System.out.println("2. Exit");
        System.out.print("Choose: ");
        menu = sc.nextInt();
        sc.nextLine();
        System.out.println();
        return menu;
    }

    static void takeInfo() {
        int menu;
        String name;
        String phoneNumber;
        String birthday;
        PhoneInfo phoneInfo;

        while (true) {
            menu = chooseMenu();
            if (menu == 2) { break; }
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("Phone Number: ");
            phoneNumber = sc.nextLine();
            System.out.print("Birthday: ");
            birthday = sc.nextLine();
            phoneInfo = new PhoneInfo(name, phoneNumber, birthday);
            phoneInfo.printInfo();
            System.out.println();
        }
    }
}

class TakePhoneInfoTest {

    public static void main(String[] args) {
        TakePhoneInfo.takeInfo();
    }
}