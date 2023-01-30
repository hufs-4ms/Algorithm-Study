import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        HashMap<String, Integer> arr = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int t = Integer.parseInt(bf.readLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(bf.readLine());
            arr.clear();
            for(int j=0;j<n;j++){
                st = new StringTokenizer(bf.readLine());
                String str1 = st.nextToken();
                String str2 = st.nextToken();
                if(!arr.containsKey(str2)){
                    arr.put(str2, 1);
                }else{
                    arr.put(str2, arr.get(str2)+1);
                }
            }
            int total=1;
            for (String key : arr.keySet()) {
                int value = arr.get(key);
                total *= value+1;
            }
            list.add(total-1);
        }
        for(Integer i : list){
            bw.write(i + "\n");
        }
        bf.close();
        bw.flush();
        bw.close();
    }
}