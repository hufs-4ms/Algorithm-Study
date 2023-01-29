import java.util.*;
public class Main {
    public static void main(String[] args) {
        Vector<Class> class_time = new Vector<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            Class cla = new Class(start, end);
            class_time.add(cla);
        }
        Collections.sort(class_time);
        pq.add(class_time.get(0).end);
        for (int i = 1; i < n; i++) {
            if (pq.peek() <= class_time.get(i).start) {
                pq.poll();
            }
            pq.offer(class_time.get(i).end);
        }
        System.out.print(pq.size());
        sc.close();
    }
}

class Class implements Comparable<Class> {

    int start;
    int end;

    public Class(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int start){
        this.start = start;
    }

    public int getEnd() {
        return this.end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public int compareTo(Class c){
        if(this.start > c.getStart()){
            return 1;
        }else if(this.start < c.getStart()){
            return -1;
        }else if(this.start == c.getStart()){
            if(this.end > c.getEnd()){
                return 1;
            }else if(this.end < c.getEnd()){
                return -1;
            }
        }
        return 0;
    }
}