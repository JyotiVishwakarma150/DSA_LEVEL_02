package _01_ArraysAndStrings;
import java.util.*;
public class _11_PartitionDisjoint {
    // ~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~
    public static int partitionDisjoint1(int[] arr) {
        // write your code here
        int n=arr.length;
        //1. make a rightmin array
        int[] rightMin=new int[n+1];
        rightMin[n]=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            rightMin[i]=Math.min(rightMin[i+1],arr[i]);
        }
        //2. maintain leftmax and figureout the partition the partition index
        int leftMax=Integer.MIN_VALUE;
        int ans=0;
        for(int i=0;i<n;i++){
            leftMax=Math.max(leftMax,arr[i]);
            if(leftMax<rightMin[i+1]){
                ans=i;
                break;
            }
        }
        return ans+1;
    }
    public static int partitionDisjoint2(int[] arr) {
        int leftmax =arr[0];
        int greater =arr[0];
        int ans=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>greater){
                greater=arr[i];

            }else if(arr[i]<leftmax){
                leftmax=greater;
                ans=i;
            }
        }
        return ans+1;
    }
    // ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int len = partitionDisjoint2(arr);
        //int len = partitionDisjoint1(arr);
        System.out.println(len);
    }
}
