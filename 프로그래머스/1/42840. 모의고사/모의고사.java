import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = new int[] {
            1, 2, 3, 4, 5
        };
        int[] student2 = new int[] {
            2, 1, 2, 3, 2, 4, 2, 5
        };     
        int[] student3 = new int[] {
            3, 3, 1, 1, 2, 2, 4, 4, 5, 5  
        };
        
        int [] scores = new int[] { 0, 0, 0 };
        for(int i = 0; i < answers.length ; i++) {
            int ans = answers[i];
            if(ans == student1[i % student1.length]) scores[0]++;
            if(ans == student2[i % student2.length]) scores[1]++;
            if(ans == student3[i % student3.length]) scores[2]++;
        }
        
        int maxScore = Math.max(scores[0], scores[1]);
        maxScore = Math.max(maxScore, scores[2]);
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0 ; i < 3; i++) {
            if(scores[i] == maxScore) answer.add(i + 1);
        }
        
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}