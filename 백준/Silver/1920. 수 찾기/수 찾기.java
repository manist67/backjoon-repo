import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer> origin = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) {
            origin.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(origin);
        
        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(solution(origin, target) > 0 ? "1" : "0").append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }
    
    // 1 2 3 3 4 5
    static int solution(ArrayList<Integer> origin, Integer target) {
        int l = 0, r = origin.size();
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(target <= origin.get(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int lower = l;

        l = 0;
        r = origin.size();
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(target < origin.get(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int higher = r;

        return higher - lower;
    }
}
