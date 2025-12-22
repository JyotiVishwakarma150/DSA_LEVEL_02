package _02_HashmapAndHeap;
import java.util.*;

public class _33_LongestSubArrayEqualNumberOf0s1s2s {
    public static int solution(int[] arr) {

        int ans=0;
        // map: "state (delta21#delta10)" → first index
        HashMap<String,Integer> map=new HashMap<>();
        // counts of 0s, 1s, 2s
        int countZ=0;
        int countO=0;
        int countT=0;
        int delta10=countO-countZ;// 1 vs 0
        int delta21=countT-countO; // 2 vs 1
        // initial state before array starts
        String key=delta21+"#"+delta10;
        map.put(key,-1);

        for(int i=0;i<arr.length;i++){
            // update counts  for 0s 1s and 2s
            if(arr[i]==0){
                countZ++;
            }else if(arr[i]==1){
                countO++;
            } else if (arr[i]==2) {
                countT++;
            }

            // update state after current index
            delta10=countO-countZ;
            delta21=countT-countO;
            key=delta21+"#"+delta10;

            // same state seen before → balanced subarray
            if(map.containsKey(key)){
                int idx=map.get(key);
                int len=i-idx;
                if(len>ans){
                    ans=len;
                }
            }
            //first time state seen
            else{
                map.put(key,i);
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
