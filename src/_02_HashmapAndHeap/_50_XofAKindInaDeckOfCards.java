package _02_HashmapAndHeap;

import java.util.HashMap;
import java.util.Scanner;

public class _50_XofAKindInaDeckOfCards {//leetcode 914
    //helper function to find gcd of two numbers
    public  static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    //main function to check X of a kind
    public static boolean solution(int[] deck){
        HashMap<Integer,Integer> map=new HashMap<>();
        //create frequency map
        for(int val:deck){
            map.put(val,(map.getOrDefault(val,0)+1));
        }
        //calculate gcd of all frequencies
        int ans=0;
        for(int key:map.keySet()){
            ans=gcd(ans,map.get(key));
        }
        if(ans>=2){//if gcd>1,valid grouping possible
            return true;
        }else{
            return false;
        }

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] deck = new int[n];
        for (int i = 0; i < n; i++) {
            deck[i] = scn.nextInt();
        }
        System.out.println(solution(deck));

    }
}
