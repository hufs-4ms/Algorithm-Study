import java.io.*;
import java.util.*;
public class Main{
    static int n;
    static List<List<Integer>> arr;
    static int q;
    static int[] depth;
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        init();

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        depth = new int[n+1];
        parent = new int[n+1];

        dfs(1, 1);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<q;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = query(a, depth[a], b, depth[b]);
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
    public static void init(){
        for(int i=0;i<n+1;i++){
            arr.add(new ArrayList<>());
        }
    }

    public static void dfs(int node, int cnt){
        depth[node] = cnt++;
        for(Integer next : arr.get(node)){
            if(depth[next] == 0){
                dfs(next, cnt);
                parent[next] = node;
            }
        }
    }

    public static int query(int node1, int node1_depth, int node2, int node2_depth){
        if(node1_depth> node2_depth){
            while(node1_depth != node2_depth){
                node1_depth--;
                node1 = parent[node1];
            }
        }else if(node1_depth < node2_depth){
            while(node1_depth != node2_depth){
                node2_depth--;
                node2 = parent[node2];
            }
        }

        while(node1 != node2){
            node1 = parent[node1];
            node2 = parent[node2];
        }
        return node1;
    }
}