package _03_SearchingAndSorting;
import java.util.*;
public class _11_CountInversions {
    // Global inversion count
    static int count=0;
    // Merge two sorted arrays + count inversions
    public static int[] merge2sortedArrays(int[] left,int[] right){
        int i=0;
        int j=0;
        int k=0;
        int[] merged =new int[left.length+ right.length];
        // Merge logic
        while(i< left.length && j< right.length){
            if(left[i]<=right[j]){
                merged[k]=left[i];
                i++;
                k++;
            }else{
                // All remaining elements in left will form inversion
                count += (left.length-i);
                merged[k]=right[j];
                k++;
                j++;
            }
        }
        // Copy remaining elements
        while(i< left.length){
            merged[k]=left[i];
            i++;
            k++;
        }
        while(j<right.length){
            merged[k]=right[j];
            k++;
            j++;
        }
        return merged;
    }
    public static int[] mergeSort(int[] arr,int lo,int hi){
        // Base case: single element
        if(lo==hi){
            int[] ba=new int[1];
            ba[0]=arr[lo];
            return ba;
        }
        int mid=(lo+hi)/2;
        // Divide
        int[] left=mergeSort(arr,lo,mid);
        int[] right=mergeSort(arr,mid+1,hi);

        // Conquer + count
        int[] merged=merge2sortedArrays(left,right);
        return merged;
    }
    public static void main(String[]args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        mergeSort(arr,0,n-1);
        System.out.println(count);
    }
}
