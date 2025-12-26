package _02_HashmapAndHeap;
import java.util.*;
public class _41_TaskCompletion {
    public static void completeTask(int n, int m, int[] arr) {
        // already completed tasks ko store karne ke liye
        HashSet<Integer> set=new HashSet<>();
        for(int val:arr){
            set.add(val);
        }
        boolean flag=true;// turn decide karne ke liye
        ArrayList<Integer> one=new ArrayList<>();// person 1 ke tasks
        ArrayList<Integer> two=new ArrayList<>();// person 2 ke tasks

        // 1 se n tak saare tasks check karo
        for(int i=1;i<=n;i++){

            // agar task completed nahi hua
            if(set.contains(i)==false){
                if(flag){
                    one.add(i);// person 1 ko do
                }else{
                    two.add(i);// person 2 ko do
                }
                flag = !flag; // turn change
            }
        }
        // person 1 ke tasks print
        for(int val:one){
            System.out.print(val+"");
        }
        System.out.println();

        // person 2 ke tasks print
        for(int val:two){
            System.out.print(val+"");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[] num = new int[m];
        for (int i = 0; i < m; i++) {
            num[i] = scn.nextInt();
        }
        completeTask(n, m, num);
    }

}
