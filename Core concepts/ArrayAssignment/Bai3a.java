import java.util.Scanner;

public class Bai3a {
    public static void count(int[] arr, int n) {
        int[] d = new int[1000001];    
        for (int i = 0; i < n; i++) {
            d[arr[i]]++;
        }   
        int maxCount = 0;
        int maxElement = arr[0];
        for (int i = 0; i < n; i++) {
            if (d[arr[i]] > maxCount) {
                maxCount = d[arr[i]];
                maxElement = arr[i];
            }
        }
        for(int i = 0; i < n; i++){
            if(d[arr[i]] != 0){
                System.out.println(arr[i] + " " + d[arr[i]]);
                d[arr[i]] = 0;
            }
        }
        System.out.println("Phan tu " + maxElement + " xuat hien nhieu nhat voi " + maxCount + " lan");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }  
        count(arr, n);
    }
    
}
