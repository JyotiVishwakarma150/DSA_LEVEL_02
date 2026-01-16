package _03_SearchingAndSorting;
import java.util.*;
public class _14_SearchInASortedRotatedArray {
    public static int find(int[]arr,int target) {
        //write your code here
        int lo=0;
        int hi=arr.length-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(arr[mid]==target){// target mil gaya
                return mid;
            }
            else if(arr[lo]<=arr[mid]){// left half sorted hai
                    //lo to mid part is sorted
                if(target>=arr[lo] && arr[mid]>target){// target left sorted part mein hai
                    hi=mid-1;
                }else{
                    lo=mid+1;
                }
            }
            // right half sorted hai
            else if(arr[mid]<=arr[hi]){
                //mid to hi part is sorted
                if(target<arr[mid] && arr[hi]>=target){// target right sorted part mein hai
                    lo=mid+1;
                }
                else{
                    hi=mid-1;
                }
            }
        }
        return -1;// target not found
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();
        int ans = find(arr,target);
        System.out.println(ans);
    }

}