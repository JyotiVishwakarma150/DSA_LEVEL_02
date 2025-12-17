package _02_HashmapAndHeap;
import java.util.*;
public class _22_ValidAnagrams {
    public static boolean solution(String s1, String s2){
        // write your code here
        // Map to store frequency of characters of s1
        HashMap<Character,Integer> map=new HashMap<>();
        // Count frequency of each character in s1
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        // Traverse s2 and reduce frequency
        for(int i=0;i<s2.length();i++){
            char ch=s2.charAt(i);
            // Character not present → not anagram
            if(map.containsKey(ch)==false){
                return false;
            }
            // Frequency becomes zero → remove character
            else if (map.get(ch)==1) {
                map.remove(ch);
            }
            // Decrease frequency
            else{
                map.put(ch,map.get(ch)-1);
            }
        }
        // If map empty → all characters matched
        return map.size()==0;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1,s2));
    }
}
