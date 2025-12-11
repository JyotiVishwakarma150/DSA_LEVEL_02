package _02_HashmapAndHeap;
import java.util.*;
public class _13_CountOfSubstringsWithExactlyKUniqueCharacters {
    public static int solutionForK1(String str){
        int ans = 0;
        HashMap<Character , Integer> mapb = new HashMap<>();
        int i = -1;
        int j = -1;
        while(true){

            boolean f1 = false;
            boolean f2 = false;

            while(i < str.length()-1){
                f1 = true;
                i++;
                char ch = str.charAt(i);
                mapb.put(ch , mapb.getOrDefault(ch,0)+1);

                if(mapb.size() == 2){
                    removeInMap(mapb , ch);
                    i--;
                    break;
                }
            }
            while(j < i){
                f2 = true;
                if(mapb.size() == 1){
                    ans += i - j;
                }
                j++;
                char ch = str.charAt(j);
                removeInMap(mapb , ch);
                if(mapb.size() == 0){
                    break;
                }
            }
            if(f1 == false && f2 == false){
                break;
            }
        }

        return ans;
    }
    public static int solution(String str , int k){
        int ans = 0;

        if(k == 1){
            return solutionForK1(str);
        }

        HashMap<Character , Integer> mapb = new HashMap<>();
        HashMap<Character , Integer> mapa = new HashMap<>();

        int ib = -1;
        int ia = -1;
        int j = -1;

        while(true){

            boolean f1 = false;
            boolean f2 = false;
            boolean f3 = false;
            while(ib < str.length()-1){
                f1 = true;
                ib++;
                char ch = str.charAt(ib);
                mapb.put(ch , mapb.getOrDefault(ch,0)+1);

                if(mapb.size() == k+1){
                    removeInMap(mapb , ch);
                    ib--;
                    break;
                }
            }
            while(ia < ib){
                f2 = true;
                ia++;
                char ch = str.charAt(ia);
                mapa.put(ch , mapa.getOrDefault(ch,0)+1);

                if(mapa.size() == k){
                    removeInMap(mapa , ch);
                    ia--;
                    break;
                }
            }
            while(j < ia){
                f3 = true;

                if(mapb.size() == k && mapa.size() == k-1){
                    ans += ib - ia;
                }
                j++;
                char ch = str.charAt(j);
                removeInMap(mapa , ch);
                removeInMap(mapb , ch);

                if(mapa.size() < k-1 || mapb.size() < k){
                    break;
                }
            }
            if(f1 == false && f2 == false && f3 == false){
                break;
            }
        }

        return ans;
    }

    public static void removeInMap(HashMap<Character,Integer> map ,
                                   char ch){
        if(map.get(ch) == 1){
            map.remove(ch);
        }
        else{
            map.put(ch , map.get(ch)-1);
        }
    }

    public static void main(String[] args){
        Scanner scm = new Scanner(System.in);
        String str = scm.nextLine();
        int k = scm.nextInt();
        System.out.println(solution(str,k));
    }
    }
