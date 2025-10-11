package _01_ArraysAndStrings;
import java.util.*;
import java.io.*;
public class _58_BulbSwitcherIV {
    public static int minFlips(String target){
        int future =0;
        int ans=0;
        for(int i=0;i<target.length();i++){
            if(future==target.charAt(i)-'0'){
                continue;
            }
            ans++;
            future=future==1?0:1;

        }
        return ans;
    }
    public static void main(String[] args) {
     Scanner scn =new Scanner(System.in);
     String str=scn.next();
     int ans=minFlips(str);
        System.out.println(ans);
    }
}
