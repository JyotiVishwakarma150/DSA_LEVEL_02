package _02_HashmapAndHeap;
import java.util.*;
public class _61_LongestSubstringAtmostTwoDistinctCharacters {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        // char -> frequency in current window
      HashMap<Character,Integer> count=new HashMap<>();
      int dis=0;// kitne distinct characters hain
      int start=0;// sliding window ka start
      int ans=0;// maximum length answer

        // window ka end move kar rahe hain
      for(int i=0;i<s.length();i++){
          int fre=count.getOrDefault(s.charAt(i),0);
          // naya character mila
          if(fre==0) dis++;
          count.put(s.charAt(i),fre+1);

          // jab distinct > 2 ho jaye → window shrink
          while(dis>2){
              fre=count.get(s.charAt(start));
              count.put(s.charAt(start),fre-1);

              // character completely remove ho gaya
              if(fre-1 == 0) dis--;
              start++;
          }
          // valid window ka max length
          ans=Math.max(ans,i-start+1);

      }
      return ans;
    }

    public static void main(String[] args) throws java.lang.Exception {

        Scanner scn = new Scanner(System.in);

        int ans = lengthOfLongestSubstringTwoDistinct(scn.nextLine());
        System.out.println(ans);
    }
}
