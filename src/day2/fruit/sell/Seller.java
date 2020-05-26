/* java study day2
 * access control specifier
 * */
package day2.fruit.sell;

public class Seller {
    private int apples;
    private int earning = 0;
    private final int APPLE_PRICE;

    public Seller(int apples, int APPLE_PRICE) {
        this.apples = apples;
        this.APPLE_PRICE = APPLE_PRICE;
    }

    public int sell(int money) {
        int numApples = Math.min(apples, money / APPLE_PRICE);
        apples -= numApples;
        earning += numApples * APPLE_PRICE;
        return numApples;
    }

    public int getPrice(int numApples) {
        return APPLE_PRICE * numApples;
    }

    public void printInfo() {
        System.out.printf("%s Apples: %d, Earning: %d\n",
                this.getClass().getSimpleName(), apples, earning);
    }
}
