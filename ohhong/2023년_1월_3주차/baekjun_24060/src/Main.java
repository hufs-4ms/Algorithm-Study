import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;
public class Main {
    public static int[] tmp = new int[500001];
    public static ArrayList<Integer> count = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        merge_sort(a,0, n-1);
        try{
            System.out.print(count.get(k-1));
        }catch(Exception e){
            System.out.print(-1);
        }
        sc.close();
    }

    static void merge_sort(int[] a, int start, int end){
        if(start<end){
            int mid = (start+end)/2;
            merge_sort(a, start, mid);
            merge_sort(a, mid+1, end);
            merge(a, start, mid, end);
        }
    }

    static void merge(int[] a, int start, int mid, int end){
        int i = start;
        int j = mid+1;
        int t = 1;
        while(i <= mid && j <= end){
            if(a[i] <= a[j]){
                tmp[t] = a[i];
                i++;
            }else{
                tmp[t] = a[j];
                j++;
            }
            t++;
        }
        while(i<=mid){
            tmp[t] = a[i];
            i++;
            t++;
        }
        while(j<=end){
            tmp[t] = a[j];
            j++;
            t++;
        }
        i = start;
        t = 1;
        while(i<=end){
            a[i] = tmp[t];
            count.add(tmp[t]);
            i++;
            t++;
        }
    }
}