package _01_ArraysAndStrings;
import java.util.*;
public class _22_ShortestUnsortedContinuousSubarray {
    public  static int findUnsortedSubarray(int[] nums) {
        if(nums==null||nums.length<=1) return 0;//security check
        int end = -1;
        int max = nums[0];
        //left->right scan
        for (int i = 1; i < nums.length; i++) {
            if (max > nums[i]) {
                end = i;
            } else {
                max = nums[i];
            }
        }
        int st = 0;
        int min = nums[nums.length - 1];
        //right->left scan
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > min) {
                st = i;
            } else {
                min = nums[i];
            }
        }
        return end - st + 1;
    }public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int ans=findUnsortedSubarray(arr);
        System.out.println(ans);
    }
}
