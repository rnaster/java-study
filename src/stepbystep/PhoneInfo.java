/* java study day2
 * step: 1
 * constructor overloading
 * */
package stepbystep;

class PhoneInfo {
    private final String name;
    private final String phoneNumber;
    static PhoneInfo[] collection = new PhoneInfo[100];

    PhoneInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    boolean isEqualName(String name) {
        return this.name.equals(name);
    }

    String getName() {
        return name;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    void printInfo() {
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
