package _01_ArraysAndStrings;
import java.util.Scanner;
public class _48_MaxProductSubarray {
    public static int max(int[] arr){
        int ans=Integer.MIN_VALUE;
        int cprod=1;
        for(int i=0;i<arr.length;i++){
            cprod*=arr[i];
            ans=Math.max(ans,cprod);
            if(cprod==0){
                cprod=1;
            }
        }
        cprod=1;
        for(int i=arr.length-1;i>=0;i--){
            cprod=arr[i];
            ans=Math.max(ans,cprod);
            if(cprod==0){
                cprod=1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextInt();
        }
        System.out.println(max(a));

    }
}
