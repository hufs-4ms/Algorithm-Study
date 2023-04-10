import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] a = new int[st.countTokens()];  // 입력받을 정수 배열
        int n=0;
        while(st.hasMoreTokens()){
            a[n]=Integer.parseInt(st.nextToken());  // 정수 배열 a에 입력값을 넣는다.
            n++;
        }
        wiggle_sort(a);  // a 배열에 대해 wiggle_sort를 수행한다.
        if(check(a)){  // wiggle_sort를 수행한 배열이 조건에 맞는지 확인한다.
            System.out.print("True");
        }else{
            System.out.print("False");
        }
        br.close();  // BufferedReader를 닫아준다.
    }

    public static void wiggle_sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i += 2) {
            if (arr[i] > arr[i + 1]) {  // i번째 수가 i+1번째 수보다 크면
                swap(arr, i, i+1);  // 두 수를 교환한다.
            }
        }
        for (int i = 1; i < arr.length - 1; i += 2) {
            if (arr[i] < arr[i + 1]) {  // i번째 수가 i+1번째 수보다 작으면
                swap(arr, i, i+1);  // 두 수를 교환한다.
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];  // i번째 수를 tmp에 저장
        arr[i] = arr[j];  // i번째 수를 j번째 수로 바꾼다.
        arr[j] = tmp;  // j번째 수를 tmp로 바꾼다.
    }

    public static boolean check(int[] arr){
        if(arr[0] > arr[1]){  // 첫 번째 수가 두 번째 수보다 크면
            return false;  // false를 반환한다.
        }
        for(int i=1;i<arr.length;i++){  // 배열의 길이만큼 반복한다.
            if(i%2==1 && arr[i]<arr[i-1]){  // i가 홀수이고 i번째 수가 i-1번째 수보다 작으면
                return false;  // false를 반환한다.
            }else if(i%2==0 && arr[i]>arr[i-1]){  // i가 짝수이고 i번째 수가 i-1번째 수보다 크면
                return false;  // false를 반환한다.
            }
        }
        return true;  // 조건에 모두 부합하면 true를 반환한다.
    }
}

// 시간 복잡도: wiggle_sort는 O(n)이고, check는 O(n)이므로 전체 알고리즘의 시간 복잡도는 O(n)이다.