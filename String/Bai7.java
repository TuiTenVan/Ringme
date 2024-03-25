package String;

import java.util.Scanner;

public class Bai7 {
    public static String remove(String s1, String s2) {
        int index = s1.indexOf(s2);
        if (index != -1) {
            return s1.substring(0, index) + s1.substring(index + s2.length());
        }
        return s1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        while (s1.contains(s2)) {
            s1 = remove(s1, s2);
        }
        System.out.println("Xâu s1 sau khi loại bỏ s2: " + s1);
    }
}
