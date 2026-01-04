package _02_HashmapAndHeap;
import java.util.*;
public class _56_InsertDeleteGetRandomO1Duplicate {
    static class RandomizedCollection {

        ArrayList<Integer> list;  // values store
        HashMap<Integer, HashSet<Integer>> map; // val -> set of indexes
        Random rand;

        public RandomizedCollection() {
            list = new ArrayList<>();
            map = new HashMap<>();
            rand = new Random();
        }

        // Insert value
        public boolean insert(int val) {
            boolean notPresent = !map.containsKey(val);

            map.putIfAbsent(val, new HashSet<>());
            map.get(val).add(list.size());
            list.add(val);

            return notPresent;
        }

        // Remove value
        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;

            // get any index of val
            int idx = map.get(val).iterator().next();

            int lastVal = list.get(list.size() - 1);

            // swap with last element
            list.set(idx, lastVal);

            // update index set of lastVal
            map.get(lastVal).add(idx);
            map.get(lastVal).remove(list.size() - 1);

            // remove index of val
            map.get(val).remove(idx);

            // remove last element
            list.remove(list.size() - 1);

            // if no index left, remove key
            if (map.get(val).isEmpty()) {
                map.remove(val);
            }

            return true;
        }

        // Get random element
        public int getRandom() {
            int idx = rand.nextInt(list.size());
            return list.get(idx);
        }
    }

    // ------------------ SIMPLE MAIN ------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RandomizedCollection rc = new RandomizedCollection();

        System.out.println("Commands:");
        System.out.println("1 x -> insert x");
        System.out.println("2 x -> remove x");
        System.out.println("3   -> getRandom");
        System.out.println("0   -> exit");

        while (true) {
            int cmd = sc.nextInt();

            if (cmd == 0) break;

            if (cmd == 1) {
                int x = sc.nextInt();
                System.out.println(rc.insert(x));
            } else if (cmd == 2) {
                int x = sc.nextInt();
                System.out.println(rc.remove(x));
            } else if (cmd == 3) {
                System.out.println(rc.getRandom());
            }
        }
        sc.close();
    }
}
