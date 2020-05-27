/* java study day3
 * step: 4
 * */
package stepbystep.info;

public class PhoneCorpInfo extends PhoneInfo {
    private final String corp;

    public PhoneCorpInfo(String name, String phoneNumber, String corp) {
        super(name, phoneNumber);
        this.corp = corp;
    }

    public PhoneCorpInfo(PhoneInfo phoneInfo, String corp) {
        this(phoneInfo.getName(), phoneInfo.getPhoneNumber(), corp);
    }

    @Override
    public void printInfo() {
        System.out.printf("name: %s, phone number: %s, corp: %s\n",
                getName(), getPhoneNumber(), corp);
    }
}
