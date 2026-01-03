package _02_HashmapAndHeap;
import java.util.*;
public class _57_RandomPickWithBlacklist {
    static HashMap<Integer, Integer> map;
    static Random r;
    static int top;
    public static void solution(int n,int[] blacklist){
        map = new HashMap<>();
        r = new Random();
        top = n - blacklist.length;
        HashSet<Integer> set = new HashSet<>();
        // blacklist ko set mein daal diya
        for (int i = 0; i < blacklist.length; i++) {
            set.add(blacklist[i]);
        }
        n--;  // last index se mapping start karne ke liye
        for (int i = 0; i < blacklist.length; i++) {
            // sirf chhote blacklist numbers ke liye mapping
            if (blacklist[i] < top) {
                // jab tak n blacklist mein hai peeche jao
                while (set.contains(n)) {
                    n--;
                }
                // blacklist -> valid number mapping
                map.put(blacklist[i], n);
                n--;
            }
        }
    }
    // pick function
    static int pick() {
        int randIdx = r.nextInt(top); // 0 to top-1
        if (map.containsKey(randIdx)) {
            return map.get(randIdx);
        }
        return randIdx;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.print("Enter blacklist size: ");
        int m = sc.nextInt();
        int[] blacklist = new int[m];
        System.out.println("Enter blacklist elements:");
        for (int i = 0; i < m; i++) {
            blacklist[i] = sc.nextInt();
        }
        solution(n, blacklist);

        System.out.print("How many random picks? ");
        int k = sc.nextInt();

        System.out.println("Random picks:");
        for (int i = 0; i < k; i++) {
            System.out.println(pick());
        }

        sc.close();
    }
}
