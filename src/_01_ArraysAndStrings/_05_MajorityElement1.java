package _01_ArraysAndStrings;
import java.util.*;
public class _05_MajorityElement1 {
    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~
     public static int validCandidate(int[] arr){
         int val=arr[0];
         int count=1;
         for(int i=1;i<arr.length;i++){
             if(val==arr[i]){
                 //same element ,increment in frequency
                 count++;
             }else{
                 //distinct element , map it with value
                 count--;
             }
             if(count==0){
                 val=arr[i];
                 count=1;
             }
         }
         return val;
     }
    public static void printMajorityElement(int[] arr) {
        // write your code here
        //value have potential candidate for majority
        int value = validCandidate(arr);
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                count++;
            }
        }
        if(count>arr.length/2){
            //majority element is value
            System.out.println(value);
        }else{
            //no majority element
            System.out.println("no majority element exist");
        }
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        printMajorityElement(arr);
    }
}
