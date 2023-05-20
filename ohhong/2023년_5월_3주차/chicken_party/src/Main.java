import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());  // a 치킨을 먹는 시간
        int b = Integer.parseInt(st.nextToken());  // b 치킨을 먹는 시간
        int t = Integer.parseInt(st.nextToken());  // 시간 t

        int min_sum = Math.min(a, b);  // a와 b 중에 치킨을 먹는 시간이 큰 것과 작은 것을 구별
        int max_sum = Math.max(a, b);
        int result=0;  // 결과 값 초기화
        boolean check = false;  // 시간 t에 맞아 떨어지는 지 확인하기 위한 변수
        int rest = Integer.MAX_VALUE;  // 시간 t에 맞아 떨어지지 않았을 때 최대한 오래 치킨을 먹고 남은 시간(맥주)

        double n = Math.ceil((double)t/(double)min_sum);  // 시간 t 동안 최대한 먹을 수 있는 치킨의 개수

        for(int i=(int)n;i>=0;i--){  // n을 1개씩 줄여가면서 a와 b의 조합을 만들어 비교한다.
            int num = min_sum*i;  // 치킨을 먹는 시간
            if((t-num)%max_sum == 0){  // 남은 시간 다른 치킨을 먹는 시간이 나누어 떨어지면 a와 b의 치킨의 최대 개수가 된다.
                check = true;
                result = i+(t-num)/max_sum;
                break;
            }else if(t-num > 0){  // 남는 시간이 나누어 떨어지지 않는다면 남은 시간을 최대한 적게 만들어 결과를 저장
                int sum = (t-num)%max_sum;
                if(sum < rest){
                    result = i+(t-num)/max_sum;
                    rest = sum;
                }
            }
        }
        if(check){  // 나누어 떨어졌을 때의 a와 b의 치킨의 개수를 출력
            System.out.print(result);
        }else{  // 나누어 떨어지지 않았을 때 a와 b의 치킨의 개수와 맥주를 마시는 시간(남은 시간)을 출력
            System.out.print(result + " " + rest);
        }
    }
}

// n은 t/min_sum의 올린 값이 이 n을 반복하면서 치킨 a와 b의 조합을 계산하고 수행한다. 그러므로 시간복잡도는 O(n)이다.