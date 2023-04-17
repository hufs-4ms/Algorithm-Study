import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 배열 크기
        int k = Integer.parseInt(st.nextToken()); // 찾을 값
        int[][] arr = new int[n][n]; // 2차원 배열 생성
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken()); // 2차원 배열 입력 받기
            }
        }
        int x=n-1, y=0;
        boolean result = false;  // k값이 존재하는지 파악
        while(true){
            if(x<0||y>=n){  // 하단과 왼쪽으로 넘어가게 되면 탐색을 멈춤
                break;
            }
            if(arr[y][x] < k){  // k보다 작은 값이 존재하면 열을 한칸 밑으로 옮김
                y++;
            }else if (arr[y][x] == k){  // k값을 찾았을 때
                if(x>0&&arr[y][x] == arr[y][x-1]){  // x값보다 앞의 수가 k일 때 사전 순서로 정의하기 위해서 왼쪽으로 옮김
                    x--;
                }else{
                    result = true;  // k값을 찾았으면 result를 true로 변환하고 종료
                    break;
                }
            }else{
                x--;  // k보다 큰 값이 존재하면 행을 한칸 왼쪽으로 옮김
            }
        }

        if(result){ // k를 찾은 경우
            System.out.print(y + " " + x);
        }else{ // k를 찾지 못한 경우
            System.out.print(-1); // -1 출력
        }
        br.close(); // 입력 스트림 닫기
    }
}

// 탐색을 상단 오른쪽에서 하단 왼쪽으로 진행하기 때문에 탐색시간의 최대는 2n이된다. 그러므로 시간복잡도는 O(n)이다.