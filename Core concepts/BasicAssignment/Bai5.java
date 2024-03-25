import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Long sum = 0L;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        System.out.println(sum);
    }
}
