/* java study day2
 * step: 1
 * constructor overloading
 * */
package stepbystep;

class PhoneInfo {
    private String name;
    private String phoneNumber;
    private String birthday;
    static PhoneInfo[] collection = new PhoneInfo[100];

    PhoneInfo(String name, String phoneNumber, String birthday) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    PhoneInfo(String name, String phoneNumber) {
        this(name, phoneNumber, null);
    }

    boolean isEqualName(String name) {
        return this.name.equals(name);
    }

    void setName(String name) {
        this.name = name;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    String getName() {
        return name;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    String getBirthday() {
        return birthday;
    }

    void printInfo() {
        System.out.printf("name: %s, phone number: %s, birthday: %s\n",
                name, phoneNumber, birthday);
    }
}

class PhoneInfoTest {

    public static void main(String[] args) {
        PhoneInfo phoneInfo = new PhoneInfo("lee", "010-123-2344");
        phoneInfo.printInfo();
        PhoneInfo phoneInfo2 = new PhoneInfo("kim",
                "010-999-4532", "99-12-01");
        phoneInfo2.printInfo();
    }
}
