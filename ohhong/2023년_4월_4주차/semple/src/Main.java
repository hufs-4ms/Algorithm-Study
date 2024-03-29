import java.io.*;
import java.util.*;
public class Main {
    static List<List<Integer>> arr = new ArrayList<>();  // 트리를 저장하는 2차원 리스트
    static int[] depth;  // 방문한 노드를 체크하는 배열
    static int[] tree;  // 세그먼트 트릴르 저장하는 배열
    static List<Integer> tour = new ArrayList<>();
    static Map<Integer, Integer> node_index = new HashMap<>();
    static int node_i;
    static int[] depth_tour;
    static int[] euler_tour;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");  // n과 q를 받고, 각 배열과 맵 등의 변수를 초기화
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());


        list_init(n);  // 시간복잡도 O(n)
        depth = new int[n];
        node_i = 0;


        for(int i=1;i<n;i++){  // n-1개의 간선 정보를 입력받고, 부모 노드에 자식 노드를 연결하는 과정을 거침
            st = new StringTokenizer(br.readLine(), " ");
            int P_node = Integer.parseInt(st.nextToken())-1;
            int node = Integer.parseInt(st.nextToken())-1;
            arr.get(P_node).add(node);
        }

        dfs(0, 0);

        int tour_size = tour.size();
        depth_tour = new int[tour_size];
        euler_tour = new int[tour_size];
        tree = new int[tour_size*5];
        for(int i=0;i<tour.size();i++){
            depth_tour[i] = depth[tour.get(i)]+1;
            euler_tour[i] = tour.get(i)+1;
        }

        build(1,0,tour_size-1);


        StringBuilder sb = new StringBuilder();
        for(int i=0;i<q;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int l, r;
            if(node_index.get(u-1) < node_index.get(v-1)){
                l = node_index.get(u-1);
                r = node_index.get(v-1);
            }else{
                l = node_index.get(v-1);
                r = node_index.get(u-1);
            }
            int result = query(1, 0, tour_size-1, l, r);
            sb.append(euler_tour[result]).append("\n");
        }
        System.out.println(sb);
    }
    public static void list_init(int n){
        for(int i=0;i<=n;i++){
            arr.add(new ArrayList<Integer>());
        }
    }

    public static void dfs(int node, int cnt){
        depth[node] = cnt++;
        tour.add(node);
        if(!node_index.containsKey(node)){
            node_index.put(node, node_i);
        }
        node_i++;
        for(Integer next : arr.get(node)){
            if(depth[next]==0){
                dfs(next, cnt);
                tour.add(node);
                node_i++;
            }
        }
    }
    public static void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = start;
        } else {
            int mid = (start + end) / 2;
            build(2 * node + 1, start, mid);
            build(2 * node + 2, mid + 1, end);
            if (depth_tour[tree[2 * node + 1]] < depth_tour[tree[2 * node + 2]]) {
                tree[node] = tree[2 * node + 1];
            } else {
                tree[node] = tree[2 * node + 2];
            }
        }
    }
    public static int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return -1;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftMin = query(2 * node + 1, start, mid, l, r);
        int rightMin = query(2 * node + 2, mid + 1, end, l, r);
        if (leftMin == -1) {
            return rightMin;
        } else if (rightMin == -1) {
            return leftMin;
        } else {
            return depth_tour[leftMin] < depth_tour[rightMin] ? leftMin : rightMin;
        }
    }
}

// 따라서 시간복잡도는 O(n*log n)이다.