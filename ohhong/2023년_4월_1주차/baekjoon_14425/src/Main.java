import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int cnt = 0;
        Map<String, Integer> tem = new HashMap<>();
        String arr;
        for (int i = 0; i < n; i++) {
            arr = sc.next();
            tem.put(arr, i);
        }
        for (int i = 0; i < m; i++) {
            arr = sc.next();
            if (tem.containsKey(arr)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}