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

    void insertInfo(Scanner sc) {
        if (cur_ptr == 100) {
            System.out.println("Storage exceed!");
            return;
        }

        System.out.print("1. Common, 2. Univ, 3. Corp\nchoice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        PhoneInfo phoneInfo = insertCommonInfo(sc);
        switch (choice) {
            case 2 -> phoneInfo = insertUnivInfo(phoneInfo, sc);
            case 3 -> phoneInfo = insertCorpInfo(phoneInfo, sc);
        }
        collection[cur_ptr] = phoneInfo;
        collection[cur_ptr].printInfo();
        System.out.println();
        cur_ptr++;
    }

    PhoneInfo insertCommonInfo(Scanner sc) {
        return new PhoneInfo(insertName(sc), insertNumber(sc));
    }

    PhoneUnivInfo insertUnivInfo(PhoneInfo phoneInfo, Scanner sc) {
        return new PhoneUnivInfo(phoneInfo, insertMajor(sc), insertGrade(sc));
    }

    PhoneCorpInfo insertCorpInfo(PhoneInfo phoneInfo, Scanner sc) {
        return new PhoneCorpInfo(phoneInfo, insertCorp(sc));
    }

    String insertName(Scanner sc) {
        System.out.print("Name: ");
        return sc.nextLine();
    }

    String insertNumber(Scanner sc) {
        System.out.print("Number: ");
        return sc.nextLine();
    }

    String insertMajor(Scanner sc) {
        System.out.print("Major: ");
        return sc.nextLine();
    }

    int insertGrade(Scanner sc) {
        System.out.print("Grade: ");
        return sc.nextInt();
    }

    String insertCorp(Scanner sc) {
        System.out.print("Corp: ");
        return sc.nextLine();
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
