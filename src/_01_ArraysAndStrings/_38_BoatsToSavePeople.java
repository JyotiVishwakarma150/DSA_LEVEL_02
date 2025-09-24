package _01_ArraysAndStrings;
import java.util.*;
public class _38_BoatsToSavePeople {
    // ~~~~~~~~~~~User's Section~~~~~~~~~~~~
    public static int numRescueBoats(int[] people, int limit) {
        // write your code here
        int boatCount=0;
        Arrays.sort(people);
        int left=0;
        int right= people.length-1;
        int sum=0;
        while(left<=right){
            sum=people[left]+people[right];
            if(sum<=limit){
                boatCount++;
                left++;
                right--;
            }else{
                boatCount++;
                right--;
            }
        }
        return boatCount;
    }

    // ~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] people = new int[n];

        for (int i = 0; i < n; i++)
            people[i] = scn.nextInt();

        int limit = scn.nextInt();
        int boats = numRescueBoats(people, limit);
        System.out.println(boats);
    }
}
