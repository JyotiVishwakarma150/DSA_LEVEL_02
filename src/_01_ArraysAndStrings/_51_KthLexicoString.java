package _01_ArraysAndStrings;
import java.util.*;
public class _51_KthLexicoString {
   public static String getHappyString(int n,int k){
       int tot=3;
       for(int i=1;i<n;i++){
           tot=tot*2;
       }
       if(tot<k){
           return "";
       }int calls=3;
       k--;
       int pcall=-1;
       StringBuilder sb=new StringBuilder();
       while(n-->0){
           int spart=(tot/calls);
           int ncall=(k/spart);
           if(ncall==0){
               if(pcall==0){
                   ncall=1;
               }else{
                   ncall=0;
               }
           }else if(ncall==1){
               if(pcall==-1 || pcall==2){
                   ncall=1;
               }else{
                   ncall=2;
               }
           }else{
               ncall=2;
           }
           sb.append((char)('a'+ncall));
           tot=spart;
           pcall=ncall;
       }
       return sb.toString();
   }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int k=scn.nextInt();
        System.out.println(getHappyString(n,k));
    }
}
