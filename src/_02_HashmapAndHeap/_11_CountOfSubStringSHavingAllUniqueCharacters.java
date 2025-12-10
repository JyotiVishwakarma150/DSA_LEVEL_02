package _02_HashmapAndHeap;
import java.util.*;

public class _11_CountOfSubStringSHavingAllUniqueCharacters {
    public static int solution(String str) {
        int ans=0;
        int i=-1;
        int j=-1;
        HashMap<Character,Integer> map=new HashMap<>();
        while(true){
            boolean f1=false;
            boolean f2=false;
            // acquire till...unique window toot rhi hai(repeat aa gya)
            while(i<str.length()-1){
               f1=true;
                i++;
                char ch=str.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.get(ch)==2){
                    break;
                }else{
                  ans += i-j;
                }
            }
            //release till...unique window wapas se ban jye
            while(j<i){
                f2=true;
                j++;
                char ch=str.charAt(j);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==1){
                    //har valid moment pr...ye kaam krege..mtlb ans += window length
                    ans += i-j;
                    break;
                }
            }
            //jb acquire and release na chle to loop bnd krdo
            if(f1==false && f2==false){
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}
