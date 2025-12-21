package _02_HashmapAndHeap;
import java.util.*;
public class _30_CountSubArraysWithSumDivisibleByK {
    public static int solution(int[] arr, int k) {
        // write your code here
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        int sum=0;
        int rem=0;
        // handle subarray starting from index 0
        map.put(0,1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];// update prefix sum
            rem=sum%k; // current remainder
            // fix negative remainder
            if(rem<0){
                rem+=k;
            }
            // if same remainder seen before
            if(map.containsKey(rem)){
                ans+=map.get(rem);
               map.put(rem,map.get(rem)+1);

            }
            // store remainder first time only
            else{
                map.put(rem,1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

}
