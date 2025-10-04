package _01_ArraysAndStrings;
import java.util.*;
public class _50_ConstructTargetArrayWithMultipleSums {

    // Function to check if target array can be constructed
    public static boolean isPossible(int[] arr) {
        long sum = 0;
        // Max-Heap banaya (reverse order me PQ)
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Array ke elements PQ me daalo aur sum nikalo
        for (int ele : arr) {
            pq.add((long) ele);
            sum += ele;
        }

        // Jab tak max element > 1 ho
        while (pq.peek() != 1) {
            long top = pq.poll();     // Sabse bada element nikala
            long restSum = sum - top; // Baki elements ka sum

            // Agar invalid condition aa gayi to false
            if (restSum <= 0 || sum <= top) {
                return false;
            }

            // Previous value nikalne ke liye (top - restSum)
            top = top - restSum;

            // Naya element dubara PQ me daalo
            pq.add(top);

            // Sum update karo (total sum me naye element ko daalo)
            sum = restSum + top;
        }
        return true; // Agar sab 1 ho gaye to possible hai
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // Array ka size input lo
        int n = scn.nextInt();
        int[] arr = new int[n];

        // Array ke elements input lo
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        // Function call karke result check karo
        boolean res = isPossible(arr);

        // Result print karo
        System.out.println(res);

    }
}
