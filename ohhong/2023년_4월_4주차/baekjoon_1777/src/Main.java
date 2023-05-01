import java.io.*;
import java.util.*;
public class Main {
    static int[] arr;
    static int[] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];
        tree = new int[getTreeSize(n)];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] a = new int[n];
        for(int i=n-1;i>=0;i--){
            int index = n-1 - arr[i];
            int prefix1 = prefix_sum(index);
            int sum = n-1-i-prefix1;
            while(sum != 0){
                index -= sum;
                int prefix2 = prefix_sum(index);
                sum = prefix1 -prefix2;
                prefix1 = prefix2;
            }
            a[index] = i+1;
            update(index+1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(a[i]).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
    public static int getTreeSize(int n) {
        return (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2))) + 1;
    }
    public static void update(int index){
        index++;
        while(index < tree.length){
            tree[index] += 1;
            index += (index & -index);
        }
    }
    public static int prefix_sum(int index){
        index++;
        int sum = 0;
        while(index > 0){
            sum += tree[index];
            index-=(index & -index);
        }
        return sum;
    }
}