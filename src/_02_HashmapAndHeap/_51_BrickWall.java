package _02_HashmapAndHeap;
import java.util.*;
public class _51_BrickWall {
    public static int leastBricks(List<List<Integer>> wall) {

        // map -> edge position ka frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // har row traverse karo
        for (List<Integer> row : wall) {

            int sum = 0;

            // last brick tak nahi jaate (right edge allowed nahi)
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);   // edge position
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int maxEdges = 0;

        // maximum frequency nikaalo
        for (int val : map.values()) {
            maxEdges = Math.max(maxEdges, val);
        }

        // total rows - max common edges
        return wall.size() - maxEdges;
    }

    // main method (user input)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        List<List<Integer>> wall = new ArrayList<>();

        for (int i = 0; i < rows; i++) {

            System.out.print("Enter number of bricks in row " + (i + 1) + ": ");
            int bricks = sc.nextInt();

            List<Integer> row = new ArrayList<>();

            System.out.println("Enter brick widths:");
            for (int j = 0; j < bricks; j++) {
                row.add(sc.nextInt());
            }

            wall.add(row);
        }

        int ans = leastBricks(wall);
        System.out.println("Minimum bricks crossed = " + ans);

        sc.close();
    }
}

