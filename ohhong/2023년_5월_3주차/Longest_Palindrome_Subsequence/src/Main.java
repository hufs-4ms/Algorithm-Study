import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();

        // 1차원 DP 테이블 초기화
        int[] dp = new int[n + 1];

        // LCS 길이 계산
        for (int i = 1; i <= n; i++) {
            int prev = 0; // 이전 행의 이전 열 값
            for (int j = 1; j <= n; j++) {
                int current = dp[j]; // 이전 행의 현재 열 값 (LCS 길이)
                if (str.charAt(i - 1) == str.charAt(n - j)) {  // str과 뒤집힌 str을 비교
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = current;
            }
        }
        System.out.print(dp[n]);
    }
}

// str의 최장 회문 부수열의 길이를 계산하기 위해 LCS문제를 DP로 접근하여 이중반복문을 사용하게 되었다. 따라서 시간복잡도는 O(n^2)이다.