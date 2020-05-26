/* java study day2
 * access control specifier
 * */
package day2.fruit.buy;

import day2.fruit.sell.Seller;

public class Buyer {
    private int apples = 0;
    private int money;

    public Buyer(int money) {
        this.money = money;
    }

    public void buy(Seller seller, int money) {
        int validMoney = Math.min(money, this.money);
        int numApples = seller.sell(validMoney);
        apples += numApples;
        this.money -= seller.getPrice(numApples);
    }

    public void printInfo() {
        System.out.printf("%s Apples: %d, Money: %d\n",
                this.getClass().getSimpleName(), apples, money);
    }
}
