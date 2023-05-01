import java.io.*;
import java.util.*;

public class Main {
    static int[] tree;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] s = new int[n];
        int[] l = new int[n];
        arr = new int[n];
        tree = new int[4000004];
        List<Tuple> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            Tuple tuple = new Tuple(num, 0);
            list.add(tuple);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            Tuple tuple = new Tuple(list.get(i).p, Integer.parseInt(st.nextToken()));
            list.set(i, tuple);
        }

        list.sort(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                if (o1.p == o2.p) {
                    return o2.q - o1.q;
                }
                return o1.p - o2.p;
            }
        });

        for(int i=0;i<n;i++){
            arr[i] = list.get(i).q;
        }

        int sum;

        for(int i=0;i<n;i++){
            sum = query(arr[i]-1);
            s[i] = sum;
            update(arr[i]);
        }

        Arrays.fill(tree, 0);

        for(int i=n-1;i>=0;i--){
            sum = (n-i-1) - query(arr[i]);
            l[i] = sum;
            update(arr[i]);
        }


        int result = 0;

        for(int i=1;i<n-1;i++){
            result += s[i]*l[i];
        }
        System.out.println(result);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(s));
//        System.out.println(Arrays.toString(l));
        br.close();
    }
    public static int getTreeSize(int n) {  // Tree 사이즈를 계산하여 저장
        return (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2))) + 1;
    }
    public static void update(int index){
        index++;
        while(index < tree.length){
            tree[index] += 1;
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

class Tuple{
    int p;
    int q;
    public Tuple(int p, int q){
        this.p = p;
        this.q = q;
    }
}

// p 를 기준으로 오름차순으로 정렬한다.
// p 를 정렬할때 바뀌는 순서에 맞춰서 q도 정렬해준다
// p의 리스트에서 i번 째 원소는 0보다 같거나 크고 i-1 범위에서 p[i]보다 작은 수는 i개가 있다.
// 마찬가지로 q에서 i번 째 원소는 0보다 같거나 크고 i-1 범위에서 q[i]보다 작은 수를 구한 다음 비교하여 유사성을 찾는다.


//bit를 두번사용한다
//유사 페어를 먼저 찾고 유사 트리플을 구한다