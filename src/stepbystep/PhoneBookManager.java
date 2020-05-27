/* java study day3
 * step: 3
 * */
package stepbystep;

import java.util.Scanner;

class PhoneBookManager {
    private int cur_ptr = 0;
    PhoneInfo[] collection;

    PhoneBookManager(PhoneInfo[] collection) {
        this.collection = collection;
    }

    void insert(Scanner sc) {
        if (cur_ptr == 100) { return; }
        String name = insertName(sc);
        System.out.print("Phone Number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Birthday: ");
        String birthday = sc.nextLine();
        collection[cur_ptr] = new PhoneInfo(name, phoneNumber, birthday);
        collection[cur_ptr].printInfo();
        System.out.println();
        cur_ptr++;
    }

    void printAllInfo() {
        for (int i = 0; i < cur_ptr; i++) {
            collection[i].printInfo();
        }
        System.out.println();
    }

    void printInfo(int idx) {
        if (idx < 0) {
            System.out.println("Not Found!\n");
            return;
        }
        collection[idx].printInfo();
        System.out.println();
    }

    String insertName(Scanner sc) {
        System.out.print("Name: ");
        return sc.nextLine();
    }

    void searchInfo(Scanner sc) {
        String name = insertName(sc);
        int idx = search(name);
        printInfo(idx);
    }

    int search(String name) {
        for (int i = 0; i < cur_ptr; i++) {
            if (collection[i].isEqualName(name)) { return i; }
        }
        return -1;
    }

    void deleteInfo(Scanner sc) {
        String name = insertName(sc);
        int idx = search(name);
        delete(idx);
    }

    void delete(int idx) {
        if (idx < 0) {
            System.out.println("Not Found!\n");
            return;
        }
        for (int i = idx; i < cur_ptr; i ++) {
            collection[i] = collection[i+1];
        }
        cur_ptr--;
        System.out.println("Delete!\n");
    }
}
