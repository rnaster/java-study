/* java study day 8
 * file I/O stream
 * */
package day8;

import java.io.*;

public class Study3 {

    public static void main(String[] args) throws IOException {
        OutputStream out = new FileOutputStream("data.bin");
        DataOutputStream filterOut = new DataOutputStream(out);
        filterOut.writeInt(1818);
        filterOut.writeDouble(1818.1818);
        filterOut.close();


        InputStream in = new FileInputStream("data.bin");
        DataInputStream filterIn = new DataInputStream(in);
        int num1 = filterIn.readInt();
        double num2 = filterIn.readDouble();
        filterIn.close();

        System.out.printf("num1: %d, num2: %g\n", num1, num2);

        OutputStream out2 = new FileOutputStream("println.txt");
        PrintStream printStream = new PrintStream(out2);
        printStream.print('h');
        printStream.print('a');
        printStream.close();

        Writer out3 = new FileWriter("a.txt");
        out3.write('a');
        out3.write('b');
        out3.close();
    }
}
