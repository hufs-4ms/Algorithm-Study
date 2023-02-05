import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());
        int sum, count=0;
        for(int i=0;i<a;i++){
            sum = Integer.parseInt(st.nextToken());
            set.add(sum);
        }
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<b;i++){
            sum = Integer.parseInt(st.nextToken());
            if(set.contains(sum)){
                arr.add(sum);
            }
        }
        int total = a+b-arr.size()*2;
        bw.write(total + "\n");
        bf.close();
        bw.flush();
        bw.close();
    }
}