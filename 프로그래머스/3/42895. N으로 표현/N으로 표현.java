import java.util.HashSet;
import java.util.ArrayList;

class Solution {
    public int solution(int N, int number) {
        ArrayList<HashSet<Integer>> sets = new ArrayList<>();
        sets.add(new HashSet<>());
        
        for(int i = 1; i <= 8; i++) {
            HashSet<Integer> set = new HashSet<>();
            int defaultVal = 0;
            for(int j = 1; j <= i; j++) {
                defaultVal *= 10;
                defaultVal += N;
            }
            set.add(defaultVal);
            sets.add(set);
            if(defaultVal == number) return i;
        }
        
        for(int i = 1; i <= 8; i++) {
            for(int j = 1; j <= i-1; j++) {
                for(Integer jval : sets.get(j)) {
                    for(Integer jival : sets.get(i-j)) {
                        if( jval + jival == number) return i;
                        if( jval - jival == number) return i;
                        if( jval * jival == number) return i;
                        
                        HashSet<Integer> set = sets.get(i);
                        
                        set.add( jval + jival );
                        set.add( jval - jival );
                        set.add( jval * jival );
                        
                        if(jival.equals(0)) continue;
                        set.add( jval / jival );
                        if( jval / jival == number) return i;
                    }
                }
            }
        }
            
        return -1;
    }
}