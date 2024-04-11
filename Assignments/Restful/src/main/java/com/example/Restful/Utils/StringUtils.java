package com.example.Restful.Utils;

public class StringUtils {
    public static boolean checkString(String str) {
        if(str != null && !str.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
