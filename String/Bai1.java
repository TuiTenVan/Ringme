package String;

import java.util.Scanner;

public class Bai1 {
    public static boolean Check(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        for(int i = 100000; i < 1000000; i++){
            String it = Integer.toString(i);
            if(Check(it)){
                System.out.print(it + " ");
            }
        }
    }
}
