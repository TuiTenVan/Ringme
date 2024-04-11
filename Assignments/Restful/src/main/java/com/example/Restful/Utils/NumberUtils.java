package com.example.Restful.Utils;

public class NumberUtils {
    public static boolean checkNumber(String value) {
        try{
            Integer number = Integer.parseInt(value);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
