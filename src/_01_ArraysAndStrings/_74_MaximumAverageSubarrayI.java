package _01_ArraysAndStrings;
import java.util.Scanner;
public class _74_MaximumAverageSubarrayI {
    public static double solution(int nums[], int k) {
        // write your code here
        int sum=0;
        // Pehle k elements ka sum nikal rahe — yahi starting window hai.
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        int max=sum;
        //Ab sliding window start — har step par ek naya element add, ek purana remove.
        for(int i=k;i<nums.length;i++){
            sum+=nums[i];// → Right side se new element add
            sum-=nums[i-k]; // → Left side ka old element remove
            max=Math.max(max,sum);// → Max sum window track karna
        }
        //Max average return (sum ko double banane ke liye *1.0)
        return (max*1.0)/k;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nums[] = new int[n];
        for (int i = 0 ; i < n ; i++) {
            nums[i] = scn.nextInt();
        }
        int k = scn.nextInt();

        System.out.println(solution(nums, k));
    }
}
