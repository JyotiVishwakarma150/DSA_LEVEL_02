package _02_HashmapAndHeap;
import java.util.*;
public class _20_KAnagrams {
    public static boolean areKAnagrams(String str1, String str2, int k) {
        // Length different → K-Anagram possible hi nahi
        if(str1.length() != str2.length()){
            return false;
        }
        // str1 ke characters ka frequency map
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i< str1.length();i++){
            char ch=str1.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        // str2 ke matching characters ka count minus
        for(int i=0;i<str2.length();i++){
            char ch=str2.charAt(i);
            if(map.getOrDefault(ch,0)>0){
                map.put(ch, map.get(ch)-1);
            }
        }
        // Jo count bacha → utne characters replace karne padenge
        int count=0;
        for(char ch:map.keySet()){
            count += map.get(ch);
        }
        // Required changes <= k ? true:false
        if(count>k){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str1 = s.next();
        String str2 = s.next();
        int k = s.nextInt();
        System.out.println(areKAnagrams(str1, str2, k));

    }

}
