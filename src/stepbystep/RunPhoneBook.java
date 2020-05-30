/* java study day 5
 * step: 6
 * exception
 * */
package stepbystep;

import java.util.Scanner;

import static stepbystep.info.PhoneInfo.collection;

public class RunPhoneBook {
    static Scanner sc = new Scanner(System.in);
    static PhoneBookManager manager = new PhoneBookManager(collection);

    static void run() {
        int menu;

        while (true) {
            try {
                menu = SelectMenu.select(sc);
            } catch (PhoneBookException e) {
                System.out.println(e.getMessage());
                continue;
            }
            if (menu == 0) {
                System.out.println("Bye!");
                break;
            }
            switch (menu) {
                case 1 -> {
                    try {
                        manager.insertInfo(sc);
                    } catch (PhoneBookException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> manager.searchInfo(sc);
                case 3 -> manager.deleteInfo(sc);
                case 4 -> manager.printAllInfo();
            }
        }
    }
}

class RunPhoneBookTest {

    public static void main(String[] args) {
        RunPhoneBook.run();
    }
}