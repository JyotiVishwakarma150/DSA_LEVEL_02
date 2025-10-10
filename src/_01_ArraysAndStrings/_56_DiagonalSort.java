package _01_ArraysAndStrings;

import java.util.*;

public class _56_DiagonalSort {

    // Function to sort matrix diagonally
    public static int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Sort each diagonal starting from first row
        for (int i = 0; i < m; i++) {
            countSort(mat, i, 0);
        }

        // Sort each diagonal starting from first column
        for (int j = 1; j < n; j++) {
            countSort(mat, 0, j);
        }

        return mat;
    }

    // Helper function for counting sort on one diagonal
    public static void countSort(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        int i = r, j = c;

        // Find max element to create map array
        int maxVal = 0;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                maxVal = Math.max(maxVal, mat[x][y]);
            }
        }

        int[] map = new int[maxVal + 1];

        // Fill map
        while (i < m && j < n) {
            map[mat[i][j]]++;
            i++;
            j++;
        }

        i = r;
        j = c;

        // Sort back using map
        for (int k = 0; k < map.length; k++) {
            while (map[k] > 0) {
                mat[i][j] = k;
                i++;
                j++;
                map[k]--;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int m = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int n = sc.nextInt();

        int[][] mat = new int[m][n];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        mat = diagonalSort(mat);

        System.out.println("Matrix after diagonal sort:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}