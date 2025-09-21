package _01_ArraysAndStrings;
import java.util.*;
public class _33_NumSubarrayBoundedMax {
    public static int numSubarrayBoundedMax(int[] arr, int left, int right) {
        // write your code here
        //start index
        int si=0;
        int ei=0;//end index...iterate krega pure array pe
        int n=arr.length;
        int ans=0;
        int prevc=0;//last valid subarray count jo end ei-1 pe mila tha
        while (ei<n){
           if(left<=arr[ei] && arr[ei]<=right){
               prevc=ei-si+1;
               ans+=prevc;
           }else if(arr[ei]<left){
               ans+=prevc;
           }else{
               si=ei+1;
           }
           ei++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int left = scn.nextInt();
        int right = scn.nextInt();

        int count = numSubarrayBoundedMax(arr, left, right);
        System.out.println(count);
    }
}
