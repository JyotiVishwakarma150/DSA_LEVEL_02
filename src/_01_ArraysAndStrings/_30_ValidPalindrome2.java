package _01_ArraysAndStrings;
import java.util.*;
public class _30_ValidPalindrome2 {
    // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~
    public static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;

            }
        }
        return true;
    }

    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
           if(s.charAt(i)==s.charAt(j)){
               i++;
               j--;
        }else{
               //skip from left OR skip from right-> delete at most one character
               return isPalindrome(s,i+1,j)||isPalindrome(s,i,j-1);
           }
    }
        return true;

}

        // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
        public static void main (String[]args){
            Scanner scn = new Scanner(System.in);
            String str = scn.nextLine();

            boolean res = validPalindrome(str);
            System.out.println(res);
        }
    }
