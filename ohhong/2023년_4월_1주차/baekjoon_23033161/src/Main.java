import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0, n = 0, sum = 0, temp = 0;
        n = sc.nextInt();
        sc.close();
        sum = n;
        while (sum % 3 != 0) {
            sum -= 5;
            a++;
            if (sum == 0) {
                System.out.println(a);
                return;
            } else if (sum < 0) {
                System.out.println("-1");
                return;
            }
        }
        temp = sum / 15;
        a = a + temp * 3;
        sum = sum % 15;
        b = sum / 3;
        System.out.println(a + b);
    }
}
