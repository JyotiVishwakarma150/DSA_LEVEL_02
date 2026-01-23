package _03_SearchingAndSorting;
import java.util.*;
public class _21_ChocolateDistribution {
    public static int find(int[]arr, int n, int m) {
        int ans=Integer.MAX_VALUE; // store minimum difference
        Arrays.sort(arr);// sort packets
        for(int i=0;i<=n-m;i++){
            int minW=arr[i];// minimum chocolates
            int maxW=arr[i+m-1];// maximum chocolates
            int gap=maxW-minW;// difference
            if(gap<ans){
                ans=gap; // update answer
            }
        }
        return ans;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int m = scn.nextInt();
        int ans = find(arr, n, m);

        System.out.println(ans);
    }
}
