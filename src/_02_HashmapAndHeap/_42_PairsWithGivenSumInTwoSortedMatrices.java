package _02_HashmapAndHeap;
import java.util.*;
public class _42_PairsWithGivenSumInTwoSortedMatrices {
    public static int solve(int[][] num1, int[][] num2, int k) {
        int count=0;
        // store frequency of elements of matrix-1
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i< num1.length;i++){
            for(int j=0;j<num1[0].length;j++){
                map.put(num1[i][j],map.getOrDefault(num1[i][j],0)+1);
            }
        }
        // check for required pair in matrix-2
        for(int i=0;i< num2.length;i++){
            for(int j=0;j<num2[0].length;j++){
                int key=k-num2[i][j];// value needed from matrix-1
                if(map.containsKey(key)){
                    count += map.get(key);// add its frequency
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] mat1 = new int[N][N];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                mat1[i][j] = sc.nextInt();
            }
        }

        int[][] mat2 = new int[N][N];
        for (int i = 0; i < mat2.length; i++) {
            for (int j = 0; j < mat2[0].length; j++) {
                mat2[i][j] = sc.nextInt();
            }
        }
        int K = sc.nextInt();
        System.out.println(solve(mat1, mat2, K));

    }

}
