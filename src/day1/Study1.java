/* java study day 1
* println vs print : new line(\n)
* 상수는 int type으로 저장되며 그보다 큰 수를 사용하려면 끝에 L(혹은 소문자)를 붙여야 한다.
* type이 다른 두 수를 연산할 때 자동으로 type을 바꿔준다.
* long type에서 int로, double에서 float으로 type 변환을 할 때 데이터 손실이 있을 수 있다.
* / operator는 type에 따라 결과 값이 달라진다. int / int : 몫, float / int : 몫 + 소수점 이하 수
* >> vs >>> : >>는 sign bit가 움직이지 않아서 2의 배수를 곱한 것과 같다.
* >>>는 sign bit도 shift 하기 때문에 양수일 때는 >>와 차이가 없지만 음수일 때 차이가 난다.
* */
package day1;

public class Study1 {
    public static void main(String[] args) {
        System.out.print("System.out.print!!");
        System.out.println("Hell! world!");
        System.out.println("Java C8");
        System.out.println(987654321098765432L);
        System.out.println(-1.987654321);
        System.out.println(1 + 1.3);
        long num1 = 9876543210L;
        int num2 = (int)num1;
        System.out.printf("num1: %d, num2: %d\n", num1, num2);
        int a = 3;
        float b = 10.0f;
        System.out.println((double)a+b);
        System.out.println(7 / 3);
        System.out.println(7f / 3);
        System.out.println(7.2 % 2.1);
        System.out.printf("origin: %d\n", -32);
        System.out.printf("%d >> 2: %d\n", -32, -32 >> 2);
        System.out.printf("%d >>> 2: %d\n", -32, -32 >>> 2);
    }
}
