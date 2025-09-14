package _01_ArraysAndStrings;
import java.util.*;
public class _09_ProductOfArrayExceptItself {

    //~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
    public static int[] productExceptSelf(int[] arr) {
        // write your code here
        //1. right product array
        int[] right = new int[arr.length];
        int prod=1;
        for(int i=arr.length-1;i>=0;i--){
            prod*=arr[i];
            right[i]=prod;
        }
        //2.make result with maintaining of left product
        prod=1;
        int[] res = new int[arr.length];
        for(int i=0;i<arr.length-1;i++){
            int lp=prod;
            int rp=right[i+1];
            res[i]=lp*rp;
            prod*=arr[i];
        }
        res[arr.length-1]=prod;
        return res;
    }

    //~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] res = productExceptSelf(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
