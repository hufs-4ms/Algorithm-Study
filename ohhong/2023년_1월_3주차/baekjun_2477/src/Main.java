
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] d = new int[6];
        int[] l = new int[6];
        int x=0, y=0;
        for(int i=0;i<6;i++){
            d[i] = sc.nextInt();
            l[i] = sc.nextInt();
            if(d[i]==1||d[i]==2){
                if(x < l[i]){
                    x = l[i];
                }
            }else if(d[i]==3||d[i]==4){
                if(y < l[i]){
                    y = l[i];
                }
            }
        }
        int sum = 0, j;
        for(int i=0;i<6;i++){
            if(i+1>=6){
                j = 0;
            }else{
                j = i+1;
            }
            if((d[i]==1&&d[j]==3)||(d[i]==2&&d[j]==4)||(d[i]==3&&d[j]==2)||(d[i]==4&&d[j]==1)){
                sum = l[i]*l[j];
            }
        }
        int total = (x*y - sum)*k;
        System.out.print(total);
    }
}