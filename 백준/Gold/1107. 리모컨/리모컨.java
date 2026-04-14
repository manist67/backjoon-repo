import java.util.*;
import java.io.*;


public class Main {
    static HashSet<Integer> broken = new HashSet<>();
    
    public static int check(int number) {
        if(number == 0) {
            return broken.contains(0) ? 0 : 1;
        }


        int len = 0;
        while(number > 0) {
            if(broken.contains(number % 10)) return 0;
            len ++;
            number /= 10;
        }

        return len;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        if(M > 0) {
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i <M; i++) {
                broken.add( Integer.parseInt(st.nextToken() ) );
            }
        }

        int minPress = Math.abs(N - 100);
        for(int i = 0; i <= 1000000; i++ ) {
            int len = check(i);

            if(len > 0) {
                int press = Math.abs(i - N);
                minPress = Math.min(minPress, len + press);
            }
        }

        System.out.println(minPress);
    }
}
