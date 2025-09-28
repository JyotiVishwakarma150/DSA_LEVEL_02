package _01_ArraysAndStrings;
import java.lang.reflect.Array;
import java.util.*;
public class _41_KSum_SumUniqueSet {
    //2-sum function (two pointers)
    public static List<List<Integer>> twoSum(int[] arr, int target,int si) {
        // write your code here
        int n=arr.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n-si<2) return res;
        int left = si;
        int right = n - 1;
        while (left < right) {
            if (left!=si && arr[left]==arr[left-1]){
                left++;
                continue;
            }
            int sum=arr[left]+arr[right];
            if(sum==target){
                //pair found
                List<Integer> Subres = new ArrayList<>();
                Subres.add(arr[left]);
                Subres.add(arr[right]);
                res.add(Subres);
                left++;
                right--;
            }else if(sum>target){
                right--;
            }else{
                left++;
            }
        }
        return res;
    }
    public static List<List<Integer>> kSumHelper(int[] arr, int target, int k,int si) {
        // write your code here
        if(k==2){//base case...reduce to 2-sum
            return twoSum(arr,target,si);
        }
        int n=arr.length;
        List<List<Integer>> res=new ArrayList<>();
        //not enough elements
        if(n-si<k){
            return res;
        }
        for(int i=si;i<=n-k;i++){
            if(i!=si && arr[i]==arr[i-1]) continue;//skip duplicates
            int val1=arr[i];
            //recursion for k-1 sum
            List<List<Integer>> subRes=kSumHelper(arr,target-val1,k-1,i+1);
            //add current val to sub-results
            for(List<Integer> list:subRes){
                list.add(val1);
                res.add(list);
            }
        }
        return res;
    }
    //ksum main...
    public static List<List<Integer>> kSum(int[] arr,int target,int k){
        Arrays.sort(arr);//sort the array firstly
        return kSumHelper(arr,target,k,0);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        int k = scn.nextInt();
        List<List<Integer>> res = kSum(arr, target, k);
        ArrayList<String> finalResult = new ArrayList<>();
        for (List<Integer> list : res) {
            Collections.sort(list);
            String ans = "";
            for (int val : list) {
                ans += val + " ";
            }
            finalResult.add(ans);
        }
        Collections.sort(finalResult);
        for (String str : finalResult) {
            System.out.println(str);
        }
    }

}
