import java.util.Scanner;

public class Main {
    static String[] fb = {
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW"
    };
    static String[] fw = {
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB"
    };
    static String[] chess;
    public static int fb_count(int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chess[x + i].charAt(y + j) != fb[i].charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int fw_count(int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chess[x + i].charAt(y + j) != fw[i].charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] size = new int[2];
        int min_value = 64;
        size[0] = sc.nextInt();
        size[1] = sc.nextInt();
        chess = new String[size[0]];
        for (int i = 0; i < size[0]; i++) {
            chess[i] = sc.next();
        }
        for (int i = 0; i + 8 <= size[0]; i++) {
            for (int j = 0; j + 8 <= size[1]; j++) {
                int temp = Math.min(fb_count(i, j), fw_count(i, j));
                if (temp < min_value) {
                    min_value = temp;
                }
            }
        }
        System.out.println(min_value);
    }

}