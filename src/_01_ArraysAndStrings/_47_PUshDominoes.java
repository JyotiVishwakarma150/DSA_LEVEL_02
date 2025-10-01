package _01_ArraysAndStrings;
import java.util.*;
public class _47_PUshDominoes {
    // ~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~
    public static void solveConfiguration(char[] arr, int i, int j) {
        if (arr[i] == 'L' && arr[j] == 'L') {
            // make all dots as L
            for (int k = i + 1; k < j; k++) {
                arr[k] = 'L';
            }
        } else if (arr[i] == 'R' && arr[j] == 'R') {
            // make all dots as R
            for (int k = i + 1; k < j; k++) {
                arr[k] = 'R';
            }
        } else if (arr[i] == 'L' && arr[j] == 'R') {
            // nothing to do
        } else {
            // case: arr[i] == 'R' && arr[j] == 'L'
            int diff = j - i ;
            int mid = (i + j) / 2;
            if (diff % 2 == 0) {
                // odd number of dots

                for (int k = i + 1; k < mid; k++) arr[k] = 'R';
                for (int k = mid+1; k < j; k++) arr[k] = 'L';
            } else {
                // even number of dots
                for (int k = i + 1; k <= mid; k++) arr[k] = 'R';
                for (int k = mid+1; k <j; k++) arr[k] = 'L';
            }
        }
    }

            public static String pushDominoes(String s) {
        // write your code here
                int n=s.length();
                char[] arr = new char[n + 2];
                arr[0] = 'L';
                arr[n+1] = 'R';

                for (int i = 1; i < arr.length-1; i++) {
                    arr[i] = s.charAt(i-1);
                }

                int j= 0, k = 1;
                while (k < arr.length) {
                    while (arr[k] == '.') k++;

                        solveConfiguration(arr,  j,k);
                     j=k;
                     k++;

                }
                StringBuilder ans = new StringBuilder();
                for (int i = 1; i < arr.length - 1; i++) {
                    ans.append(arr[i]);
                }
                return ans.toString();
            }

    // ~~~~~~~~~~~Input Management~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        String res = pushDominoes(str);
        System.out.println(res);
    }
}
