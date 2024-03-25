import java.util.Scanner;

public class Bai5a {
    public static int[] insert(int[] a, int[] b, int p) {
        int n = a.length;
        int m = b.length;
        int[] result = new int[n + m];
        for (int i = 0; i < p; i++) {
            result[i] = a[i];
        }
        for (int i = 0; i < m; i++) {
            result[p + i] = b[i];
        }
        for (int i = p; i < n; i++) {
            result[i + m] = a[i];
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];

        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        int p = sc.nextInt();
        int[] result = insert(a, b, p);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
