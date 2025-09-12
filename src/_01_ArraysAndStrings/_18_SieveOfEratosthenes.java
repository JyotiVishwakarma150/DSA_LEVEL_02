package _01_ArraysAndStrings;
import java.util.*;
public class _18_SieveOfEratosthenes {
    // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static void printPrimeUsingSieve(int n) {
        // write your code here
        boolean[] isprime=new boolean[n+1];
        Arrays.fill(isprime,true);
        for(int i=2;i*i<=isprime.length;i++){
            if(isprime[i]==true){
                //making multiples not prime
                for(int j=i+i;j< isprime.length;j+=i){
                    isprime[j]=false;//not prime
                }
            }
        }
        //print all prime till n
        for(int i=2;i<isprime.length;i++){
            if(isprime[i]==true){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPrimeUsingSieve(n);
    }
}
