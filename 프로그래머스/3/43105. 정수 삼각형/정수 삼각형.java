import java.util.ArrayList;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length + 1][];
        for(int i = 0; i < dp.length; i++) {
            int[] row = new int[i+2];
            dp[i] = row;
        }
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length-1; j++) {
                int curval = triangle[i-1][j-1];
                int maxval = Math.max(
                    dp[i][j], dp[i-1][j-1] + curval
                );
                maxval = Math.max(
                    maxval, dp[i-1][j]+ curval
                );
                
                dp[i][j] = maxval;
            }
        }
        
        int maxval = 0;
        for(int val : dp[dp.length - 1]) {
            maxval = Math.max(val, maxval);
        }
        
        
        return maxval;
    }
}