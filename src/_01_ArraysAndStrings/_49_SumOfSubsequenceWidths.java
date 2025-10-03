package _01_ArraysAndStrings;

import java.util.Arrays;
import java.util.Scanner;

public class _49_SumOfSubsequenceWidths {
    public static int sumSubseqWidths(int[] A){
        Arrays.sort(A);
        long ans=0;
        long mod=1000000007;
        int n=A.length;
        long[] pow=new long[n];
        pow[0]=1;
        for(int i=1;i<n;i++){
            pow[i]=(pow[i-1]*2)%mod;
        }
        for(int i=0;i<n;i++){
            ans=(ans+A[i]*(pow[i]-pow[n-i-1]))%mod;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int[] A=new int[n];
        for(int i=0;i<n;i++){
            A[i]=scn.nextInt();
        }
        System.out.println(sumSubseqWidths(A));
    }
}
