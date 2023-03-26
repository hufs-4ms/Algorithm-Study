import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫 번째 줄에서 n과 budget, a의 값을 입력받아 저장
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int budget = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        // 우선순위 큐를 사용하여 가장 작은 수 부터 꺼내며 값을 계산
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // 두 번째 줄에서 n개의 정수를 입력받아 배열 arr에 저장
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            priorityQueue.add(Integer.parseInt(st.nextToken()));
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int b = 0;
        for(int i=0;i<n;i++){
            // 배열 a의 원소를 2로 나눈 값을 b에 더함
            int sum = priorityQueue.poll();
            queue.add(sum);
            b += sum/2;
            // 할인 받을 수 있는 a개의 개수가 넘어가면 원래 가격으로 돌림
            if(i-a>=0){
                b += queue.poll()/2;
            }
            // b가 상한액을 초과하면 멈춤
            if(budget<b){
                break;
            }
            count++;
        }
        System.out.print(count);
        br.close();
    }
}

// 정렬을 사용한 후에 count를 찾기 위해 한번의 for문을 돌렸기 때문에 시간복잡도는 O(nloga)이다.
