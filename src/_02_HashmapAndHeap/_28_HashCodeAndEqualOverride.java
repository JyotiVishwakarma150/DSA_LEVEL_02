package _02_HashmapAndHeap;

import java.util.HashMap;
import java.util.Objects;

public class _28_HashCodeAndEqualOverride {
    public static class Pair{
        int a;
        String s;
        Pair(int a,String s){
            this.a=a;
            this.s=s;
        }
        //step1->override equals
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || this.getClass() != obj.getClass()) return false;
            Pair other=(Pair)obj;
            return this.a== other.a&&this.s.equals(other.s);
        }
        //step2->override hashcode
        @Override
        public int hashCode(){
        return Objects.hash(a,s);
        }
        //optional:for printing
        @Override
        public String toString(){
            return "("+a+","+s+")";
        }
    }

    public static void main(String[] args) {
        HashMap<Pair,Integer> map=new HashMap<>();
        Pair p1=new Pair(10,"Pepcoding");
        Pair p2=new Pair(10,"Pepecoding");
        map.put(p1,1);
        map.put(p2,map.getOrDefault(p2,0)+1);
        System.out.println(map);
    }
}
