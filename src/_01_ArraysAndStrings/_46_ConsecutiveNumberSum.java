package _01_ArraysAndStrings;
import java.util.*;
public class _46_ConsecutiveNumberSum {
    // ~~~~~~~~~~~User's Section~~~~~~~~~~~~~
    public static int consecutiveNumbersSum(int n) {
        // write your code here
        int count=0;
        for(int k=1;2*n>k*(k-1);k++){
            int numerator=n-(k*(k-1)/2);
            if(numerator%k==0)
                count++;

        }
        return count;
    }

    // ~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int res = consecutiveNumbersSum(num);
        System.out.println(res);
    }
}
