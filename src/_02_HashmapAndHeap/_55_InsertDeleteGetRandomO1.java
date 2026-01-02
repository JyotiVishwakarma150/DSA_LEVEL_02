package _02_HashmapAndHeap;
import java.util.*;
import java.util.*;

public class _55_InsertDeleteGetRandomO1 {

    // value -> index (for O(1) search)
    HashMap<Integer, Integer> map;

    // store values for O(1) random access
    ArrayList<Integer> list;

    Random rand;

    // Constructor (name same as class)
    public _55_InsertDeleteGetRandomO1() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    // Insert operation
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    // Remove operation
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        int idx = map.get(val);
        int lastVal = list.get(list.size() - 1);

        // swap with last element
        list.set(idx, lastVal);
        map.put(lastVal, idx);

        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    // Get random element
    public int getRandom() {
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }

    // Driver code
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        _55_InsertDeleteGetRandomO1 rs = new _55_InsertDeleteGetRandomO1();

        System.out.println("1 -> Insert");
        System.out.println("2 -> Remove");
        System.out.println("3 -> GetRandom");
        System.out.println("0 -> Exit");

        while (true) {
            System.out.print("\nEnter choice: ");
            int choice = sc.nextInt();

            if (choice == 0)
                break;

            switch (choice) {

                case 1:
                    System.out.print("Enter value to insert: ");
                    int ins = sc.nextInt();
                    System.out.println(rs.insert(ins));
                    break;

                case 2:
                    System.out.print("Enter value to remove: ");
                    int rem = sc.nextInt();
                    System.out.println(rs.remove(rem));
                    break;

                case 3:
                    System.out.println("Random value: " + rs.getRandom());
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}

