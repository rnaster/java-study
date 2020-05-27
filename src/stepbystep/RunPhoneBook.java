/* java study day 2
 * step: 2
 * Take user input
 * */
package stepbystep;

import stepbystep.info.PhoneInfo;

import java.util.Scanner;
import static stepbystep.info.PhoneInfo.collection;

public class RunPhoneBook {
    static Scanner sc = new Scanner(System.in);

    static void run() {
        int menu;
        PhoneBookManager manager = new PhoneBookManager(collection);

        while (true) {
            menu = SelectMenu.select(sc);
            if (menu == 0) {
                System.out.println("Bye!");
                break;
            }
            switch (menu) {
                case 1 -> manager.insertInfo(sc);
                case 2 -> manager.searchInfo(sc);
                case 3 -> manager.deleteInfo(sc);
                default -> manager.printAllInfo();
            }
        }
    }
}

class RunPhoneBookTest {

    public static void main(String[] args) {
        RunPhoneBook.run();
    }
}