import java.util.Scanner;

public class Bai10a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += a[i][i];
            sum2 += a[i][n - i - 1];
        }
        System.out.println(sum1 + " " + sum2);
    }
}
