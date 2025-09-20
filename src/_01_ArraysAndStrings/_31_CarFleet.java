package _01_ArraysAndStrings;
import java.util.*;
public class _31_CarFleet {
     public static int carFleet(int target,int[] position,int[] speed){
         int n=position.length;
         double[][] cardata=new double[n][2];
         //0th -> position
         //1st -> time
         for(int i=0;i<n;i++){
             cardata[i][0]=position[i]*1d;
             cardata[i][1]=((target-position[i]*1d)/speed[i]);
         }
         Arrays.sort(cardata,(a,b)->Double.compare(a[0],b[0]));
         int nof=1;
         double tt=cardata[n-1][1];
         for(int i=n-2;i>=0;i--){
             if(cardata[i][1]>tt){
                 nof++;
                 tt=cardata[i][1];
             }
         }
         return nof;
     }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int target=scn.nextInt();
        int n=scn.nextInt();
        int[] position = new int[n];
        int[] speed=new int[n];
        for(int i=0;i<n;i++){
            position[i]=scn.nextInt();
        }
        for(int i=0;i<n;i++){
            speed[i]= scn.nextInt();
        }
        int result = carFleet(target,position,speed);
        System.out.println(result);
    }
}
