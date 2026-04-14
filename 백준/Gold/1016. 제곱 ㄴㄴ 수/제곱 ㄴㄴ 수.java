import java.util.*;
import java.io.*;
import java.sql.ResultSet;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] set = new boolean[(int)(max-min + 1L)];

        HashSet<Long> square = new HashSet<>();

        for(long i = 2 ; i <= (long) Math.sqrt(max); i++ ) {
            square.add(i*i);
        }

        for(Long s : square) {
            long start = min / s;
            if(min % s != 0) start++;
            for(long i = start; (long) (s * i) <= max; i++) {
                int idx = (int)(s*i-min);
                set[idx] = true;
            }
        }

        int ans = 0;
        for(int i = 0 ;i < set.length; i++) {
            if(!set[i]) ans++;
        }
        

        System.out.printf("%d", ans);
    }
}
