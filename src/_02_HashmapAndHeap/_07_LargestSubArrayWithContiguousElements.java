package _02_HashmapAndHeap;
import java.util.*;
public class _07_LargestSubArrayWithContiguousElements {
    public static int solution(int[] arr) {
        int ans=0;
        for(int i=0;i<arr.length-1;i++){
            int min=arr[i];
            int max=arr[i];
            HashSet<Integer> cd= new HashSet<>();//cd->current duplicacy
            cd.add(arr[i]);
            for(int j=i+1;j<arr.length;j++){
                if(cd.contains(arr[j])){
                    break;
                }
                cd.add(arr[j]);
                min=Math.min(min,arr[j]);
                max=Math.max(max,arr[j]);
                if(max-min==j-i){
                    int len=j-i+1;
                    if(len>ans){
                        ans=len;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}
