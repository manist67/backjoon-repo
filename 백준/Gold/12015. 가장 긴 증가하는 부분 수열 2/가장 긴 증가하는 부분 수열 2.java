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

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        ArrayList<Integer> lis = new ArrayList<>();

        lis.add(arr[0]);
        for(int i = 1; i < N; i++) {
            if(lis.get(lis.size()-1) < arr[i]) {
                lis.add(arr[i]);
            } else {
                int l = 0, r = lis.size() -1;
                while(l<=r) {
                    int mid = (l+r) /2;
                    if(lis.get(mid) < arr[i]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                lis.set(l, arr[i]);
            }
        }
        System.out.println(lis.size());
    }
}