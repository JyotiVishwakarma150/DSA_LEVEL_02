package _01_ArraysAndStrings;
import java.util.*;
import java.io.*;
public class _62_IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        //Code Here
        int per=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {//for land...main work counting of perimeter
                        per += 4;
                        if(j>0 && grid[i][j - 1] == 1) {//firstly we will check ki khi j out of bound mtlb grid ka bahar to nhi chla gya
                            //and fr baad mein upr wala check krege land hai ya nahi
                                per -= 2;
                            }
                        if(i>0 && grid[i - 1][j] == 1) {//same as first condition but i ko check krege  and then left side mein check krege
                            //ki land hai ya nahi
                                per -= 2;
                            }
                    }
                }
            }

    return per;
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] grid = new int[row][col];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(islandPerimeter(grid));
    }
}
