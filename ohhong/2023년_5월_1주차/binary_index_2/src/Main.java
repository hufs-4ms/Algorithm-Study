import java.io.*;
import java.util.*;
public class Main {
    static List<List<Integer>> arr = new ArrayList<>();  // 트리를 저장하는 2차원 리스트
    static int[] dif;  // 노드값이 변경될 때 이전 노드값과의 차이
    static int[] path_sum;  // 루트 노드부터 해당 노드까지의 가중치 합을 저장하는 배열
    static boolean[] visited;  // 방문한 노드를 체크하는 배열
    static int[] tree;  // 세그먼트 트릴르 저장하는 배열
    static int[] cost;  // 노드의 가중치를 저장하는 배열
    static int[] preorder;  // preorder를 저장하는 배열
    static int pre_index;  // preorder의 위치를 저장하는 변수
    static Map<Integer, Integer> preIndex = new HashMap<>();  // 각 노드의 index값을 저장하는 HashMap
    static Map<Integer, Integer> node_cnt = new HashMap<>();  // 각 노드의 자식 노드의 개수를 저장하는 HashMap
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");  // n과 q를 받고, 각 배열과 맵 등의 변수를 초기화
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        cost = new int[n];
        list_init(n);  // 시간복잡도 O(n)
        dif = new int[n];
        path_sum = new int[n];
        visited = new boolean[n];
        tree = new int[n*4];
        preorder = new int[n];
        pre_index = 0;

        st = new StringTokenizer(br.readLine(), " ");  // 가중치 값을 입력
        for(int i=0;i<n;i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<n;i++){  // n-1개의 간선 정보를 입력받고, 부모 노드에 자식 노드를 연결하는 과정을 거침
            st = new StringTokenizer(br.readLine(), " ");
            int P_node = Integer.parseInt(st.nextToken())-1;
            int node = Integer.parseInt(st.nextToken())-1;
            arr.get(P_node).add(node);
        }

        dfs(0, 0);  // dfs를 이용하여 node_cnt와 path_sum, preorder를 구한는데 걸리는 시간복잡도O(n)

        dif[0] = path_sum[0];  // path_sum을 이요하여 dif를 구하는데 걸리는 시간복잡도 O(n)
        for(int i=1;i<n;i++){
            dif[i] = path_sum[i] - path_sum[i-1];
        }

        for(int i=1;i<=n;i++){  // dif값을 tree 배열에 저장하는데 걸리는 시간복잡도 O(n)
            query_update(i, dif[i-1]);
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<q;i++){  // q개의 질의를 받고 질의에 맞게 수행
            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            if(str.equals("sum")){  // sum을 입력받을시 해당 노드와 루트 노드까지의 경로 합을 구함
                int v = Integer.parseInt(st.nextToken());
                int result = query_sum(preIndex.get(v));  // dif 배열에서 해당 노드의 index값까지의 구간합을 구한는데 걸리는 시간복자도O(log n)
                sb.append(result).append("\n");
            }else if(str.equals("update")){  // update를 입력받을 시 해당 노드의 cost값을 변경
                int v = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int index = preIndex.get(v);
                int size = node_cnt.get(v-1);
                query_update(index, b);  // 해당 노드의 index부터 해당 노드의 자식 노드의 크기를 더한 index값 까지의 구간을 b를 더하는데 걸리는 시간복잡도O(log n)
                query_update(index+size, b*-1);
            }
        }

        System.out.println(sb);
    }
    public static void list_init(int n){
        for(int i=0;i<=n;i++){
            arr.add(new ArrayList<Integer>());
        }
    }

    public static int dfs(int node, int parent_cost){
        int size = 1;
        visited[node] = true;
        preorder[pre_index] = node;
        preIndex.put(node+1, pre_index+1);
        path_sum[pre_index] = cost[node] + parent_cost;
        int parent = path_sum[pre_index];
        pre_index++;
        for(Integer next : arr.get(node)){
            if(!visited[next]){
                size += dfs(next, parent);
            }
        }
        node_cnt.put(node, size);
        return size;
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

// 따라서 시간복잡도는 O(n*log n)이다.