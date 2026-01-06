package _03_SearchingAndSorting;
import java.util.*;
public class _02_UnionOfTwoSortedArrays {
    /*You have to complete union function and return an Arraylist which contains union elements of the two arrays*/
    public static ArrayList<Integer> union(int[] a, int[] b) {

        // Result list banayi
        ArrayList<Integer> list = new ArrayList<>();

        // Dono arrays ke pointers
        int i = 0;
        int j = 0;

        // Jab tak dono arrays me elements hain
        while (i < a.length && j < b.length) {

            // Case 1: dono elements equal hain
            if (a[i] == b[j]) {

                // Duplicate avoid karne ke liye last element check
                if (list.size() > 0 && list.get(list.size() - 1) != a[i]) {
                    list.add(a[i]);
                }
                // Agar list empty hai
                else if (list.size() == 0) {
                    list.add(a[i]);
                }

                // Dono pointers aage badhao
                i++;
                j++;
            }

            // Case 2: a[i] chhota hai b[j] se
            else if (a[i] < b[j]) {

                // Duplicate check
                if (list.size() > 0 && list.get(list.size() - 1) != a[i]) {
                    list.add(a[i]);
                }
                // Agar list empty ho
                else if (list.size() == 0) {
                    list.add(a[i]);
                }

                i++; // sirf i aage
            }

            // Case 3: b[j] chhota hai a[i] se
            else {

                // Duplicate check
                if (list.size() > 0 && list.get(list.size() - 1) != b[j]) {
                    list.add(b[j]);
                }
                // Agar list empty ho
                else if (list.size() == 0) {
                    list.add(b[j]);
                }

                j++; // sirf j aage
            }
        }

        // Agar array a me elements bache ho
        while (i < a.length) {
            if (list.get(list.size() - 1) != a[i]) {
                list.add(a[i]);
            }
            i++;
        }

        // Agar array b me elements bache ho
        while (j < b.length) {
            if (list.get(list.size() - 1) != b[j]) {
                list.add(b[j]);
            }
            j++;
        }

        // Final union list return
        return list;
    }
    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]a = new int[n];
        for(int i=0; i < n;i++) {
            a[i] = scn.nextInt();
        }

        int m = scn.nextInt();
        int[]b = new int[m];
        for(int i=0;i < m;i++) {
            b[i] = scn.nextInt();
        }

        ArrayList<Integer>ans = union(a,b);

        //print answer list
        for(int val : ans) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
