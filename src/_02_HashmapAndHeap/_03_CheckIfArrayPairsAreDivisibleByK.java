package _02_HashmapAndHeap;
import java.util.*;
import java.util.*;

public class _03_CheckIfArrayPairsAreDivisibleByK {
    public static void solution(int[] arr, int k) {
        HashMap<Integer, Integer> rfmap = new HashMap<>();
        // build remainder freq map
        for (int val : arr) {
            int rem = val % k;
            int of = rfmap.getOrDefault(rem, 0);
            rfmap.put(rem, of + 1);
        }
        // check pairs
        for (int val : arr) {
            int rem = val % k;
            if (rem == 0) {
                int fq = rfmap.get(rem);
                if (fq % 2 == 1) {
                    System.out.println(false);
                    return;
                }
            }
            else if (2 * rem == k) {   // why not k/2 → because using exact PepCoding condition
                int fq = rfmap.get(rem);
                if (fq % 2 == 1) {
                    System.out.println(false);
                    return;
                }
            }
            else {
                int fq = rfmap.get(rem);
                int ofq = rfmap.getOrDefault(k - rem, 0);

                if (fq != ofq) {
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(true);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        solution(arr, k);
    }
}
