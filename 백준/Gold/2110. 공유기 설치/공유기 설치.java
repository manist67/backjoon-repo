import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int[] homes = new int[N];
        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            homes[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(homes);
        
        long ans = 0;
        long l = 1, r = homes[N-1] - homes[0];
        
        while(l<=r) {
            long mid = (l+r) / 2;
            int lastloc = 0;
            int count = 1;
            for(int i = 1 ; i < N; i++) {
                if(homes[i] - homes[lastloc] >= mid) {
                    count++;
                    lastloc = i;
                }
            }
            if(count>=C) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        System.out.println(ans);
    }
}
