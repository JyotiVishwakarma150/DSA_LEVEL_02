package _02_HashmapAndHeap;
import java.util.*;
public class _31_LongestSubArrayWithEqualNumberOf0sAnd1s {
    public static int solution(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        int sum=0;
        map.put(0,-1);// sum 0 start se
        for(int i=0;i<arr.length;i++){
            // 0 → -1, 1 → +1
            if(arr[i]==0){
                sum += -1;
            }else if(arr[i]==1){
                sum += 1;
            }
            if(map.containsKey(sum)){
                int idx=map.get(sum);
                int len=i-idx;// current length
                if(len>ans){
                    ans=len;
                }
            }else{
                map.put(sum,i);// first index store
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
