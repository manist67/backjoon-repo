import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        

        long ans = 0;
        long l = 1, r = k;
        while(l<=r) {
            long mid = (l + r) / 2;
            long count = 0;
            for(int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N); 
            }
            if(count < k) {
                l = mid + 1;
            } else {
                ans = mid; 
                r = mid - 1;
            } 
        }
        
        System.out.println(ans);
    }
}
