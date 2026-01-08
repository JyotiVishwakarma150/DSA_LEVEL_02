package _03_SearchingAndSorting;
import java.util.*;
public class _05_FindPivotIndex {
    public static int pivot_index(int[]arr) {
        int lsum=0;//leftsum
        int sum=0;//overall sum
        int rsum=0;//right sum
        // Step 1: total sum calculate karo
        for(int i=0;i< arr.length;i++){
              sum += arr[i];
        }
        rsum=sum;// initially right sum = total sum

        // Step 2: har index ko pivot maan kar check karo
        for(int i=0;i<arr.length;i++){
            // current element ko right side se hata do
            rsum=rsum-arr[i];

            // agar left sum == right sum → pivot mil gaya
            if(lsum==rsum) return i;

            // current element ko left sum me add karo
            lsum+=arr[i];
        }
        // agar koi pivot na mile
        return -1;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < arr.length;i++) {
            arr[i] = scn.nextInt();
        }

        int pi = pivot_index(arr);
        System.out.println(pi);
    }
}
