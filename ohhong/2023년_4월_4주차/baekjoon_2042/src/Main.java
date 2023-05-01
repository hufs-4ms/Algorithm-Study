import java.io.*;
import java.util.*;
public class Main{
    static int n;
    static long[] tree;
    static long[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n+1];
        int size  = n*4;
        tree = new long[size];

        for(int i=0;i<n;i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        init(1, 0, n-1);

        for(int i=0;i<m+k;i++){
            st = new StringTokenizer(br.readLine());
            long m1 = Long.parseLong(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            long m3 = Long.parseLong(st.nextToken());
            if(m1 == 1){
                m2 --;
                long dif = m3 - arr[m2];
                arr[m2] = m3;
                update(1, 0, n-1, m2, dif);
            }else if(m1 == 2){
                sb.append(sum(1, 0, n-1, m2-1, (int)m3-1)).append("\n");
            }
        }
        System.out.print(sb);
    }
    public static long init(int node, int start, int end){
        if(start == end){
            return tree[node] = arr[start];
        }else{
            return tree[node] = init(node*2, start, (start+end)/2) + init( node*2+1, (start+end)/2+1, end);
        }
    }
    public static void update(int node, int start, int end, int index, long dif){
        if(index < start || index > end){
            return;
        }
        tree[node] = tree[node] + dif;
        if(start != end){
            update(node*2, start, (start+end)/2, index, dif);
            update(node*2+1, (start+end)/2+1, end, index, dif);
        }
    }
    public static long sum(int node, int start, int end, int left, int right){
        if(left > end || right < start){
            return 0;
        }
        if(left <= start && end <= start){
            return tree[node];
        }
        return sum(node*2, start, (start+end)/2, left, right) + sum(node*2+1, (start+end)/2+1, end, left, right);
    }
}