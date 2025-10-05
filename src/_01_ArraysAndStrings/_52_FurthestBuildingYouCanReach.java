package _01_ArraysAndStrings;
import java.util.*;
public class _52_FurthestBuildingYouCanReach {
    public  static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<heights.length;i++){
            int diff=heights[i+1]-heights[i];
            if(diff>0){
                pq.add(diff);
            }
            if(pq.size()>ladders){
                bricks -= pq.poll();
            }
            if(bricks<0){
                return i;
            }
        }
        return heights.length-1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr = new int[n];

        // Array ke elements input lo
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int bricks= scn.nextInt();
        int ladders=scn.nextInt();
        int res = furthestBuilding(arr,bricks,ladders);
        System.out.println(res);
    }
}
