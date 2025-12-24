package _02_HashmapAndHeap;
import java.util.*;
public class _37_RabbitsInTheForest {
    public static int solution(int[] arr) {
        // map -> key = answer value, value = count of rabbits
        HashMap<Integer,Integer> map=new HashMap<>();

        // count frequency of each reported number
        for(int val:arr){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        int ans=0;

        // iterate over each unique answer
        for(int key:map.keySet()){
            int gs=key+1;// group size (same color rabbits)
            int reportees=map.get(key);// kitne rabbits ne ye answer diya
            // kitne groups chahiye (ceil because partial group allowed nahi)
            int ng=(int)Math.ceil(reportees*1.0/gs*1.0);
            // total rabbits add karo
            ans+=ng*gs;
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
        System.out.println(solution(arr));
    }
}
