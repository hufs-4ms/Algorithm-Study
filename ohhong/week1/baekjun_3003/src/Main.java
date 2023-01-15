import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum;
        for(int i=0;i<6;i++){
            sum = sc.nextInt();
            if(i<=1){
                System.out.print((1-sum)+" ");
            }else if(i<=4){
                System.out.print((2-sum)+" ");
            }else{
                System.out.print(8-sum);
            }
        }
    }
}