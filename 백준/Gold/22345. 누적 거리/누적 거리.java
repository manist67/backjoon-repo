import java.util.*;
import java.util.stream.Collectors;
import java.io.*;


public class Main {

    public static class Town implements Comparator<Town>, Comparable<Town>{
        long pos;
        long popluation;
        public Town(long popluation, long pos) {
            this.popluation = popluation;
            this.pos = pos;
        }

        @Override
        public int compare(Town o1, Town o2) {
            return Long.compare(o1.pos, o2.pos);
        }

        @Override
        public int compareTo(Main.Town o) {
            return Long.compare(this.pos, o.pos);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Town[] towns = new Town[n];

        for(int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());

            towns[i] = new Town(a, x);
        }
        Arrays.sort(towns, (a,b)-> Long.compare(a.pos, b.pos));
        long[] populationSum = new long[n+1];
        long[] weightSum = new long[n+1];
        
        for(int i = 1 ; i <= n ;i++) {
            Town town = towns[i-1];
            populationSum[i] = populationSum[i-1] + town.popluation;
            weightSum[i] = weightSum[i-1] + town.popluation* town.pos;
        }

        long[] candidates = new long[q];
        for(int i = 0 ; i  < q; i++) {
            st = new StringTokenizer(br.readLine());
            candidates[i]  = Long.parseLong(st.nextToken());
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < q; i++) {
            long candidate = candidates[i];
            int idx = Arrays.binarySearch(towns, new Town(0, candidate));
            long sum = 0;
            if(idx >= 0) {
                long leftPop = populationSum[idx]; // 왼쪽 무게 총합
                long leftWeightPos = weightSum[idx]; // 왼쪽 (무게 * 좌표) 총합
                long leftSum = (candidate * leftPop) - leftWeightPos;

                long rightPop = populationSum[n] - leftPop; // 오른쪽 무게 총합
                long rightWeightPos = weightSum[n] - leftWeightPos; // 오른쪽 (무게 * 좌표) 총합
                long rightSum = rightWeightPos - (candidate * rightPop);

                // 4. 최종 정답
                sum = leftSum + rightSum;
            } else {
                idx = -(idx + 1);
                
                long leftPop = populationSum[idx]; // 왼쪽 무게 총합
                long leftWeightPos = weightSum[idx]; // 왼쪽 (무게 * 좌표) 총합
                long leftSum = (candidate * leftPop) - leftWeightPos;

                long rightPop = populationSum[n] - leftPop; // 오른쪽 무게 총합
                long rightWeightPos = weightSum[n] - leftWeightPos; // 오른쪽 (무게 * 좌표) 총합
                long rightSum = rightWeightPos - (candidate * rightPop);

                // 4. 최종 정답
                sum = leftSum + rightSum;
            }
            ans.append(sum).append('\n');
        }

        System.out.print(ans);
    }
}
