package _02_HashmapAndHeap;
import java.util.*;
public class _60_LineReflection {
    public static boolean isReflected(int[][] points) {
        //Code Here
        // points store karne ke liye
        HashMap<Long, Long> map = new HashMap<>();

        long xmin = Integer.MAX_VALUE;   // min x
        long xmax = Integer.MIN_VALUE;   // max x

        // xmin, xmax nikalna + map fill karna
        for (int[] point : points) {
            long x = point[0];
            long y = point[1];

            xmin = Math.min(xmin, x);    // min x update
            xmax = Math.max(xmax, x);    // max x update

            long hash = x * 100000000L + y; // (x,y) ka unique hash
            map.put(hash, 1L);              // map me store
        }

        long mirror = xmin + xmax; // mirror line ka sum

        // har point ka mirror exist karta hai ya nahi
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            long rx = mirror - x;         // reflected x
            long ry = y;                  // y same

            long imghash = rx * 100000000L + y; // mirror point hash

            if (map.containsKey(imghash) == false) { // mirror nahi mila
                return false;
            }
        }

        return true; // sabka mirror mil gaya

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] points = new int[n][2];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {
                points[i][j] = scn.nextInt();
            }
        }

        System.out.println(isReflected(points));
    }

}
