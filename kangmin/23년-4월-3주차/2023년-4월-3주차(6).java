// 코드트리 그리디
import java.util.Scanner;

public class Main {
    public static final int DIR_NUM = 5;
    public static final int MAX_N = 100;
    
    public static int n;
    public static int[][] arr = new int[MAX_N][MAX_N];
    
    public static int[] dx = new int[]{0, 0, 1,  0, -1};
    public static int[] dy = new int[]{0, 1, 0, -1,  0};
    
    public static boolean inRange(int x, int y) {
        if(x >= 0 && x < n && y >= 0 && y < n)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();

        int cnt = 0;
        for(int i = 1; i < n; i++)
            for(int j = 0; j < n; j++) {
                // arr[i - 1][j]가 0이면 누릅니다.
                if(arr[i - 1][j] == 0) {
                    cnt++;
                    for(int k = 0; k < DIR_NUM; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if(inRange(x, y) == false)
                            continue;
                        
                        arr[x][y] = 1 - arr[x][y];
                    }
                }
            }

        boolean possible = true;
        for(int i = 0; i < n; i++)
            if(arr[n - 1][i] != 1)
                possible = false;
        
        if(possible == false)
            System.out.print(-1);
        else
            System.out.print(cnt);
    }
}