package _01_ArraysAndStrings;
import java.util.*;
public class _53_WhereWillTheBallFall {
    public static int[] FindBall(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int[] ans = new int[m];
        for (int j=0;j<m;j++){
            int cpos=j;//ball li current column position
            int npos=-1;//next position
            for(int i=0;i<n;i++){
                npos=cpos+grid[i][cpos]; //1->right,-1->left
                if(npos<0 || npos>=m || grid[i][cpos]!=grid[i][npos]){//boundaries cover kregi ye line all boundaries
                    cpos=-1;//mark as stuck!!
                    break;
                }
                //mtlb balls successfully next column tkk phuch gyi hain
                cpos=npos;
            }
            ans[j]=cpos;//last ans yhi carry krega
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int[][] grid=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=scn.nextInt();
            }
        }
        int[] res=FindBall(grid);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+"");
        }
        System.out.println();
    }
}
