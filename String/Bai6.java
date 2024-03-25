package String;

import java.util.Scanner;
import java.util.Arrays;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = input.split("\\s+");
        Arrays.sort(words);
        System.out.println("Các từ trong câu theo thứ tự Alphabet:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
