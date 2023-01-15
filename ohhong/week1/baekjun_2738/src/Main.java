import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int sum;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum = sc.nextInt();
                arr[i][j] = sum;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum = sc.nextInt();
                arr[i][j] += sum;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}