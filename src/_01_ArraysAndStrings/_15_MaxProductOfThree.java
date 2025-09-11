package _01_ArraysAndStrings;
import java.util.*;
public class _15_MaxProductOfThree {
    // ~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~
    public static int maximumProduct(int[] arr) {
        // write your code here
        int min1=Integer.MAX_VALUE;
        int min2=min1;
        int max1=Integer.MIN_VALUE;
        int max2=max1;
        int max3=max1;
        for(int i=0;i<arr.length;i++){
            int val=arr[i];
            if(val>=max1){
                max3=max2;
                max2=max1;
                max1=arr[i];
            }else if(val>=max2){
                max3=max2;
                max2=arr[i];
            }else if(val>=max3){
                max3=arr[i];
            }
            if(val<=min1){
                min2=min1;
                min1=arr[i];
            }else if(val<=min2){
                min2=arr[i];
            }
        }
        int res=Math.max((min1*min2*max1),(max1*max2*max3));
        return res;
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int prod = maximumProduct(arr);
        System.out.println(prod);
    }
}
