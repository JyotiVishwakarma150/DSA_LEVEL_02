package _01_ArraysAndStrings;

import java.util.*;

public class _32_MaxAreaOfIsland {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, -1, 0, 1};

    public static int findAreaOfIsland(int[][] grid, boolean[][] vis, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        // 1. Boundary check
        if (i >= n || j >= m || i < 0 || j < 0) return 0;
        // 2. Already visited ya water check
        if (grid[i][j] == 0 || vis[i][j]) return 0;
        // 3. Mark as visited
        vis[i][j] = true;
        int nextAns = 0;
        // 4. Explore 4 directions recursively
        for (int d = 0; d < 4; d++) {
            nextAns += findAreaOfIsland(grid, vis, i + di[d], j + dj[d]);
        }
        // 5. Current cell ka +1 add karke return karo
        return nextAns + 1;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int ans = 0;
        // Traverse whole grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    // Agar land cell mila aur visited nahi hai to DFS call
                    ans = Math.max(ans, findAreaOfIsland(grid, vis, i, j));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of cols: ");
        int m = sc.nextInt();

        int[][] grid = new int[n][m];
        System.out.println("Enter grid elements (0/1):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int ans = maxAreaOfIsland(grid);
        System.out.println("Maximum Area of Island = " + ans);
    }
}
