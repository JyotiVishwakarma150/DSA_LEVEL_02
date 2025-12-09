package _02_HashmapAndHeap;
import java.util.*;
//smallest substring of a string containing all unique characters of itself
public class _09_MinimumWindowSubStringII {
    public static int solution(String str){
        int len=str.length();// final minimum length answer
        // Step 1: Find all unique characters of string
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            set.add(ch);
        }
        // Sliding window pointers
        int i=-1; // acquire pointer
        int j=-1;//release pointer

        // Map for frequency of current window chars
        HashMap<Character,Integer> map=new HashMap<>();
        while(true){
             boolean f1=false;// flag for acquire
             boolean f2=false;// flag for release

             //acquire till it is invalid(map.size()<set.size())
            while(i<str.length()-1 && map.size()<set.size()){
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch,0)+1);
                f1=true;
            }
            //collect and release
            while(j<i && map.size()==set.size()){
                // Window length = i - j
                int plen=i-j;//plen-> potential answer ki length
                if(plen<len){
                    len=plen;// update minimum length
                }
                j++;
                char ch=str.charAt(j);
                //remove char from map
                if(map.get(ch)==1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
                f2=true;
            }
            // jab kuch change hi na ho -> break
            if(f1==false && f2==false){
                break;
            }
        }
        return len;// final minimum window length
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}
