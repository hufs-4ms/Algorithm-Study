import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0, tmp = 0, n = 0, flag = 0, count = 0;
        String str;
        n = sc.nextInt();
        sc.close();
        while (++i > 0) {
            tmp = i;
            flag = 0;
            while (tmp > 0) {
                if (tmp % 1000 == 666) {
                    flag = 1;
                }
                tmp /= 10;
            }
            if (flag == 1) {
                count++;
                if (count == n) {
                    break;
                }
            }
        }
        System.out.println(i);
    }
}
