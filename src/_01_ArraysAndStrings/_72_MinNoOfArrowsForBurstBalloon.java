package _01_ArraysAndStrings;
import java.util.Arrays;
import java.util.Scanner;
public class _72_MinNoOfArrowsForBurstBalloon {
    public static int minArrows(int coordinates[][]) {
        // write your code here
        // Sort balloons by their END point
        // (End par arrow maarne se max balloons cover hote hain)
        Arrays.sort(coordinates,(a,b)->Integer.compare(a[1],b[1]));
        int end=coordinates[0][1];// first balloon ka end
        int arrow=1;// first arrow lag hi jayega
        for(int i=0;i< coordinates.length;i++){
            // Agar next balloon overlap nahi karega
            // i.e., iska start > last arrow point
            if(coordinates[i][0]>end){
                arrow++;// new arrow chahiye
                end=coordinates[i][1];// arrow ko new end pr set karo
            }
        }
        return arrow;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // number of balloons
        int coordinates[][] = new int[n][2];
        for (int i = 0 ; i < n ; i++) {
            coordinates[i][0] = scn.nextInt();
            coordinates[i][1] = scn.nextInt();
        }

        System.out.println(minArrows(coordinates));
    }

}
