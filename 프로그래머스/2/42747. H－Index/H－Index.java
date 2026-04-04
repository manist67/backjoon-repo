import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int len = citations.length;
        Arrays.sort(citations);
        
        for(int i = 0 ; i < len; i++) {
            int hCandidate = len - i;
            if(citations[i] >= hCandidate) {
                return hCandidate;
            }
        }
    
        return 0;
    }
}