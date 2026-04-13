import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long N = Integer.parseInt(st.nextToken());
        long r = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());
        long size = (int) Math.pow(2, N);

        System.out.println(recursive(size, r, c));
    }

    public static long recursive(long size, long r, long c) {
        if(size == 1) return 0;
        long nextSize = size / 2;
        long ans = 0;

        long nextRow = r / nextSize;
        long nextCol = c / nextSize;

        long skipBlock = nextSize * nextSize;

        if(nextRow == 0 && nextCol == 0) { // 좌상단
            ans += 0 + recursive(nextSize, r, c);
        } else if(nextRow == 0 && nextCol == 1) { // 우상단
            ans += skipBlock + recursive(nextSize, r, c - nextSize);
        } else if(nextRow == 1 && nextCol == 0) { // 좌하단
            ans += 2 * skipBlock + recursive(nextSize, r - nextSize, c);
        }  else if(nextRow == 1 && nextCol == 1) { // 우하단
            ans += 3 * skipBlock + recursive(nextSize, r - nextSize, c - nextSize);
        } else {
            return -999999999;
        }

        return ans;
    }
}
