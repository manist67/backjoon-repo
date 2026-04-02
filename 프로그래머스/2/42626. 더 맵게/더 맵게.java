import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {        
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        
        for(int s : scoville) {
            minHeap.offer(s);
        }
        
        int count = 0;
        if(minHeap.peek() >= K)  return count;
    
        while(minHeap.size() != 1) {
            int a = minHeap.poll();
            int b = minHeap.poll();
            count ++;
            
            int resultScoville = a + b * 2;
            minHeap.offer(resultScoville);
            
            
            int minScoville = minHeap.peek();
            if(minScoville >= K)  return count;
        }
        
        return -1;
    }
}