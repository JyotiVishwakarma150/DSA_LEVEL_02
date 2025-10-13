package _01_ArraysAndStrings;
import java.util.*;
import java.util.HashMap;

public class _60_SnapshotArray {
    int sid=0;
    HashMap<Integer,Integer>[] map;
    public void SnapshotArray(int length){
        map=new HashMap[length];
        for(int i=0;i<length;i++){
            map[i]=new HashMap<>();
        }
    }
    public void set(int index,int val){
        map[index].put(sid,val);
    }
    public int snap(){
        sid++;
        return sid-1;
    }
    public int get(int index,int snap_id){
        while(snap_id>=0 && !map[index].containsKey(snap_id))
            snap_id--;
        if(snap_id==-1){
            return 0;
        }
        return map[index].get(snap_id);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length of SnapshotArray: ");
        int length = sc.nextInt();

        _60_SnapshotArray obj = new _60_SnapshotArray();
        obj.SnapshotArray(length);

        System.out.println("\nEnter number of operations:");
        int q = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Operations: set index val | snap | get index snap_id");

        for (int i = 0; i < q; i++) {
            String[] parts = sc.nextLine().split(" ");
            String op = parts[0];

            if (op.equals("set")) {
                int index = Integer.parseInt(parts[1]);
                int val = Integer.parseInt(parts[2]);
                obj.set(index, val);
                System.out.println("Set done.");
            } else if (op.equals("snap")) {
                int id = obj.snap();
                System.out.println("Snap taken with id: " + id);
            } else if (op.equals("get")) {
                int index = Integer.parseInt(parts[1]);
                int snap_id = Integer.parseInt(parts[2]);
                System.out.println("Value = " + obj.get(index, snap_id));
            } else {
                System.out.println("Invalid operation!");
            }
        }

        sc.close();
    }
}
