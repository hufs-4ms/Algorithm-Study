import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;  // 음수가 나오는 횟수를 저장
        int x = n-1, y = 0;  // 상단 오른쪽에서 부터 음수가 존재하는지 판단
        while(true){
            if(x<0||y>=n){  // 하단과 왼쪽으로 넘어가게 되면 탐색을 멈춤
                break;
            }
            if(arr[y][x] <0){  // 음수를 찾았을 때 왼쪽에 있는 열의 개수를 count에 저장
                count += x+1;
                y++;  // 열에 대한 음수를 찾았기 때문에 행을 아래로 옮김
            }else{
                x--;  // 열에서 음수를 찾지 못했기 때문에 열을 왼쪽으로 옮김
            }
        }
        System.out.print(count); // 전체 음수의 개수 출력
        br.close();
    }
}
// 탐색을 상단 오른쪽에서 하단 왼쪽으로 진행하기 때문에 탐색시간의 최대는 2n이된다. 그러므로 시간복잡도는 O(n)이다.