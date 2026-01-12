package _03_SearchingAndSorting;
import java.util.*;
public class _10_MaximizeSumOfArray {
    public static int maximise(int[]arr) {
        // Step 1: Sort array
        // chhote elements chhote index par,
        // bade elements bade index par
        Arrays.sort(arr);
        int totalSum=0;
        // Step 2: calculate arr[i] * i
        for(int i=0;i<arr.length;i++){
            totalSum += arr[i]*i;
        }
        return totalSum;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = maximise(arr);
        System.out.println(ans);
    }

}
