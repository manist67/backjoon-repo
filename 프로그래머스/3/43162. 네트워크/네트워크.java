import java.util.Stack;
import java.util.ArrayList;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        ArrayList<Boolean> categorified = new ArrayList<>();
        for(int i = 0; i < n; i++) categorified.add(false);
        
        
        for(int i = 0; i < computers.length; i++) {
            if(categorified.get(i)) continue;
            int[] network = connected(i, n, computers);
            
            for(int j = 0 ; j < network.length; j++) {
                categorified.set(network[j], true);
            }
                
            answer++;
            
        }
        
        return answer;
    }
    
    private int[] connected(int idx, int n, int[][] computers) {
        ArrayList<Boolean> visited = new ArrayList<>(computers.length);
        for(int i = 0 ; i < n; i++) visited.add(false);
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0 ; i < computers[idx].length; i++) {
            if(computers[idx][i] == 1) { 
                visited.set(i, true);
                stack.push(i);
            }
        }
        
        while(!stack.empty()) {
            Integer computerIdx = stack.pop();
            for(int i = 0; i < n; i++) {
                if(computers[computerIdx][i] == 0) continue;
                if(visited.get(i)) continue;
                visited.set(i, true);
                stack.push(i);
            }
        }
        
        ArrayList<Integer> connceted = new ArrayList<>();
        for(int i = 0 ; i < n; i++) {
            if(visited.get(i)) connceted.add(i);
        }
        
        return connceted.stream().mapToInt(i->i).toArray();
    }
}