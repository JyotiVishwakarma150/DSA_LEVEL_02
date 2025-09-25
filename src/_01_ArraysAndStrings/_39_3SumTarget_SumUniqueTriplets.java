package _01_ArraysAndStrings;
import java.util.*;
public class _39_3SumTarget_SumUniqueTriplets {
    public static List<List<Integer>> twoSum(int[] arr,int si,int ei,int target){
        int left=si;
        int right=ei;
        List<List<Integer>> res=new ArrayList<>();
        while(left<right){
            if(left!=si && arr[left]==arr[left-1]){
                left++;
                continue;
            }
            int sum=arr[left]+arr[right];
            if(sum==target){
                List<Integer> subres=new ArrayList<>();
                subres.add(arr[left]);
                subres.add(arr[right]);
                res.add(subres);
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
    // ~~~~~~~~~~~~User Section~~~~~~~~~~~~
    public static List<List<Integer>> threeSum(int[] arr, int target) {
        // write your code here
        List<List<Integer>> res=new ArrayList<>();
        int n=arr.length;
        if(n<3) return res;
        Arrays.sort(arr);
        for(int i=0;i<=n-3;i++){
            if(i!=0 && arr[i]==arr[i-1]) continue;
            int val1=arr[i];
            int targ=target-val1;
            List<List<Integer>> subRes=twoSum(arr,i,n-1,targ);
            /*
            /target = t-val1
            {
            {2,7},
            {3,9},
            {4,5};
            .
            .
            }
            //impact of val1 in these pairs, target = t
            {
            {2,7,val1},
            {3,9,val1},
            {4,5,val1},
            .
            .
            }
            */
            for(List<Integer> list:subRes){
                list.add(val1);
                res.add(list);
            }
        }
        return res;
    }

    // ~~~~~~~~~~Input Management~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        List<List<Integer>> res = threeSum(arr, target);
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
