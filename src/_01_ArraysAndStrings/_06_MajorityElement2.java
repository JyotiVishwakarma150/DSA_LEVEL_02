package _01_ArraysAndStrings;
import java.util.*;
public class _06_MajorityElement2 {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
    public static boolean isGreaterThaNb3(int[] arr,int val) {
        int count = 0;
        for (int ele : arr) {
            if (ele == val) {
                count++;
            }

        }
        return count > arr.length / 3;
    }
    public static ArrayList<Integer> majorityElement2(int[] arr) {
        // write your code here
        int val1=arr[0];
        int count1=1;
        int val2=arr[0];//assign any random value
        int count2=0;
        int i=1;
        while(i<arr.length){
            if(arr[i]==val1){
                count1++;
            }else if(arr[i]==val2){
                count2++;
            }else{
                if(count1==0){
                    val1=arr[i];
                    count1=1;
                }else if(count2==0){
                    val2=arr[i];
                    count2=1;
                }else{
                    count1--;
                    count2--;
                }
            }
            i++;
        }
        //val1 and val2 -> potential candidate
        ArrayList<Integer> res=new ArrayList<>();
        if(isGreaterThaNb3(arr,val1)==true){
            res.add(val1);
        }
        if(val1!=val2 && isGreaterThaNb3(arr,val2)==true){
            res.add(val2);
        }
        return res;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        ArrayList<Integer> res = majorityElement2(arr);
        System.out.println(res);
    }
}
