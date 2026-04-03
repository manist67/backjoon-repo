import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        ArrayList<Integer> losted = new ArrayList<>(lost.length);
        for(int l: lost) {
            losted.add(Integer.valueOf(l));
        }
        
        ArrayList<Integer> reservable = new ArrayList<>(reserve.length);
        for(int r: reserve) {
            if(losted.contains(r)) {
                losted.remove((Object) Integer.valueOf(r));
                continue;
            }
            reservable.add(Integer.valueOf(r));
        }
        
        
        int answer = n - losted.size();
        for(int l : losted) {
            if(reservable.contains(l-1)) {
                reservable.remove((Object) Integer.valueOf(l-1));
                answer++;
                continue;
            } 
            
            if(reservable.contains(l+1)) {
                reservable.remove((Object) Integer.valueOf(l+1));
                answer++;
                continue;
            } 
            
        }
        
        
        return answer;
    }
}