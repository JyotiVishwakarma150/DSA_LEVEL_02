package _02_HashmapAndHeap;
import java.util.*;
public class _39_CheckArithmeticSequence {
    public static boolean solution(int[] arr) {
        // Agar array me 0 ya 1 element hai,to wo hamesha AP hota hai
        if(arr.length<=1){
            return true;
        }
        //hashset for unique elements
        HashSet<Integer> set=new HashSet<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int n=arr.length;

        for(int val:arr){
            min=Math.min(val,min);//for min element
            max=Math.max(val,max);//for max element
            set.add(val);// unique check ke liye
        }

        //common difference nikl rhe hai
       int d=(max-min)/(n-1);

        // Check kar rahe hain ki expected AP ke saare elements array me present hain ya nahi
        for(int i=0;i<arr.length;i++){
            int ai=min+i*d;// AP ka ith element

            // Agar koi element missing mila to AP possible nahi
            if(set.contains(ai)==false){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
