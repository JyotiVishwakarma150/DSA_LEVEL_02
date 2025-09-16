package _01_ArraysAndStrings;
import java.util.*;
public class _25_WiggleSort1 {
    // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~
    public static void swap(int[] arr,int left,int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;

    }
    public static void wiggleSort(int[] arr) {
        // write your code here
        for(int i=0;i<arr.length-1;i++){
            if(i%2==0){
                //even index
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                }
            }else{
                //odd index
                if(arr[i]<arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        wiggleSort(arr);

        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }


}
