import java.util.Stack;
import java.util.ArrayList;


class Solution {
    public int solution(int[] numbers, int target) {
        Stack<Integer> stack = new Stack();
        Stack<Integer> level = new Stack();
        
        ArrayList<Integer> arr = new ArrayList();
        
        stack.push(numbers[0]);
        level.push(0);
        
        stack.push(-1 * numbers[0]);
        level.push(0);
        
        while(!stack.empty()) {
            int nextIdx = stack.size()/2 + 1;
            Integer num = stack.pop();
            Integer lv = level.pop();
            if(lv == numbers.length - 1) {
                arr.add(num);
            } else {
                stack.push(num + numbers[lv+1]);
                level.push(lv+1);
                
                stack.push(num - numbers[lv+1]);
                level.push(lv+1);
            }
        }
        
        int answer = 0;
        for(Integer a : arr) {
            if(a.equals(target)) answer++;
        }
        
        return answer;
    }
}