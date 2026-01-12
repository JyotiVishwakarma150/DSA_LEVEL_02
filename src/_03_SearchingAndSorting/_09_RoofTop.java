package _03_SearchingAndSorting;
import  java.util.*;
public class _09_RoofTop {
    public static int findMaxSteps(int[]arr) {
        int maxSum=0;// max increasing steps
        int count=0; // current increasing steps
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<arr[i+1]){
                count++;// step forward
            }else {
                if(count>maxSum){
                    maxSum=count; // update max
                }
                count=0;//reset count
            }

        }
        // last increasing sequence check
        if(count>maxSum){
            maxSum=count;
        }

        return maxSum;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findMaxSteps(arr);
        System.out.println(ans);
    }
}
