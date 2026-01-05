package _02_HashmapAndHeap;
import java.util.*;
public class _63_TrickySortingCost {
    // Function to calculate minimum sorting cost
    public static int sortingCost(int N,int[] arr){
        // map: number -> length of consecutive sequence ending at that number
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxss=1;// stores longest consecutive subsequence length
        for(int n:arr){
            // agar n-1 already exist karta hai
            // to sequence extend hogi
            if(map.containsKey(n-1)){
                int len=map.get(n-1);
                map.put(n,len+1);
                maxss=Math.max(maxss,len+1);

            }
            // warna new sequence start
            else{
                map.put(n,1);
            }
        }
        // minimum removals = total elements - longest sequence
        return N-maxss;
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int N=scn.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]= scn.nextInt();
        }
        System.out.println(sortingCost(N,arr));
    }

}
