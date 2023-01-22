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
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String str = st.nextToken();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<=str.length();j++){
                set.add(str.substring(i,j));
            }
        }
        bw.write(set.size()+"\n");
        bf.close();
        bw.flush();
        bw.close();
    }
}