import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int a, b, total=0;
        for(int i=0;i<n;i++){
            a=sc.nextInt();
            b=sc.nextInt();
            total += a*b;
        }
        if(total==x){
            System.out.print("Yes");
        }else{
            System.out.print("No");
        }
    }
}