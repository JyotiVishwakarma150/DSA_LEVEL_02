package _02_HashmapAndHeap;
import java.util.*;
public class _25_IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        // map1: s ke character → t ke character mapping
        HashMap<Character,Character> map1=new HashMap<>();
        // map2: t ke characters already used hain ya nahi (uniqueness check)
        HashMap<Character,Boolean>  map2=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);// character from s
            char ch2=t.charAt(i);// character from t
            // agar ch1 pehle se mapped hai
            if(map1.containsKey(ch1)==true){
                // mapping same nahi hai → not isomorphic
                if(map1.get(ch1)!=ch2){
                    return false;
                }
            }
            // agar ch1 pehli baar aaya
            else{
                // agar ch2 already kisi aur se map ho chuka hai
                if(map2.containsKey(ch2)==true){
                    return false;
                }else{
                    // new valid mapping
                    map1.put(ch1,ch2);
                    map2.put(ch2,true);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String A = scn.next();
        String B = scn.next();
        System.out.print(isIsomorphic(A, B));
    }

}
