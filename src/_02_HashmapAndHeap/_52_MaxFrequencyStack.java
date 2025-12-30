package _02_HashmapAndHeap;
import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class _52_MaxFrequencyStack {
    // frequency -> stack of values
    HashMap<Integer, LinkedList<Integer>> st = new HashMap<>();

    // value -> frequency
    HashMap<Integer, Integer> fmap = new HashMap<>();

    int maxfreq = 0;

    // push operation
    public void push(int val) {

        // value ki frequency nikalo
        int cfreq = fmap.getOrDefault(val, 0) + 1;
        fmap.put(val, cfreq);

        // agar is freq ka stack nahi hai to banao
        st.putIfAbsent(cfreq, new LinkedList<>());

        // stack ke top par value add karo
        st.get(cfreq).addFirst(val);

        // max frequency update
        maxfreq = Math.max(maxfreq, cfreq);
    }

    // pop operation
    public int pop() {

        // max frequency wale stack se pop
        int ans = st.get(maxfreq).removeFirst();

        // frequency decrease
        fmap.put(ans, fmap.get(ans) - 1);

        // agar stack empty ho gaya
        if (st.get(maxfreq).isEmpty()) {
            maxfreq--;
        }

        return ans;
    }

    // main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        _52_MaxFrequencyStack fs = new _52_MaxFrequencyStack();

        System.out.println("Enter number of operations:");
        int n = sc.nextInt();

        System.out.println("0 -> constructor");
        System.out.println("1 x -> push(x)");
        System.out.println("2 -> pop()");

        for (int i = 0; i < n; i++) {

            int type = sc.nextInt();

            if (type == 0) {
                System.out.println("null");
            }
            else if (type == 1) {
                int x = sc.nextInt();
                fs.push(x);
                System.out.println("null");
            }
            else if (type == 2) {
                System.out.println(fs.pop());
            }
        }
        sc.close();
    }
}
