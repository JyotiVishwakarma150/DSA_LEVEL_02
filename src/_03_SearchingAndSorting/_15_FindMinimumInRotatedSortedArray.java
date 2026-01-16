package _03_SearchingAndSorting;
import java.util.*;
public class _15_FindMinimumInRotatedSortedArray {
    public static int findMinimum(int[]arr) {
        int lo=0;
        int hi=arr.length-1;
        if(arr[lo]<=arr[hi]) return arr[0]; //case 1:array is not rotated at all
        while(lo<=hi){
            int mid = (lo+hi)/2;
            // case 2: pivot found (drop point)
           if(arr[mid]>arr[mid+1]) return arr[mid+1];
           // case 3: mid itself is minimum
           else if(arr[mid]<arr[mid-1]) return arr[mid];
           // case 4: left part sorted → pivot on right
           else if(arr[lo]<=arr[mid]) lo=mid+1;
           // case 5: right part sorted → pivot on left
           else if(arr[mid]<=arr[hi]) hi=mid-1;
        }
        return -1;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findMinimum(arr);
        System.out.println(ans);
    }
}
