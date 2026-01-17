package _03_SearchingAndSorting;
import java.util.*;
public class _17_MedianOfTwoSortedArray {
    public static double find(int[]a1,int[]a2) {
        // merged array size
        int[] merge=new int[a1.length+ a2.length];
        int i=0;
        int j=0;
        int k=0;
        // merge two sorted arrays
        while(i<a1.length&&j<a2.length){
            if(a1[i]<a2[j]){
                merge[k]=a1[i];
                i++;
                k++;
            }else{
                merge[k]=a2[j];
                j++;
                k++;
            }
        }
        // copy remaining elements of a1
        while(i<a1.length){
            merge[k]=a1[i];
            i++;
            k++;
        }
        // copy remaining elements of a2
        while(j<a2.length){
            merge[k]=a2[j];
            j++;
            k++;
        }
        double median=0.0;
        int mid= merge.length/2;
        // if total elements are odd
        if(merge.length%2==1){
            median=merge[mid];
        }
        // if total elements are even
        else{
            median=(merge[mid]+merge[mid-1])/2.0;
        }
        return median;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);

        //input work
        int n1 = scn.nextInt();
        int[]a = new int[n1];

        for(int i=0;i < n1;i++){
            a[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[]b = new int[n2];

        for(int i=0; i < n2;i++) {
            b[i] = scn.nextInt();
        }

        double median = find(a,b);
        System.out.println(median);
    }
}
