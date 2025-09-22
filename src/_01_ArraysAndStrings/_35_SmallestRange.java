package _01_ArraysAndStrings;
import java.util.*;

public class _35_SmallestRange {

    // Function from your image
    public static int[] smallestRange(List<List<Integer>> nums) {
        int res[] = {-100000, 100000};
        int k = nums.size();
        int max = Integer.MIN_VALUE;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Add first element of each list into min-heap
        for (int i = 0; i < k; i++) {
            pq.add(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }

        while (true) {
            int min[] = pq.poll();
            if (max - min[0] < res[1] - res[0]) {
                res[0] = min[0];
                res[1] = max;
            }

            if (min[2] + 1 == nums.get(min[1]).size()) {
                break; // one list is exhausted
            }

            int nextVal = nums.get(min[1]).get(min[2] + 1);
            pq.add(new int[]{nextVal, min[1], min[2] + 1});
            max = Math.max(max, nextVal);
        }

        return res;
    }

    // Main function with user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of lists (k): ");
        int k = sc.nextInt();

        List<List<Integer>> nums = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            System.out.print("Enter size of list " + (i + 1) + ": ");
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            System.out.println("Enter " + n + " sorted integers:");
            for (int j = 0; j < n; j++) {
                list.add(sc.nextInt());
            }
            nums.add(list);
        }

        int[] range = smallestRange(nums);
        System.out.println("Smallest Range: [" + range[0] + ", " + range[1] + "]");

        sc.close();
    }
}
