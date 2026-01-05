package _02_HashmapAndHeap;
import java.util.*;
public class _62_MinimumCostToConnectSticks {
    public static int connectSticks(int[] sticks) {
       // Min Heap to always get smallest sticks first
       PriorityQueue<Integer> pq=new PriorityQueue<>();

        // Add all sticks to priority queue
       for(int stick:sticks){
           pq.add(stick);
       }
       int cost=0;// current merge cost
       int count=0;// total minimum cost

        // Jab tak ek se zyada stick bachi ho
       while(pq.size()>1){
           // 1st smallest stick
           int x=pq.poll();
           // 2nd smallest stick
           int y=pq.poll();
           // Cost to connect them
           cost = x+y;
           // Add to total cost
           count+=cost;
           // New stick ko wapas heap me daal do
           pq.add(cost);
       }
       return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] sticks = new int[n];
        for (int i = 0; i < sticks.length; i++) {
            sticks[i] = scn.nextInt();
        }

        System.out.println(connectSticks(sticks));
    }

}
