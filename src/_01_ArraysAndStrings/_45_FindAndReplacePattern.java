package _01_ArraysAndStrings;
import java.util.*;
public class _45_FindAndReplacePattern {
    // ~~~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~
    public static boolean isMatching(String word,String pattern){
        HashMap<Character,Character> map=new HashMap<>();
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<pattern.length();i++){
            char  wch=word.charAt(i);
            char pch=pattern.charAt(i);
            if(map.containsKey(pch)==true) {
                //pattern character is already mapped
                if (map.get(pch) != wch)
                    return false;
            }
                else{
                    //pattern character is new for mapping
                    if(set.contains(wch))
                        return false;
                    map.put(pch,wch);
                    set.add(wch);
            }

        }
        return true;
    }
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        // write your code here
        List<String> res=new ArrayList<>();
        for(String word:words){
            if(isMatching(word,pattern)){
                res.add(word);
            }
        }
        return res;
    }

    // ~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String pattern = scn.nextLine();
        int n = scn.nextInt();
        scn.nextLine(); // to consume enter after number
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scn.nextLine();
        }
        List<String> res = findAndReplacePattern(words, pattern);
        if (res.size() == 0) {
            System.out.println("Empty");
            return;
        }
        Collections.sort(res);
        for (String str : res) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}
