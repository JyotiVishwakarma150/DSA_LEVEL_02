package _02_HashmapAndHeap;
import java.util.*;

public class _27_CountSubArraysHavingSumEqualsK {
    public static int solution(int[] arr, int target){
        // write your code here
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);// prefix sum 0 ek baar already
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];// running sum
            // agar (sum - target) pehle aaya hai
            if(map.containsKey(sum-target)){
                ans += map.get(sum-target);
            }
            // current sum ko map me add/update
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        System.out.println(solution(arr,target));
}

    }
