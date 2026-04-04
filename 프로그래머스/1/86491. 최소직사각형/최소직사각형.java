import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public int solution(int[][] sizes) {
        int len = sizes.length * 2;
        HashSet<Integer> candidates = new HashSet<>();
        
        
        for(int[] s : sizes) {
            candidates.add(s[0]);
            candidates.add(s[1]);
        }
        
        int answer = 1000 * 1000 * 2;
        for(int x : candidates) {            
            for(int y : candidates) {
                if(isValid(x, y, sizes) && answer > x*y) answer = x*y;
            }
        }
        
        return answer;
    }
    
    private boolean isValid(int x, int y, int[][] sizes) {
        for(int[] size : sizes) {
            if((x >= size[0] && y >= size[1]) || (x >= size[1] && y >= size[0])) continue;
            return false;
        }
        
        return true;
    }
    
}