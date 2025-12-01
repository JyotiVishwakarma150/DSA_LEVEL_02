package _01_ArraysAndStrings;
import java.util.Scanner;

public class _73_CarPooling {
    public static boolean carPooling(int trips[][], int cap) {
        // write your code here
        // Step 1: Find last drop location to define highway size
        int lastDropLocation=-1;
        for(int trip[]:trips){
            // trip[1] = drop location
            lastDropLocation=Math.max(lastDropLocation,trip[1]);
        }
        // Step 2: Difference array (highway)
        // highway[i] = change in passengers at point i
        int highway[]=new int[lastDropLocation+1];
        for(int trip[]:trips){
            // At start point, passengers increase
            highway[trip[0]] += trip[2];
            // At end point, passengers decrease
            highway[trip[1]] -= trip[2];
        }
        // Step 3: Prefix sum to find actual passengers at each point
        for(int i=1;i<=lastDropLocation;i++){
            highway[i] += highway[i-1];
            // Step 4: Check capacity
            if(highway[i]>cap){
                return false; // overload
            }
        }
        return true;// never overloaded
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int trips[][] = new int[n][3];
        // input: start, end, passengers
        for (int i = 0 ; i < n ; i++) {
            trips[i][0] = scn.nextInt();
            trips[i][1] = scn.nextInt();
            trips[i][2] = scn.nextInt();
        }
        int cap = scn.nextInt();

        if (carPooling(trips, cap)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

}
