package _02_HashmapAndHeap;
import java.util.*;
public class _59_PairsOfNonCoincidingPoints {
    public static int solution(int m,int[] x,int[] y){
        // x -> frequency
        HashMap<Integer,Integer> xmap = new HashMap<>();

        // y -> frequency
        HashMap<Integer,Integer> ymap = new HashMap<>();

        // "x*y" -> frequency of exact same point
        HashMap<String,Integer> xymap = new HashMap<>();

        int total = 0;        // total pairs till now
        int coinciding = 0;   // bad pairs

        for(int i = 0; i < m; i++){

            int X = x[i];
            int Y = y[i];
            String XY = X + "*" + Y;

            // previous frequencies
            int xfre = xmap.getOrDefault(X, 0);
            int yfre = ymap.getOrDefault(Y, 0);
            int xyfre = xymap.getOrDefault(XY, 0);

            // count coinciding pairs formed with current point
            coinciding += xfre + yfre - xyfre;

            // total pairs formed with current point
            total += i;

            // update maps
            xmap.put(X, xfre + 1);
            ymap.put(Y, yfre + 1);
            xymap.put(XY, xyfre + 1);
        }

        // non-coinciding = total - coinciding
        return total - coinciding;
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int m= scn.nextInt();
        int[] x=new int[m];
        int[] y=new int[m];
        for(int i=0;i<m;i++){
            x[i]=scn.nextInt();
            y[i]=scn.nextInt();
        }
        System.out.println(solution(m,x,y));
    }
}
