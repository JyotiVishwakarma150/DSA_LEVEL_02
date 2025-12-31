package _02_HashmapAndHeap;

import java.util.*;

public class _54_TheSkylineProblem {
    // Pair class for x-coordinate and height
    static class Pair implements Comparable<Pair> {
        int x;
        int ht;

        Pair(int x, int ht) {
            this.x = x;
            this.ht = ht;
        }

        // Sorting based on x first, then height
        @Override
        public int compareTo(Pair o) {
            if (this.x != o.x)
                return this.x - o.x;
            return this.ht - o.ht;
        }
    }

    // Main skyline function
    public static List<List<Integer>> getSkyline(int[][] buildings) {

        List<Pair> list = new ArrayList<>();

        // Step 1: Create events
        for (int[] b : buildings) {
            list.add(new Pair(b[0], -b[2])); // building start (negative height)
            list.add(new Pair(b[1], b[2]));  // building end (positive height)
        }

        // Step 2: Sort events
        Collections.sort(list);

        // Max Heap for heights
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        List<List<Integer>> ans = new ArrayList<>();

        int currHt = 0;
        pq.add(0); // ground level

        // Step 3: Process events
        for (Pair p : list) {

            if (p.ht < 0) {
                // building start
                pq.add(-p.ht);
            } else {
                // building end
                pq.remove(p.ht);
            }

            // Step 4: height change detected
            if (currHt != pq.peek()) {
                List<Integer> temp = new ArrayList<>();
                temp.add(p.x);
                temp.add(pq.peek());
                ans.add(temp);

                currHt = pq.peek();
            }
        }
        return ans;
    }

    // User input main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of buildings: ");
        int n = sc.nextInt();

        int[][] buildings = new int[n][3];

        System.out.println("Enter buildings (left right height):");
        for (int i = 0; i < n; i++) {
            buildings[i][0] = sc.nextInt();
            buildings[i][1] = sc.nextInt();
            buildings[i][2] = sc.nextInt();
        }

        List<List<Integer>> skyline = getSkyline(buildings);

        System.out.println("Skyline Output:");
        for (List<Integer> point : skyline) {
            System.out.println(point);
        }
    }
}
