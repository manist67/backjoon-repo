import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 

        int[][] arr = new int[4][N];
        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 4; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int[] ab = new int[N*N];
        int[] cd = new int[N*N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j< N; j++){
                ab[i*N+j] = arr[0][i] + arr[1][j];
                cd[i*N+j] = arr[2][i] + arr[3][j];
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);

        long ans = 0;
        for(int i = 0; i < N*N; i++) {
            int l = 0, r = N*N;
            int lower = 0, higher = 0;
            while(l<r) {
                int mid = (l+r)/2;
                int sum = ab[i] + cd[mid];
                if(sum > 0) {
                    r = mid;
                } else if(sum < 0) {
                    l = mid + 1;
                } else {
                    lower = mid;
                    r = mid;
                }
            }
            l = 0;
            r = N*N;
            while(l<r) {
                int mid = (l+r)/2;
                int sum = ab[i] + cd[mid];
                if(sum > 0) {
                    r = mid;
                } else if(sum < 0){
                    l = mid + 1;
                } else {
                    higher = mid + 1;
                    l = mid + 1;
                }
            }
            
            ans += (higher - lower);
        }

        System.out.println(ans);
    }
}