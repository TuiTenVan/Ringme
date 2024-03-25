import java.util.*;

public class Bai6a {
    public static int findInsertionIndex(int n, int[] a, int x) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] < x) {
                left = mid + 1;
            } else if (a[mid] > x) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
    public static int[] insertValue(int n, int[] a, int x, int index) {
        int[] res = new int[n + 1];
        for (int i = 0; i < index; i++) {
            res[i] = a[i];
        }
        res[index] = x;
        for (int i = index; i < n; i++) {
            res[i + 1] = a[i];
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        Arrays.sort(a);
        
        int index = findInsertionIndex(n, a, x);
        int[] result = insertValue(n, a, x, index);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}