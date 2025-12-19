package _02_HashmapAndHeap;
import java.util.*;
public class _26_WordPattern {
    // Check if given string follows the same pattern
    public static boolean wordPattern(String pattern, String str) {

        // string ko words array me tod diya
        String[] words = str.split(" ");

        // pattern char → word mapping
        HashMap<Character, String> map = new HashMap<>();

        // word already used hai ya nahi (uniqueness check)
        HashMap<String, Boolean> used = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i); // pattern ka character
            // agar pattern char pehli baar aaya
            if (map.containsKey(ch) == false) {
                // agar word pehle kisi aur char se map ho chuka hai
                if (used.containsKey(words[i]) == true) {
                    return false;
                } else {
                    // new valid mapping
                    used.put(words[i], true);
                    map.put(ch, words[i]);
                }
            }
            // agar pattern char pehle se mapped hai
            else {
                String mwith = map.get(ch);
                // mapping mismatch → false
                if (mwith.equals(words[i]) == false) {
                    return false;
                }
            }
        }
        return true; // all rules satisfied
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String pattern = scn.nextLine();
        String words = scn.nextLine();
        System.out.println(wordPattern(pattern,words));
    }
}
