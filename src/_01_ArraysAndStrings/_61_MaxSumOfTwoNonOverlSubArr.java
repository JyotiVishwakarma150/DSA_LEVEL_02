package _01_ArraysAndStrings;
import java.util.*;
public class _61_MaxSumOfTwoNonOverlSubArr {
    public  static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(
                helper(nums,firstLen,secondLen),
                helper(nums,secondLen,firstLen)
        );
    }
    public static  int helper(int[]  nums,int firstLen,int secondLen){
        int n=nums.length;
        int firstSum=0,secondSum=0;
        for(int i=0;i<firstLen;i++){
            firstSum+=nums[i];
        }
        int maxFirst=firstSum;//maximum first window sum so far
        //step-2...find sum of the next window (secondLen)
        for(int i=firstLen;i<firstLen+secondLen;i++){
            secondSum+=nums[i];
        }
        int ans=maxFirst+secondSum;
        //step-3...sliding window for rest of array
        for(int i=firstLen+secondLen;i<n;i++){
            //slide both windows
            secondSum += nums[i]-nums[i-secondLen];
            firstSum += nums[i-secondLen]-nums[i-secondLen-firstLen];
            //update max of first window
            maxFirst=Math.max(maxFirst,firstSum);
            //update answer
            ans=Math.max(ans,maxFirst+secondSum);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scn =new Scanner(System.in);
        int n=scn.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i]=scn.nextInt();
        }
        int fl=scn.nextInt();
        int sl=scn.nextInt();
        int ans=maxSumTwoNoOverlap(nums,fl,sl);
        System.out.println(ans);
    }
}
