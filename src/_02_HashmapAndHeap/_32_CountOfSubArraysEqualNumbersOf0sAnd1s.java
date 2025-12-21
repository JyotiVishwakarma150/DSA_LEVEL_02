package _02_HashmapAndHeap;
import java.util.*;
public class _32_CountOfSubArraysEqualNumbersOf0sAnd1s {
    public static int solution(int[] arr) {
        // write your code here
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        int sum=0;
        map.put(0,1);// sum 0 ek baar pehle se
        for(int i=0;i<arr.length;i++){
            // 0 → -1, 1 → +1
            if(arr[i]==0){
                sum += -1;
            }else if(arr[i]==1){
                sum += 1;
            }
            if(map.containsKey(sum)){
              ans+=map.get(sum);// jitni baar mila, utne subarrays
              map.put(sum,map.get(sum)+1);
            }else{
                map.put(sum,1); // first time sum
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
        System.out.println(solution(arr));
    }

}
