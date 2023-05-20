// 백준 스택,구현(22866)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1], cnt = new int[N+1];
        int[][] answer = new int[N+1][2];
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++)
            Arrays.fill(answer[i], 100001);
        // 우측 건물 탐색
        for(int i=1; i<=N; i++){
            // 작은 건물들은 넘어감
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i])
                stack.pop();
            // 현재 건물보다 큰 건물 더하기
            cnt[i] += stack.size();

            if(!stack.isEmpty()){
                int gap = Math.abs(stack.peek()-i); // 현재 건물과 기준 건물의 거리 차이
                if(gap<answer[i][1]){   // 거리가 작은 경우 갱신
                    answer[i][0] = stack.peek();    // 기준 건물
                    answer[i][1] = gap; // 차이 값
                }
                // 만약 차이가 같은 경우와 건물 번호가 작은 경우 갱신
                else if(gap == answer[i][1] && stack.peek() < answer[i][0]){
                    answer[i][0] = stack.peek();
                }
            }
            stack.push(i);
        }
        // 좌측 건물 탐색
        stack = new Stack<>();
        for(int i=N; i>=1; i--){
            // 작은 건물들은 넘어감
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i])
                stack.pop();
            // 현재 건물보다 큰 건물 더하기
            cnt[i] += stack.size();

            if(!stack.isEmpty()){
                int gap = Math.abs(stack.peek()-i); // 현재 건물과 기준 건물의 거리 차이
                if(gap<answer[i][1]){   // 거리가 작은 경우 갱신
                    answer[i][0] = stack.peek();    // 기준 건물
                    answer[i][1] = gap; // 차이 값
                }
                // 만약 차이가 같은 경우와 건물 번호가 작은 경우 갱신
                else if(gap == answer[i][1] && stack.peek() < answer[i][0]){
                    answer[i][0] = stack.peek();
                }
            }
            stack.push(i);
        }

        for(int i=1; i<=N; i++){
            if(cnt[i] == 0){
                System.out.print(0);
            }else{
                System.out.print(cnt[i] + " " + answer[i][0]);
            }
            System.out.println();
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int n = Integer.parseInt(br.readLine());
//        String input = br.readLine();
//        st = new StringTokenizer(input);
//        int[] towers = new int[n];
//        for (int i = 0; i < n; i++) {
//            int tower = Integer.parseInt(st.nextToken());
//            towers[i] = tower;
//        }
//        String[] answer = solution(n, towers);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            sb.append(answer[i] + "\n");
//        }
//        System.out.print(sb.toString());
//    }
//
//    static String[] solution(int n, int[] towers) {
//        String[] answer = new String[n];
//        int[] leftTop = new int[n];
//        int[] rightTop = new int[n];
//        int[] leftDp = new int[n];
//        leftDp[0] = 0;
//        for (int i = 1; i < n; i++) {
//            int cur = towers[i];
//            for (int j = i; j >= 0; j--) {
//                if (cur < towers[j]) {
//                    leftTop[i] = j;
//                    leftDp[i] = leftDp[j] + 1;
//                    break;
//                }
//            }
//        }
//        int[] rightDp = new int[n];
//        rightDp[n - 1] = 0;
//        for (int i = n - 2; i >= 0; i--) {
//            int cur = towers[i];
//            for (int j = i; j < n; j++) {
//                if (cur < towers[j]) {
//                    rightTop[i] = j;
//                    rightDp[i] = rightDp[j] + 1;
//                    break;
//                }
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            int sum = leftDp[i] + rightDp[i];
//            answer[i] = sum + "";
//            int leftD = i - leftTop[i];
//            int rightD = rightTop[i] - i;
//            if (sum != 0) {
//                if (rightDp[i] == 0 || leftD <= rightD && leftDp[i] != 0) {
//                    answer[i] += " " + (leftTop[i] + 1);
//                } else {
//                    answer[i] += " " + (rightTop[i] + 1);
//                }
//            }
//        }
//        return answer;
//    }
//}
