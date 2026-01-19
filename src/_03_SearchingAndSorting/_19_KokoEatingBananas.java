package _03_SearchingAndSorting;
import java.util.*;
public class _19_KokoEatingBananas {
    // check karta hai ki given speed sp par Koko h hours ke andar sab bananas kha paayegi ya nahi
    public static boolean isPossible(int[] piles,int h,int sp){
        int time=0;
        // har pile ke liye required hours add karo
        for(int i=0;i<piles.length;i++){
            // ceil isliye kyunki adha hour possible nahi hota
            time+=(int)Math.ceil(piles[i]*1.0/sp);
        }
        // agar total time h se kam ya barabar hai
        return time<=h;
    }
    public static int minEatingSpeed(int[]piles,int h) {
        // maximum pile find kar rahe hain (upper bound of speed)
      int max=Integer.MIN_VALUE;
      for(int val:piles){
          max=Math.max(val,max);
      }
        // agar hours = piles count
        // to har ghante ek poora pile khana padega
      if(h==piles.length){
          return max;
      }
      int lo=0;// minimum speed possible
      int hi=max;// maximum speed possible
      int speed=Integer.MAX_VALUE;
        // Binary Search on speed
      while(lo<=hi){
          int sp=lo+(hi-lo)/2;//to avoid overflow
          if(isPossible(piles,h,sp)==true){
              speed=sp;// answer mil sakta hai
              hi=sp-1;// aur chhoti speed try karo
          }else{
              lo=sp+1;// speed slow hai, badhani padegi
          }
      }
      return speed;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]piles = new int[n];

        for(int i=0 ; i < n ; i++) {
            piles[i] = scn.nextInt();
        }

        int h = scn.nextInt();

        int speed = minEatingSpeed(piles,h);
        System.out.println(speed);
    }
}
