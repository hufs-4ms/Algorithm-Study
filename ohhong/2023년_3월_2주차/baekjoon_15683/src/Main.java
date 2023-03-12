import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static ArrayList<Pair> cctv;
    public static int total, n, m;
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        cctv = new ArrayList<>();
        total = n*m;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0) {
                    if (arr[i][j] != 6) {
                        cctv.add(new Pair(i, j, arr[i][j]));
                    }else{
                        total--;
                    }
                }
            }
        }
        dfs(0, arr);
        System.out.print(min);
        br.close();
    }
    public static void dfs(int cnt, int[][] arr){
        if(cnt == cctv.size()){
            min = Math.min(min, zero_count(arr));
            return;
        }
        int value = cctv.get(cnt).getValue();
        int x = cctv.get(cnt).getX();
        int y = cctv.get(cnt).getY();
        int[][] tmp;
        if(value == 1){
            tmp = copyMap(arr);
            check_left(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyMap(arr);
            check_right(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyMap(arr);
            check_up(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyMap(arr);
            check_down(tmp, x, y);
            dfs(cnt+1, tmp);
        }else if(value == 2){
            tmp = copyMap(arr);
            check_left(tmp, x, y);
            check_right(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyMap(arr);
            check_up(tmp, x, y);
            check_down(tmp, x, y);
            dfs(cnt+1, tmp);
        }else if(value == 3){
            tmp = copyMap(arr);
            check_left(tmp, x, y);
            check_up(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyMap(arr);
            check_up(tmp, x, y);
            check_right(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyMap(arr);
            check_right(tmp, x, y);
            check_down(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyMap(arr);
            check_down(tmp, x, y);
            check_left(tmp, x, y);
            dfs(cnt+1, tmp);
        }else if(value == 4){
            tmp = copyMap(arr);
            check_right(tmp, x, y);
            check_up(tmp, x, y);
            check_down(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyMap(arr);
            check_left(tmp, x, y);
            check_up(tmp, x, y);
            check_down(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyMap(arr);
            check_left(tmp, x, y);
            check_right(tmp, x, y);
            check_down(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyMap(arr);
            check_left(tmp, x, y);
            check_right(tmp, x, y);
            check_up(tmp, x, y);
            dfs(cnt+1, tmp);
        }else if(value == 5){
            tmp = copyMap(arr);
            check_left(tmp, x, y);
            check_right(tmp, x, y);
            check_up(tmp, x, y);
            check_down(tmp, x, y);
            dfs(cnt+1, tmp);
        }
    }
    public static void check_left(int[][] tmp, int x, int y){
        for(int i=y-1;i>=0;i--){
            if(tmp[x][i] == 6){
                return;
            }
            if(tmp[x][i] != 0){
                continue;
            }
            tmp[x][i] = -1;
        }
    }
    public static void check_right(int[][] tmp, int x, int y){
        for(int i=y+1;i<m;i++){
            if(tmp[x][i] == 6){
                return;
            }
            if(tmp[x][i] != 0){
                continue;
            }
            tmp[x][i] = -1;
        }
    }
    public static void check_up(int[][] tmp, int x, int y){
        for(int i=x-1;i>=0;i--){
            if(tmp[i][y] == 6){
                return;
            }
            if(tmp[i][y] != 0){
                continue;
            }
            tmp[i][y] = -1;
        }
    }
    public static void check_down(int[][] tmp, int x, int y){
        for(int i=x+1;i<n;i++){
            if(tmp[i][y] == 6){
                return;
            }
            if(tmp[i][y] != 0){
                continue;
            }
            tmp[i][y] = -1;
        }
    }
    public static int[][] copyMap(int[][] map){
        int[][] temp = new int[n][m];
        for(int i=0;i<n;i++){
            if (m >= 0) System.arraycopy(map[i], 0, temp[i], 0, m);
        }
        return temp;
    }
    public static int zero_count(int[][] arr){
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static boolean isIn(int x, int y){
        return 0<=x && x<n && 0<=y && y<m;
    }
}

class Pair{
    Integer x;
    Integer y;
    Integer value;
    public Pair(Integer k, Integer v, Integer value){
        this.x = k;
        this.y = v;
        this.value = value;
    }
    public Integer getX(){
        return x;
    }
    public Integer getY(){
        return y;
    }
    public Integer getValue(){
        return value;
    }
}
