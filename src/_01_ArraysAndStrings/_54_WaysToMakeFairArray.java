package _01_ArraysAndStrings;
import java.util.*;
public class _54_WaysToMakeFairArray {
    public static int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int totalEven = 0, totalOdd = 0;

        //Phle total even aur odd index ka sum nikal lege
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                totalEven += nums[i];
            else
                totalOdd += nums[i];
        }

        int even = 0, odd = 0;  // prefix sums (ab tak ka sum)
        int count = 0;          // fair array count

        //Har index ko remove krke check krege
        for (int i = 0; i < n; i++) {

            // Phle current index ka element total sum se hta do
            if (i % 2 == 0)
                totalEven -= nums[i];
            else
                totalOdd -= nums[i];

            // 🔹 Step 3: Remove hone ke baad parity change hoti hai
            // Right side ke odd elements ab even ban jaate hain
            // aur even wale odd ban jaate hain
            int newEven = even + totalOdd;
            int newOdd = odd + totalEven;

            // Agar dono sum equal h to fair array mil gaya
            if (newEven == newOdd)
                count++;

            //Ab prefix update kar dege (next index ke liye)
            if (i % 2 == 0)
                even += nums[i];
            else
                odd += nums[i];
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int ans = waysToMakeFair(nums);

        // 🔹 Output print
        System.out.println(ans);
    }
}