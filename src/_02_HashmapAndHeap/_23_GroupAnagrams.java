package _02_HashmapAndHeap;
import java.lang.reflect.Array;
import java.util.*;
public class _23_GroupAnagrams {
    // Function to group anagram strings
    public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
        // Outer map:
        // key   -> frequency map of a string
        // value -> list of strings having same frequency map
        HashMap<HashMap<Character,Integer>,ArrayList<String>> bmap=new HashMap<>();
        // Traverse each string
        for(String str:strs){
            // Frequency map for current string
           HashMap<Character,Integer> fmap=new HashMap<>();
            // Build character frequency
           for(int i=0;i<str.length();i++){
               char ch=str.charAt(i);
               fmap.put(ch, fmap.getOrDefault(ch,0)+1);
           }
            // If this frequency pattern is new
           if(bmap.containsKey(fmap)==false){
               ArrayList<String> list=new ArrayList<>();
               list.add(str);// add first string
               bmap.put(fmap,list);// store new group
               // If same frequency pattern already exists
           }else{
               ArrayList<String> list=bmap.get(fmap);// add to existing group
               list.add(str);
           }
        }
        // Convert map values to result list
        ArrayList<ArrayList<String>> res=new ArrayList<>();
        for(ArrayList<String> val:bmap.values()){
            res.add(val);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }
        // Group anagrams
        ArrayList<ArrayList<String>> anagramsGrouped = groupAnagrams(arr);
        for (ArrayList<String> lst : anagramsGrouped) {
            Collections.sort(lst);
        }
        // Sort groups:
        // 1) Bigger group first
        // 2) If same size, compare first string
        anagramsGrouped.sort(new ListComparator());
        // Print result
        display(anagramsGrouped);
    }

    // it is used to make the result unique
    static class ListComparator implements Comparator<List<String>> {
        @Override
        public int compare(List<String> l1, List<String> l2) {
            if (l1.size() != l2.size()) {
                return l2.size() - l1.size();
            }

            String l1str = l1.get(0);
            String l2str = l2.get(0);
            return l1str.compareTo(l2str);

        }
    }

    public static void display(ArrayList<ArrayList<String>> list) {
        for (int i = 0; i < list.size(); i++) {
            ArrayList<String> currList = list.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }
    }


}
