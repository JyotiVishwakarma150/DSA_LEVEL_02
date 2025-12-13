package _02_HashmapAndHeap;
import java.util.*;
public class _17_LongestSubStringAtmostKUniqueCharacters {
    public static int solution(String str, int k) {
        int ans=0;
        int i=-1;
        int j=-1;
        HashMap<Character,Integer> map=new HashMap<>();
        while(true){
            boolean f1=false;
            boolean f2=false;
            // Acquire: window expand
            while(i<str.length()-1){
                f1=true;
                i++;
                char ch=str.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.size()<=k){
                    int len=i-j;
                    if(len>ans){
                        ans=len;
                    }
                }else{// unique > k → stop acquire
                    break;
                }
            }
            // Release: window shrink
            while(j<i){
                f2=true;
                j++;
                char ch=str.charAt(j);
                // decrease or remove char
                if(map.get(ch)==1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
                if(map.size()>k){ // still invalid → keep shrinking
                    continue;
                }else{// valid again → update answer
                    int len=i-j;
                    if(len>ans){
                        ans=len;
                    }
                    break;
                }
            }
            // if no movement, break
            if(f1==false && f2==false){
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        System.out.println(solution(str,k));
    }
}
