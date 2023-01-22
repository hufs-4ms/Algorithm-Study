import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String str;
        ArrayList<String> save = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            str = br.readLine();
            set.add(str);
        }
        for(int i=0;i<m;i++){
            str = br.readLine();
            if(set.contains(str)){
                save.add(str);
            }
        }
        Collections.sort(save);
        bw.write(save.size()+"\n");
        for(String sum:save){
            bw.write(sum+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}