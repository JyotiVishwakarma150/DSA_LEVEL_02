package _01_ArraysAndStrings;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class _55_OrderlyQueue {

    public static String orderlyQueue(String str,int k){
        char[] arr = str.toCharArray();
        //k > 1 → full freedom → bas sort kar do (smallest mil jayegi)
       if(k>1){
           Arrays.sort(arr);
           return String.valueOf(arr);
       }
       //If k == 1 → only rotation possible → check all rotations
       String ans=str;
       for(int i=0;i<str.length();i++){
          rotateArray(arr);//// ek rotation
           int diff=ans.compareTo(String.valueOf(arr));
           if(diff>0){
               ans=String.valueOf(arr);
           }
       }
       return ans;
    }

    // pehla char uthao aur last me chipka do
    public  static void rotateArray(char[] arr){
        char t=arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i]=arr[i+1];
        }
        arr[arr.length-1]=t;
    }
    public static void main(String[] args) {
        Scanner scn =new Scanner(System.in);
        String str=scn.next();
        int k=scn.nextInt();
        String res=orderlyQueue(str,k);
        System.out.println(res);
    }
}
