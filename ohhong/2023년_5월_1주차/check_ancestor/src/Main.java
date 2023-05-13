import java.io.*;
import java.util.*;
public class Main {
    static int pre_index, post_index;
    static Map<Integer, Integer> postorder = new HashMap<>();
    static boolean[] visited;
    static Map<Integer, Integer> preorder = new HashMap<>();
    static List<List<Integer>> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        pre_index = 0;
        post_index = 0;

        list_init(n);

        for(int i=1;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int P_node = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());
            arr.get(P_node).add(node);
        }

        dfs(1);

        int ans = 0;
        for(int i=0;i<q;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            ans += query_ancestor(u, v);
        }
        System.out.println(ans);
    }

    public static void list_init(int n){
        for(int i=0;i<=n;i++){
            arr.add(new ArrayList<Integer>());
        }
    }

    public static void dfs(int node){
        visited[node] = true;
        preorder.put(node, pre_index);
        pre_index++;

        for(int i=0;i<arr.get(node).size();i++){
            int next = arr.get(node).get(i);
            if(!visited[next]){
                dfs(next);
            }
        }
        postorder.put(node, post_index);
        post_index++;
    }

    public static int query_ancestor(int u, int v){
        boolean pre = false;
        boolean post = false;
        if(preorder.get(u) <= preorder.get(v)){
            pre = true;
        }
        if(postorder.get(u) >= postorder.get(v)){
            post = true;
        }

        if(post && pre){
            return 1;
        }
        return 0;
    }
}