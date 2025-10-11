package _01_ArraysAndStrings;
import java.util.*;
import java.util.HashMap;

public class _57_ReorganizeString {
public  static class pair{
    char ch;
    int f;
    public pair(char ch,int f){
        this.ch=ch;
        this.f=f;
    }
}
public static String reorganizeString(String s){
    int[] map=new int[26];
    for(int i=0;i<s.length();i++) {
        map[s.charAt(i) - 'a']++;
    }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)-> b.f-a.f);
        for(int i=0;i<26;i++){
            if(map[i]>0){
                pq.add(new pair((char)('a'+i),map[i]));
            }
        }
        StringBuilder ans=new StringBuilder();
        pair block = pq.poll();
        ans.append(block.ch);
        block.f--;
        while(pq.size()>0){
            pair temp = pq.poll();
            ans.append(temp.ch);
            temp.f--;
            if(block.f>0){
                pq.add(block);
            }
            block=temp;
        }
        if(block.f>0){
            return "";
        }
        return ans.toString();
    }
    public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
       String s=scn.next();
       String result=reorganizeString(s);
       if(result.equals(""))
           System.out.println("Not possible to reorganize");
       else
           System.out.println("Reorganize String: "+result);
    }
}

