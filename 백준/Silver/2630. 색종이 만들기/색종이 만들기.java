import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][N];
        for(int i = 0 ; i <N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[] ans = count(arr, 0, 0, N);
        System.out.println(ans[1]);
        System.out.println(ans[0]);
    }
    public static int[] count(int[][] arr, int x, int y, int width) {
        if(width == 1) {
            if(arr[y][x] == 1) return new int[] { 1, 0 };
            else return new int[] { 0, 1 };
        }

        boolean isCoutable = true;
        int color = arr[y][x];

        for(int i = x; i < x + width; i++) {
            for(int j = y; j < y + width; j++) {
                if(arr[j][i] != color) {
                    isCoutable = false;
                    break;
                }
            }
            if(!isCoutable) break;
        }
        if(isCoutable) {
            return color == 1 ? new int[] { 1, 0 } : new int[] { 0, 1 };
        }
        
        int[] a = count(arr, x, y, width / 2);
        int[] b = count(arr, x + width / 2, y, width / 2);
        int[] c = count(arr, x, y + width / 2, width / 2);
        int[] d = count(arr, x + width / 2, y + width / 2, width / 2);
        return new int[] {
            a[0] + b[0] + c[0] + d[0],
            a[1] + b[1] + c[1] + d[1]
        };
    }
}
