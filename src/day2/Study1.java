/* java study day2
 * fruit sell and buy
 * */
package day2;

import day2.fruit.buy.Buyer;
import day2.fruit.sell.Seller;

public class Study1 {

    public static void main(String[] args) {
        Buyer buyer = new Buyer(100);
        Seller seller = new Seller(50, 10);

        System.out.println("Transaction 1");
        buyer.buy(seller, 20);
        buyer.printInfo();
        seller.printInfo();

        System.out.println("Transaction 2");
        buyer.buy(seller, 40);
        buyer.printInfo();
        seller.printInfo();

        System.out.println("Transaction 3");
        buyer.buy(seller, 1000);
        buyer.printInfo();
        seller.printInfo();
    }
}
