import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[101][101];
        int total = 0;
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            for(int j=x;j<x+10;j++){
                if(j>100){
                    continue;
                }
                for(int k=y;k<y+10;k++){
                    if(k>100){
                        continue;
                    }
                    if(arr[j][k] != 1) {
                        arr[j][k] = 1;
                        total++;
                    }
                }
            }
        }
        System.out.print(total);
    }
}