package _02_HashmapAndHeap;
import java.util.*;
public class _14_EquivalentSubArrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        //k unique count
        HashSet<Integer> set=new HashSet<>();
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
            set.add(arr[i]);
        }
        int k=set.size();//size daal diya ...k unique elements ka
        int ans=0;
        int i=-1;
        int j=-1;
        //window frequencies store krege hashmap mein
        HashMap<Integer,Integer> map=new HashMap<>();
        while(true) {
            boolean f1 = false;// flag for acquire
            boolean f2 = false;// flag for release
            //acquire kro till...k distinct elements array mein nahi ho jate
            // ACQUIRE until window has all k distinct
            while(i<arr.length-1) {
                f1 = true;
                i++;
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                if(map.size()==k) {
                    ans += arr.length - i; // i se end tak sab valid
                    break;
                }
            }
            // RELEASE to shrink window from left
            while(j<i){
                f2=true;
                j++;
                if(map.get(arr[j])==1){
                    map.remove(arr[j]);//remove hi krdo frequency one hai to
                }else{
                    map.put(arr[j],map.get(arr[j]-1));//frequency reduce
                }
                if(map.size()==k){
                    ans+=arr.length-i;// still valid
                }else{
                    break;// window invalid ho gayi
                }
            }
            if(f1==false && f2==false){
                break;
            }
        }
        System.out.println(ans);
    }

}
