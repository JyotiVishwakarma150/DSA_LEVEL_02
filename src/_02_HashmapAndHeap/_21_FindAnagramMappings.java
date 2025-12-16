package _02_HashmapAndHeap;
import java.util.*;
public class _21_FindAnagramMappings {
    // Pair class: ek value ke multiple indices handle karne ke liye
    public static class Pair{
        int idx=0;// kaunsa index use ho chuka
        ArrayList<Integer> list= new ArrayList<>();// saare indices
    }
    public static int[] anagramMappings(int[] arr1, int[] arr2) {
        // value -> (indices + pointer)
       HashMap<Integer,Pair> map=new HashMap<>();
        // arr2 se mapping banana
       for(int i=0;i< arr2.length;i++){
           if(map.containsKey(arr2[i])){
               Pair p=map.get(arr2[i]); // existing value, new index add
               p.list.add(i);

           }else{
               Pair p=new Pair(); // new value
               p.list.add(i);
               map.put(arr2[i],p);
           }
       }
        int[] ans=new int[arr1.length];
        // arr1 ke liye mapping nikaalna
        for(int i=0;i<arr1.length;i++){
            Pair p=map.get(arr1[i]);// value ka pair
            ans[i]=p.list.get(p.idx); // next available index
            p.idx++;// pointer aage badhao
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextInt();
        }
        for (int j = 0; j < b.length; j++) {
            b[j] = s.nextInt();
        }
        int[] res = anagramMappings(a, b);
        for (int j = 0; j < res.length; j++) {
            System.out.print(res[j] + " ");
        }
    }

}
