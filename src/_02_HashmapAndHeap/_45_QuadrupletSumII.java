package _02_HashmapAndHeap;
import java.util.*;
public class _45_QuadrupletSumII {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int count=0;
        for(int e1:A){
            for (int e2:B){
                map.put(e1+e2,map.getOrDefault(e1+e2,0)+1);
            }
        }
        int target=0;
        for(int e1:C){
            for(int e2:D){
                count += map.getOrDefault(target-(e1+e2),0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];
        int[] arr4 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr3[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr4[i] = sc.nextInt();
        }
        System.out.println(fourSumCount(arr1, arr2, arr3, arr4));
    }


}
