import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Integer> c = new ArrayList<>();
        int n, count, x, y, r, x1, y1, x2, y2;
        for(int i=0;i<t;i++){
            count = 0;
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            n = sc.nextInt();
            for(int j=0;j<n;j++){
                x = sc.nextInt();
                y = sc.nextInt();
                r = sc.nextInt();
                double d1 = Math.sqrt(Math.pow(x1-x,2)+Math.pow(y1-y,2));
                double d2 = Math.sqrt(Math.pow(x2-x,2)+Math.pow(y2-y,2));
                if((d1>r&&d2<r)||(d1<r&&d2>r)){
                    count++;
                }
            }
            c.add(count);
        }
        for(Integer i:c){
            System.out.println(i);
        }
        sc.close();
    }
}