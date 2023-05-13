import java.io.*;
import java.util.*;
public class Main {
    static List<List<Integer>> arr = new ArrayList<>();
    static int pre_index;
    static int[] dif;
    static int[] path_sum;
    static boolean[] visited;
    static int[] tree;
    static int[] cost;
    static Map<Integer, Integer> preorder;
    static Map<Integer, Integer> path;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());


        cost = new int[n+1];
        visited = new boolean[n+1];
        list_init(n);
        pre_index = 1;
        path_sum = new int[n+1];
        path = new HashMap<>();
        tree = new int[n*4+1];
        preorder = new HashMap<>();
        dif = new int[n+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1;i<=n;i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        path.put(1, cost[1]);

        for(int i=1;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int P_node = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());
            arr.get(P_node).add(node);
        }

        dfs(1);

        for(int i=1;i<=n;i++){
            path_sum[preorder.get(i)] = path.get(i);
        }

        dif[1] = path_sum[preorder.get(1)];
        query_update(1, dif[1]);
        for(int i=2;i<=n;i++){
            dif[i] = path_sum[i] - path_sum[i-1];
            query_update(i, dif[i]);
        }

//        System.out.println("preorder : " + preorder.toString());
//        System.out.print("path_sum : ");
//        for(int i=1;i<=n;i++){
//            System.out.print(path_sum[i] + " ");
//        }
//        System.out.println();
//        for(int i=1;i<=n;i++){
//            System.out.print(dif[i] + " ");
//        }
//        System.out.println();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<q;i++){
            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            if(str.equals("sum")){
                int v = Integer.parseInt(st.nextToken());
                int result = query_sum(preorder.get(v));
                sb.append(result).append("\n");
            }else if(str.equals("update")){
                int v = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                query_update(preorder.get(v), b);
            }
        }
        System.out.println(sb);
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
        int sum = path.get(node);
        for(Integer next : arr.get(node)){
            if(!visited[next]){
                path.put(next, cost[next]+sum);
                dfs(next);
            }
        }
    }
    public static void query_update(int index, int dif){
        index++;
        while(index < tree.length){
            tree[index] += dif;
            index += (index & -index);
        }
    }
    public static int query_sum(int index){
        index++;
        int sum = 0;
        while(index > 0){
            sum += tree[index];
            index -= (index & -index);
        }
        return sum;
    }
}