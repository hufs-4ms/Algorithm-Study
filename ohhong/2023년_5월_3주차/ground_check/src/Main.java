import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int max_value = 0;
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(j>1){
                    max_value = Math.max(max_value, arr[i][j] + arr[i][j-1] + arr[i][j-2]);
                }

            }
            list.add(max_value);
        }

        Collections.sort(list);

        int result = 0;

        if(n < k){
            result = -1;
        }else{
            for(int i=0;i<k;i++){
                result += list.get(n-1-i);
            }
        }
        System.out.print(result);
    }
}