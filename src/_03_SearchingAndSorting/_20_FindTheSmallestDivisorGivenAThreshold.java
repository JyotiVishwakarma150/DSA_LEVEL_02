package _03_SearchingAndSorting;
import java.util.*;
public class _20_FindTheSmallestDivisorGivenAThreshold {

    // check: given divisor div par
    // sum of ceil(nums[i]/div) threshold ke andar hai ya nahi
    public static boolean isPossible(int[] nums, int div, int th) {
        int res = 0;
        // har element ka ceil division add karo
        for (int i = 0; i < nums.length; i++) {
            res += (int) Math.ceil(nums[i] * 1.0 / div);
        }
        return res <= th;
    }
    // minimum divisor find karne ke liye Binary Search
    public static int findSmallestDivisor(int[] nums, int th) {

        // maximum element find (upper bound of divisor)
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        // agar threshold = array length
        // to har element ko 1 hour me divide karna padega
        if (th == nums.length) {
            return max;
        }
        int lo = 1;       // minimum divisor
        int hi = max;     // maximum divisor
        int mdiv = Integer.MAX_VALUE;

        // Binary Search on divisor
        while (lo <= hi) {
            int div = lo + (hi - lo) / 2;

            if (isPossible(nums, div, th)) {
                mdiv = div;      // possible answer
                hi = div - 1;    // aur chhota divisor try karo
            } else {
                lo = div + 1;    // divisor chhota hai, badhana padega
            }
        }
        return mdiv;
    }
    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]nums = new int[n];

        for(int i=0 ; i < n ; i++) {
            nums[i] = scn.nextInt();
        }

        int th = scn.nextInt();

        int speed = findSmallestDivisor(nums,th);
        System.out.println(speed);
    }
}
