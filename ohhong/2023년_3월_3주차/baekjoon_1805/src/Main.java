import java.io.*;

public class Main {
    static int[] parent, size;
    static int[][] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nmk = br.readLine().split(" ");
        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);

        int[] logs = new int[n];
        String[] logStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            logs[i] = Integer.parseInt(logStr[i]);
        }

        parent = new int[n];
        size = new int[n];
        distances = new int[n][n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            String[] uvw = br.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]) - 1;
            int v = Integer.parseInt(uvw[1]) - 1;
            int w = Integer.parseInt(uvw[2]);
            distances[u][v] = w;
            distances[v][u] = w;
        }

        for (int i = 0; i < k; i++) {
            int minIndex = -1;
            int minLog = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (logs[j] < minLog) {
                    minLog = logs[j];
                    minIndex = j;
                }
            }
            logs[minIndex] = Integer.MAX_VALUE;

            int[] nearest = new int[] {-1, -1};
            for (int j = 0; j < n; j++) {
                if (j != minIndex && parent[j] == j) {
                    if (nearest[0] == -1 || distances[j][minIndex] < distances[nearest[0]][nearest[1]]) {
                        nearest[0] = j;
                        nearest[1] = minIndex;
                    }
                }
            }

            if (nearest[0] != -1 && nearest[1] != -1) {
                union(nearest[0], nearest[1]);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                answer += find(i);
            }
        }

        System.out.println(answer);
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return size[x];
        } else {
            return size[x] = find(parent[x]);
        }
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
            size[x] += size[y];
        }
    }
}
