/* java study day 5
 * step: 6
 * exception
 * */
package stepbystep;

public class PhoneBookException extends Exception {

    public PhoneBookException() {
        super("Wrong number. Go back first menu.\n");
    }
}
