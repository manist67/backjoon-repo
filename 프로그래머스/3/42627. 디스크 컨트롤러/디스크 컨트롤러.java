import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

class Solution {
    public int solution(int[][] jobs) {
        int currentTime = 0;
        
        Arrays.sort(jobs, (a,b)->a[0]-b[0]);
        
        PriorityQueue<int[]> pqueue = new PriorityQueue(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
    
        
        
        int taskTimeSum = 0;
        int count = 0;
        int jobIdx = 0;

        while(count < jobs.length) {
            while(jobIdx < jobs.length && jobs[jobIdx][0] <= currentTime) {
                pqueue.offer(jobs[jobIdx++]);
            }    
            
            if(pqueue.isEmpty()) {
                currentTime = jobs[jobIdx][0];
            } else {
                int[] task = pqueue.poll();
                taskTimeSum += (currentTime + task[1] - task[0]);
                currentTime += task[1];
                count ++;
            }
        }

        return taskTimeSum/jobs.length;
    }
}