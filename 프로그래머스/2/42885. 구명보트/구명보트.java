import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        
        
        while(left <= right) {
            if (people[left] + people[right] <= limit) {
                left++; // 가벼운 사람도 같이 태움
            }
            right --;
            answer++;
        }
        
        return answer;
    }
}