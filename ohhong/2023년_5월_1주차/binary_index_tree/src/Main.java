    import java.io.*;
    import java.util.*;
    public class Main {
        static List<List<Integer>> arr = new ArrayList<>();
        static int pre_index;

        static boolean[] visited;
        static int[] tree;
        static int[] cost;
        static Map<Integer, Integer> node_cnt = new HashMap<>();
        static Map<Integer, Integer> preorder = new HashMap<>();
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


            tree = new int[n*4+1];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=1;i<=n;i++){
                cost[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1;i<n;i++){
                st = new StringTokenizer(br.readLine(), " ");
                int P_node = Integer.parseInt(st.nextToken());
                int node = Integer.parseInt(st.nextToken());
                arr.get(P_node).add(node);
            }

            dfs(1);

            StringBuilder sb = new StringBuilder();

            System.out.println();


            for(int i=0;i<q;i++){
                st = new StringTokenizer(br.readLine(), " ");
                String str = st.nextToken();
                if(str.equals("subtree")){
                    int v = Integer.parseInt(st.nextToken());
                    int node_index = preorder.get(v);
                    int node_size = node_cnt.get(v);
                    int result = query(node_index+node_size-1) - query(node_index-1);
                    sb.append(result).append("\n");
                }else if(str.equals("update")){
                    int v = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    update(preorder.get(v), b);
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