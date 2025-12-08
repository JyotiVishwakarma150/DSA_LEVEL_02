package _02_HashmapAndHeap;
import java.util.*;
public class _08_MinimumWindowSubString {
    public static String solution(String s1, String s2){
        String ans="";
        HashMap<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<s2.length();i++){
            char ch=s2.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        int mct=0;//match count
        int dmct=s2.length();//desired match count
        HashMap<Character,Integer> map1=new HashMap<>();
        int i=-1;// acquire pointer
        int j=-1; // release pointer
        while(true){
            boolean f1=false;
            boolean f2=false;
            // ACQUIRE characters until all required chars are matched (mct==dmct)
            while(i<s1.length()-1 && mct<dmct){
                i++;
                char ch=s1.charAt(i);
                // add char to window map1
                map1.put(ch,map1.getOrDefault(ch,0)+1);
                // if its count is still <= required count, increase match count
                if(map1.getOrDefault(ch,0)<=map2.getOrDefault(ch,0)){
                    mct++;
                }
                f1=true;
            }
            //collect answers and release.....RELEASE characters to minimize window size
            while(j<i && mct == dmct){
                String pans=s1.substring(j+1,i+1);//pans=potential answer
                if(ans.length()==0 || pans.length()<ans.length()){
                    ans=pans;
                }
                j++;
                char ch=s1.charAt(j);
                // decrease freq in map1 because j moved
                if(map1.get(ch)==1){
                    map1.remove(ch);
                }else{
                    map1.put(ch, map1.get(ch)-1);
                }
                // if removing causes < required, reduce mct
                if(map1.getOrDefault(ch,0)< map2.getOrDefault(ch,0)){
                    mct--;
                }
                f2=true;
            }
            // agar acquire bhi nahi hua aur release bhi nahi hua → done
            if(f1==false && f2==false){
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1,s2));
    }

}
