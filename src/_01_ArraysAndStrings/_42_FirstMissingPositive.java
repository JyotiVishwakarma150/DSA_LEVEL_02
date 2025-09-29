package _01_ArraysAndStrings;
import java.util.*;
public class _42_FirstMissingPositive {
    //~~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~~~
    public static int firstMissingPositive(int[] arr) {
        //step1 -> mark element which are out of range and manage presence of one
        boolean one = false;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==1)
                one = true;

                if(arr[i]<1 || n<arr[i]){
                    arr[i]=1;
                }
            }
            if(one==false) return 1;
            //step2->map elements with index+1 is missing from array
        for(int i=0;i<n;i++){
            int indx=Math.abs(arr[i]);
            arr[indx-1]=-Math.abs(arr[indx-1]);
        }
        //step3-> find out missing integer
        for(int i=0;i<n;i++){
            //if element is +ve that means index is missing from array
            if(arr[i]>0) return i+1;
        }
        return n+1;
        }

    //~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = firstMissingPositive(arr);
        System.out.println(res);
    }
}
