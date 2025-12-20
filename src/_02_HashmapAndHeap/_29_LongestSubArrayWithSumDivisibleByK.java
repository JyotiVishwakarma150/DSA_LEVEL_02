package _02_HashmapAndHeap;
import java.util.*;
public class _29_LongestSubArrayWithSumDivisibleByK {
    public static int solution(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        int sum=0;
        int rem=0;
        // handle subarray starting from index 0
        map.put(0,-1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];// update prefix sum
            rem=sum%k; // current remainder
            // fix negative remainder
            if(rem<0){
                rem+=k;
            }
            // if same remainder seen before
            if(map.containsKey(rem)){
                int idx=map.get(rem);// first index of this remainder
                int len=i-idx;// subarray length
                if(len>ans){// update answer
                    ans=len;
                }

            }
            // store remainder first time only
            else{
                map.put(rem,i);
            }
        }

        return ans;// longest subarray length
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
