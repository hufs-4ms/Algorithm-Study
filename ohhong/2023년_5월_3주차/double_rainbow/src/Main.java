import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());  // 점의 개수
        int k = Integer.parseInt(st.nextToken());  // 색의 개수

        int[] arr = new int[n];  // 점에 대한 색에 대한 정보를 가지는 배열
        int[] check_color = new int[k];  // 전체 각 색에 대한 점의 개수(p에 대한 정보)
        int[] p_color = new int[k];  // 구간 각 색에 대한 점의 개수(p'에 대한 정보)

        for (int i = 0; i < n; i++) {  // 점에 대한 색에 대한 정보를 받으면서 전체 각 색에 대한 점의 개수를 저장
            arr[i] = Integer.parseInt(br.readLine()) - 1;
            check_color[arr[i]]++;  // p에 대한 정보 갱신
        }

        int result = Integer.MAX_VALUE;  // 최솟값을 저장하기 위해 제일 큰 수로 초기화

        int left = 0, right = 0, in_cnt=0, out_cnt=k;  // 슬라이딩 윈도우 알고리즘을 사용하기 위해 left, right를 초기화, p의 색의 개수 out_cnt와 p'의 색의 개수 in_cnt를 초기화
        while (right < n) {  // right 포인터가 배열을 한번 순회하면서 이동하여 최대 n번 반복
            int color = arr[right];  // 해당 색을 저장
            p_color[color]++;  // p'에 해당 색을 1개 증가
            if (p_color[color] == 1) {  // 없는 색을 받았을 경우 p'의 색의 개수를 1개 증가
                in_cnt++;
            }
            check_color[color]--;  // p에서는 p'에게 색이 넘어간 것이기 때문에 해당 색을 1개 감소
            if (check_color[color] == 0){  // p의 색이 다 사라지면 p의 색의 개수를 1개 감소
                out_cnt--;
            }

            if (in_cnt == k) {  // p'의 색의 개수가 k개에 도달하면 rainbow
                while (left <= right) {  // 최소 구간의 rainbow 를 구하기 위해 left 포인터를 right 포인터로 이동
                    if(out_cnt==k){  // p의 색의 개수가 k개이면 rainbow(double rainbow)
                        result = Math.min(result, right-left+1);  // 전의 값과 비교하여 더 작은 값을 저장
                    }
                    int currColor = arr[left];  // 해당 색을 저장
                    p_color[currColor]--;  // p'에 해당 색을 1개 감소
                    if (p_color[currColor] == 0){  // 해당 색이 없어질 경우 p'의 색의 개수를 1개 감소
                        in_cnt--;
                    }
                    check_color[currColor]++;  // p'에서 해당 색을 p에 가져옴으로 해당 색을 1개 증가
                    if (check_color[currColor] == 1){  // 없는 색을 받았을 경우 p의 색의 개수를 1개 증가
                        out_cnt++;
                    }
                    left++;  // left 포인터 증가
                    if (in_cnt!=k){  // rainbow 가 해제되면 left 포인터의 이동을 멈춤
                        break;
                    }
                }
            }

            right++;  // right 포인터 증가
        }

        if (result == Integer.MAX_VALUE) {  // double rainbow 가 만들어지지 않았을 경우 0을 출력
            result = 0;
        }
        System.out.println(result);  // 결과 출력
    }
}

// 입력 처리하는 부분에서 check_color[]를 갱신 시키는 과정에서 O(n)의 시간이 소요되고, 슬라이딩 윈도우 알고리즘에서는 right 포인터가 배열을 한번 순회하면서 n번 이동하고, left 포인터도 right 따라 이동하면서 n번 반복한다. 따라서, 시간복잡도는 O(n)이다.
