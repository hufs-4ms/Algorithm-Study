import java.io.*;
import java.util.*;
public class Main {
    static int pre_index, post_index;  // preorder와 postorder 리스트의 index를 저장할 변수
    static Map<Integer, Integer> postorder = new HashMap<>();  // postorder를 저장할 hashMap
    static boolean[] visited;  // 방문한 노드를 체크하는 배열
    static Map<Integer, Integer> preorder = new HashMap<>();  // preorder를 저장할 hashMap
    static List<List<Integer>> arr = new ArrayList<>();  // 트리를 저장하는 2차원 리스트
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());  // n과 q를 받고, 각 배열과 맵 등의 변수를 초기화
        int q = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        pre_index = 0;
        post_index = 0;

        list_init(n);  // list를 초기화 하는데 걸리는 시간복잡도는 O(n)

        for(int i=1;i<n;i++){  // n-1개의 간선 정보를 입력받고, 부모 노드에 자식 노드를 연결하는 과정을 거침
            st = new StringTokenizer(br.readLine(), " ");
            int P_node = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());
            arr.get(P_node).add(node);
        }

        dfs(1);  // dfs로 preorder와 postorder를 구하는데 시간복잡도 O(n)

        int ans = 0;
        for(int i=0;i<q;i++){  // q개의 질의를 받고 u와 v의 관계를 추정하는데 시간복잡도 O(q)
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

// 따라서 시간복잡도는 O(n+q)가 된다.