import java.util.*;
import java.util.stream.Collectors;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N; i++) {
            int s = Integer.parseInt(st.nextToken());
            arr[i] = s;
        }

        int ans = 0;
        for(int i = 1; i <= N; i++) {
            int visible = 0;
            int currHeight = arr[i]; 

            double maxTheta = Double.POSITIVE_INFINITY;

            for(int j = i - 1; j > 0; j--) { // 건물 기준 왼쪽
                int targetHeight = arr[j];
                double theta = (double) (targetHeight - currHeight) / (j - i);
                // System.out.printf("%d %d -> theta : %f maxtheta : %f\n", i, j , theta, maxTheta);
                if(theta < maxTheta) {
                    visible ++;
                    maxTheta = theta;
                }                
            }

            maxTheta = Double.NEGATIVE_INFINITY;
            for(int j = i + 1; j <= N; j++) { // 건물 기준 오른쪽
                int targetHeight = arr[j];
                double theta = (double) (targetHeight - currHeight) / (j - i);
                // System.out.printf("%d %d -> theta : %f maxtheta : %f\n", i, j , theta, maxTheta);
                if(theta > maxTheta) {
                    visible ++;
                    maxTheta = theta;
                }                
            }



            // System.out.printf(">>> visible : %d %d\n", i, visible);
            ans = Math.max(ans, visible);
        }
        System.out.println(ans);
    }

    public static double getRelaventTheta(int i, int j, int iHeight, int jHeight) {
        return Math.tanh(
            (jHeight - iHeight) / (j - i)
        );
    }
}
