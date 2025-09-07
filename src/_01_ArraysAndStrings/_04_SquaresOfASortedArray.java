package _01_ArraysAndStrings;
import java.util.*;
import java.util.Arrays;
public class _04_SquaresOfASortedArray {
    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int[] sortedSquares(int[] nums) {
        //nlogn time complexity ..not a good way
//        for(int i=0;i< nums.length;i++){
//            nums[i]=nums[i]*nums[i];
//
//        }
//        Arrays.sort(nums);
//        return nums;
        int[] res = new int[nums.length];
        int i=0;
        int j=nums.length-1;
        int index=nums.length-1;
        while(i<=j){
            int val1=nums[i]*nums[i];
            int val2=nums[j]*nums[j];
            if(val1>val2){
                res[index]=val1;
                i++;
            }else{
                res[index]=val2;
                j--;
            }
            index--;
        }
        return res;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++)
            nums[i] = scn.nextInt();

        int[] res = sortedSquares(nums);

        for(int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
