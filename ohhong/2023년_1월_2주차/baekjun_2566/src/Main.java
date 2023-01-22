import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[9][9];
        int max=0, x=0, y=0;
        int sum;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sum = sc.nextInt();
                if(max<sum){
                    max = sum;
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(max);
        System.out.print((x+1) + " " + (y+1));
    }
}