package _03_SearchingAndSorting;
import java.util.*;
public class _13_MaxSumInTheConfiguration{
    public static int maximise(int[]arr) {
        int n=arr.length;
        int sum=0;// array ka total sum
        int S0=0;// initial configuration value

        // sum and S0 calculate karo
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            S0+=arr[i]*i;
        }
        int max=S0;// max value store karega
        int Si=S0;// previous configuration value

        // rotations ke liye loop
        for(int i=0;i<n-1;i++){
            // next rotation ka formula
            int Sip1=Si+sum-n*arr[n-i-1];
            if(Sip1>max){// max update
                max=Sip1;
            }
            Si=Sip1;// next ke liye prepare
        }
        return max;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = maximise(arr);
        System.out.println(ans);
    }
}
