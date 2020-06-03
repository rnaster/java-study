/* java study day2
 * step: 1
 * constructor overloading
 * */
package stepbystep.info;

public class PhoneInfo {
    private final String name;
    private final String phoneNumber;

    public PhoneInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public boolean isEqualName(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    public void printInfo() {
        System.out.printf("name: %s, phone number: %s\n",
                name, phoneNumber);
    }
}

class PhoneInfoTest {

    public static void main(String[] args) {
        PhoneInfo phoneInfo = new PhoneInfo("lee", "010-123-2344");
        phoneInfo.printInfo();
        PhoneInfo phoneInfo2 = new PhoneInfo("kim", "010-999-4532");
        phoneInfo2.printInfo();
    }
}
