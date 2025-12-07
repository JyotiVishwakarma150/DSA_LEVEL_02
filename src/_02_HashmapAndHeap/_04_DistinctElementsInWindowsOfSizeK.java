package _02_HashmapAndHeap;
import java.util.*;
public class _04_DistinctElementsInWindowsOfSizeK {
//    public static ArrayList<Integer> solution(int[] arr, int k) {
//        ArrayList<Integer> ans = new ArrayList<>();
//        HashMap<Integer, Integer> map = new HashMap<>();
//     // FIRST WINDOW
//        for(int i = 0; i < k; i++){
//            int val = arr[i];
//            map.put(val, map.getOrDefault(val, 0) + 1);
//        }
//     // First window ka distinct count add
//        ans.add(map.size());
//     // SLIDE THE WINDOW
//        for(int i = k; i < arr.length; i++){
//     // Remove left element (i - k index)
//            int left = arr[i - k];
//            map.put(left, map.get(left) - 1);
//            if(map.get(left) == 0){
//                map.remove(left);
//            }
//          // Add right element (i index)
//            int right = arr[i];
//            map.put(right, map.getOrDefault(right, 0) + 1);
//     // Current window ka distinct count
//            ans.add(map.size());
//        }
//     return ans;
//    }

    public static ArrayList<Integer> solution(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        //Pehle window ke (k-1) elements acquire krlege
       int i=0;
       while(i<=k-2){
           map.put(arr[i],map.getOrDefault(arr[i],0)+1);
           i++;
       }
        // i ab k-1 se ek piche hai → isliye i--
       i--;
        // j release pointer hoga
       int j=1;
       //Ab sliding window chalayenge
       while(i<arr.length-1){
           // Acquire → window ka last element add kara
           i++;
           map.put(arr[i],map.getOrDefault(arr[i],0)+1);//acquire kr liya
           list.add(map.size());//work
           //release
           // Work → kitne unique elements hain store kara
           j++;
           int freq=map.get(arr[j]); // j-1 actual release index
           if(freq==1){
               map.remove(arr[j]);// last copy thi → remove
           }else{
               map.put(arr[j],freq-1);// freq kam karo
           }
       }
       return list;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        ArrayList<Integer> ans = solution(arr, k);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }
}
