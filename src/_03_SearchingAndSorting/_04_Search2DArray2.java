package _03_SearchingAndSorting;
import java.util.*;
public class _04_Search2DArray2{
    /*your task is to complete this function which returns true if target exists in the matrix
   else return false*/
    public static boolean search(int[][]matrix,int target) {
        int r=0;// first row
        int c=matrix[0].length-1;// last column (top-right corner)

        // jab tak matrix ke andar ho
        while(r< matrix.length && c>=0){
            if(matrix[r][c]==target){
                return true;// target mil gaya
            }
            else if(matrix[r][c]>target){
                c--;// left move (column--)
            }
            else{
                r++;// down move (row++)
            }
        }
        return false;// target nahi mila
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int[][]matrix = new int[m][n];

        for(int i=0; i < m;i++) {
            for(int j=0; j < n;j++) {
                matrix[i][j] = scn.nextInt();
            }
        }
        int target = scn.nextInt();
        boolean isFound = search(matrix,target);
        System.out.println(isFound);

    }
}
