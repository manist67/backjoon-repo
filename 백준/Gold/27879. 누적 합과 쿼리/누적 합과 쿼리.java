import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        char[][] arr = new char[n+1][n+1];
        for(int j = 1 ; j <= n; j++) {
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n;i++) arr[j][i] = st.nextToken().charAt(0);
        }

        // aa, bb, ab, ba
        int[][] horizontal_aa = new int[n + 1][n + 1];
        int[][] horizontal_bb = new int[n + 1][n + 1];
        int[][] horizontal_ab = new int[n + 1][n + 1];
        int[][] horizontal_ba = new int[n + 1][n + 1];

        
        int[][] vertical_aa = new int[n + 1][n + 1];
        int[][] vertical_bb = new int[n + 1][n + 1];
        int[][] vertical_ab = new int[n + 1][n + 1];
        int[][] vertical_ba = new int[n + 1][n + 1];

        for(int j = 1; j <= n; j++) {
            for(int i = 1; i <= n; i++) {
                int h_aa_cost = arr[j][i-1] == 'a' && arr[j][i] == 'a' ? 1 : 0;
                horizontal_aa[j][i] = horizontal_aa[j][i-1] + horizontal_aa[j-1][i] - horizontal_aa[j-1][i-1] + h_aa_cost;
                
                int h_bb_cost = arr[j][i-1] == 'b' && arr[j][i] == 'b' ? 1 : 0;
                horizontal_bb[j][i] = horizontal_bb[j][i-1] + horizontal_bb[j-1][i] - horizontal_bb[j-1][i-1] + h_bb_cost;
                
                int h_ab_cost = arr[j][i-1] == 'a' && arr[j][i] == 'b' ? 1 : 0;
                horizontal_ab[j][i] = horizontal_ab[j][i-1] + horizontal_ab[j-1][i] - horizontal_ab[j-1][i-1] + h_ab_cost;
                
                int h_ba_cost = arr[j][i-1] == 'b' && arr[j][i] == 'a' ? 1 : 0;
                horizontal_ba[j][i] = horizontal_ba[j][i-1] + horizontal_ba[j-1][i] - horizontal_ba[j-1][i-1] + h_ba_cost;


                
                int v_aa_cost = arr[j-1][i] == 'a' && arr[j][i] == 'a' ? 1 : 0;
                vertical_aa[j][i] = vertical_aa[j][i-1] + vertical_aa[j-1][i] - vertical_aa[j-1][i-1] + v_aa_cost;
                
                int v_bb_cost = arr[j-1][i] == 'b' && arr[j][i] == 'b' ? 1 : 0;
                vertical_bb[j][i] = vertical_bb[j][i-1] + vertical_bb[j-1][i] - vertical_bb[j-1][i-1] + v_bb_cost;
                
                int v_ab_cost = arr[j-1][i] == 'a' && arr[j][i] == 'b' ? 1 : 0;
                vertical_ab[j][i] = vertical_ab[j][i-1] + vertical_ab[j-1][i] - vertical_ab[j-1][i-1] + v_ab_cost;
                
                int v_ba_cost = arr[j-1][i] == 'b' && arr[j][i] == 'a' ? 1 : 0;
                vertical_ba[j][i] = vertical_ba[j][i-1] + vertical_ba[j-1][i] - vertical_ba[j-1][i-1] + v_ba_cost;
            }
        }

        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int j1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            int j2 = Integer.parseInt(st.nextToken());
            String s = st.nextToken();            
            int h_sum = 0;
            int v_sum = 0;
            switch (s) {
                case "aa":
                    h_sum = horizontal_aa[i2][j2] - horizontal_aa[i1 - 1][j2] - horizontal_aa[i2][j1] + horizontal_aa[i1 - 1][j1];
                    v_sum = vertical_aa[i2][j2] - vertical_aa[i1][j2] - vertical_aa[i2][j1 - 1] + vertical_aa[i1][j1 - 1];
                    break;
                case "bb":
                    h_sum = horizontal_bb[i2][j2] - horizontal_bb[i1 - 1][j2] - horizontal_bb[i2][j1] + horizontal_bb[i1 - 1][j1];
                    v_sum = vertical_bb[i2][j2] - vertical_bb[i1][j2] - vertical_bb[i2][j1 - 1] + vertical_bb[i1][j1 - 1];
                    break;
                case "ab":
                    h_sum = horizontal_ab[i2][j2] - horizontal_ab[i1 - 1][j2] - horizontal_ab[i2][j1] + horizontal_ab[i1 - 1][j1];
                    v_sum = vertical_ab[i2][j2] - vertical_ab[i1][j2] - vertical_ab[i2][j1 - 1] + vertical_ab[i1][j1 - 1];
                    break;
                case "ba":
                    h_sum = horizontal_ba[i2][j2] - horizontal_ba[i1 - 1][j2] - horizontal_ba[i2][j1] + horizontal_ba[i1 - 1][j1];
                    v_sum = vertical_ba[i2][j2] - vertical_ba[i1][j2] - vertical_ba[i2][j1 - 1] + vertical_ba[i1][j1 - 1];
                    break;
            }
            sb.append(h_sum + v_sum).append('\n');
        }   
        System.out.println(sb.toString());
    }
}
