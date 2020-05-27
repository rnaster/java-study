/* java study day3
 * step: 4
 * */
package stepbystep.info;

public class PhoneUnivInfo extends PhoneInfo {
    private final String major;
    private final int grade;

    public PhoneUnivInfo(String name, String phoneNumber,
                         String major, int grade) {
        super(name, phoneNumber);
        this.major = major;
        this.grade = grade;
    }

    public PhoneUnivInfo(PhoneInfo phoneInfo, String major, int grade) {
        this(phoneInfo.getName(), phoneInfo.getPhoneNumber(), major, grade);
    }

    @Override
    public void printInfo() {
        System.out.printf("name: %s, phone number: %s, major: %s, grade: %d\n",
                getName(), getPhoneNumber(), major, grade);
    }
}
