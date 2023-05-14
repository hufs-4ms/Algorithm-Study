    import java.io.*;
    import java.util.*;
    public class Main {
        static List<List<Integer>> arr = new ArrayList<>();  // 트리를 저장하는 2차원 리스트
        static int pre_index;  // preorder 리스트의 index를 저장할 변수

        static boolean[] visited;  // 방문한 노드를 체크하는 배열
        static int[] tree;  // BIT 트리를 저장하는 배열
        static int[] cost;  // 노드의 가중치를 저장하는 배열
        static Map<Integer, Integer> node_cnt = new HashMap<>();  // node의 자식의 수를 저장하는 HashMap
        static Map<Integer, Integer> preorder = new HashMap<>();  // 노드의 index값을 저장하는 HashMap
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            st = new StringTokenizer(br.readLine(), " ");  // n과 q를 받고, 각 배열과 맵 등의 변소를 초기화
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());


            cost = new int[n+1];
            visited = new boolean[n+1];
            list_init(n);  // 시간복잡도 O(n)
            pre_index = 1;


            tree = new int[n*4+1];

            st = new StringTokenizer(br.readLine(), " ");  // 각 노드의 가중치를 저장
            for(int i=1;i<=n;i++){
                cost[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1;i<n;i++){  // n-1개의 간선 정보를 입력받고, 부모 노드에 자식 노드를 연결하는 과정을 거침
                st = new StringTokenizer(br.readLine(), " ");
                int P_node = Integer.parseInt(st.nextToken());
                int node = Integer.parseInt(st.nextToken());
                arr.get(P_node).add(node);
            }

            dfs(1); // dfs를 이용하여 preorder와 node_cnt를 구하는데 시간복잡도 O(n)
            // 또한 dfs를 사용하는 과정에서 BIT를 구성하는 tree를 update

            StringBuilder sb = new StringBuilder();

            System.out.println();


            for(int i=0;i<q;i++){  // q개의 질의를 받고 각 질의에 맞게 수행
                st = new StringTokenizer(br.readLine(), " ");
                String str = st.nextToken();
                if(str.equals("subtree")){  // subtree를 입력받을시 부트리에 포함된 노드의 비용을 구함
                    int v = Integer.parseInt(st.nextToken());
                    int node_index = preorder.get(v);
                    int node_size = node_cnt.get(v);
                    int result = query(node_index+node_size-1) - query(node_index-1);  // preorder를 이용하여 해당 노드의 Index값 부터 노드의 자식 노드의 개수 만큼을 더한 index 사이의 구간 합을 출력하는데 시간복잡도 O(log n)
                    sb.append(result).append("\n");
                }else if(str.equals("update")){  // update를 입력받을시 해당 노드의 cost를 d만큼 더함
                    int v = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    update(preorder.get(v), b);  // 수정된 값을 updat하는데 걸리는 시간복잡도 O(log n)
                }
            }
            System.out.print(sb);
        }
        public static void list_init(int n){
            for(int i=0;i<=n;i++){
                arr.add(new ArrayList<Integer>());
            }
        }

        public static int dfs(int node){
            int size = 1;
            visited[node] = true;
            preorder.put(node, pre_index);
            update(pre_index, cost[node]);
            pre_index++;

            for(int i=0;i<arr.get(node).size();i++){
                int next = arr.get(node).get(i);
                if(!visited[next]){
                    size += dfs(next);
                }
            }
            node_cnt.put(node, size);
            return size;
        }
        public static void update(int index, int dif){
            index++;
            while(index < tree.length){
                tree[index] += dif;
                index += (index & -index);
            }
        }
        public static int query(int index){
            index++;
            int sum = 0;
            while(index > 0){
                sum += tree[index];
                index -= (index & -index);
            }
            return sum;
        }
    }

    // 따라서 시간복잡도는 T(n + q*log n)임으로 O(n*log n)이다.