import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());  // 좀비 수
        int l = Integer.parseInt(st.nextToken());  // 길의 길이
        int k = Integer.parseInt(st.nextToken());  // 몇 번째 좀비가 떨어질지

        List<zom> zombie = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int id = Integer.parseInt(st.nextToken());
            int direction = (id < 0) ? -1 : 1;
            zombie.add(new zom(id, position, direction));
        }
        int count = 0;
        while(count < k){

            // 좀비 이동
            for(int i=0;i<zombie.size();i++){
                if(i+1 <zombie.size() && zombie.get(i).position+1 == zombie.get(i+1).position && zombie.get(i).direction > 0 && zombie.get(i+1).direction < 0){
                    zombie.get(i).direction *= -1;
                    zombie.get(i+1).direction *= -1;
                    i++;
                }else{
                    zombie.get(i).position += zombie.get(i).direction;
                }
            }

            // 충돌 체크
            int sum = Integer.MIN_VALUE;
            for (int i = 0;i<zombie.size();i++) {
                int pos = zombie.get(i).position;
                if(pos == sum){
                    zombie.get(i).direction *= -1;
                    zombie.get(i-1).direction *= -1;
                }else{
                    sum = pos;
                }
            }

            // 길 끝에 도착한 좀비 처리
            List<Integer> dead  = new ArrayList<>();
            for(int i=zombie.size()-1;i>=0;i--){
                int pos = zombie.get(i).position;
                if(pos < 0 || pos > l){
                    dead.add(zombie.get(i).id);
                    zombie.remove(i);
                }
            }

            // 몇 번째 좀비가 떨어지는지 확인
            if(dead.size()>1){
                count++;
                int num;
                if(dead.get(0) < dead.get(1)){
                    num = 0;
                }else{
                    num = 1;
                }
                if(count == k){
                    System.out.print(dead.get(num));
                }
                dead.remove(num);
            }

            if(!dead.isEmpty()){
                count++;
                if(count == k){
                    System.out.print(dead.get(0));
                }
                dead.remove(0);
            }

        }
    }

}

class zom{
    int id;
    int position;
    int direction;
    public zom(int id, int position, int direction) {
        this.id = id;
        this.position = position;
        this.direction = direction;
    }
}

// 이 코드는 시간 k만큼 좀비 리스트 n을 반복하고 있으므로 시간복잡도는 O(n*k)가 된다