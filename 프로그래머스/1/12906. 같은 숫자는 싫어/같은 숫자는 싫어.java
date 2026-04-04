import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int n : arr) {
            if(answer.size() == 0) {
                answer.add(n);
                continue;
            }
            if(answer.get(answer.size() - 1) == n) continue;
            answer.add(n);
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer.stream().mapToInt(i->i).toArray();
    }
}