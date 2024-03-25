import java.util.Arrays;
import java.util.Scanner;

public class Bai9a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int length = n * m;
        int[] b = new int[length];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[index++] = a[i][j]; 
            }
        }
        Arrays.sort(b);
        int curr = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(b[curr++] + " ");
            }
            System.out.println();
        }
    }
}
