import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer> lines = new ArrayList<>();
        for(int i = 0 ; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            lines.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(lines);

        long l = 1, r = lines.get(lines.size()-1);

        long ans = 1;
        while(l <= r) {
            long mid = (l+r)/2;
            long maxCount = 0;
            for(int line : lines) maxCount += (line/mid);

            if(maxCount >= N) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(ans);
    }
}