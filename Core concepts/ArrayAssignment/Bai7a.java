import java.util.Scanner;

public class Bai7a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int start = 0;
        int maxRun = 1;
        int curr = 0;
        int currentRun = 1;

        for (int i = 1; i < n; i++) {
            if (a[i] >= a[i - 1]) {
                currentRun++;
                if (currentRun > maxRun) {
                    start = curr;
                    maxRun = currentRun;
                }
            } else {
                curr = i;
                currentRun = 1;
            }
        }
        System.out.println(start + " " + maxRun);
    }
}