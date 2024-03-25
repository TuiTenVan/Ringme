import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] A = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        int[][] B = new int[n][k];     
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                B[i][j] = sc.nextInt();
            }
        }
        int[][] C = new int[m][k]; 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                for (int t = 0; t < n; t++) {
                    C[i][j] += A[i][t] * B[t][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
