package _02_HashmapAndHeap;
import java.util.*;
public class _58_AvoidFloodInTheCity {
    public static int[] avoidFlood(int[] rains) {

        // map: lake -> last rain day index
        HashMap<Integer, Integer> lastRain = new HashMap<>();
        // set of all dry days (rains[i] == 0), sorted
        TreeSet<Integer> dry = new TreeSet<>();

        int n = rains.length;
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            int x = rains[i];
            // if dry day
            if (x == 0) {
                dry.add(i);// store dry day index
                ans[i] = 1;  // default value (can be updated)
            }
            // if rain day
            else {
                // last rain day of this lake
                Integer id = lastRain.get(x);
                // if first time rain on this lake
                if (id == null) {
                    lastRain.put(x, i);
                }
                // lake already full, need to dry before
                else {
                    // find nearest dry day after last rain
                    Integer dryThisDay = dry.higher(id);
                    // no dry day available -> flood
                    if (dryThisDay == null) {
                        return new int[0];
                    }
                    // dry this lake on that day
                    ans[dryThisDay] = x;
                    dry.remove(dryThisDay);
                    // update last rain day
                    lastRain.put(x, i);
                }
                // rain day marked as -1
                ans[i] = -1;
            }
        }
        return ans;
    }

    // main function with user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] rains = new int[n];

        for (int i = 0; i < n; i++) {
            rains[i] = sc.nextInt();
        }

        int[] res = avoidFlood(rains);

        if (res.length == 0) {
            System.out.println("[]");
        } else {
            for (int x : res) {
                System.out.print(x + " ");
            }
        }
    }
}
