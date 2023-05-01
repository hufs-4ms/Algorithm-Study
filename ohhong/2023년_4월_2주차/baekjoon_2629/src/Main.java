import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        int t = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] weight = new int[t];
        for(int i=0;i<t;i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(weight);
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] test = new int[n];
        for(int i=0;i<n;i++){
            test[i] = Integer.parseInt(st.nextToken());
        }

    }
}