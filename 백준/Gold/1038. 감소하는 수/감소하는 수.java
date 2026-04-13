import java.util.*;
import java.io.*;
import java.sql.ResultSet;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        ArrayList<Long> results = new ArrayList<>();
        for(int i = 0 ; i <= 9; i++) {
            solution(results, i, i);
        }
        results.sort((a,b)->a.compareTo(b));

        Long ans = T < results.size() ? results.get(T) : - 1;
        System.out.println(ans);
    }

    public static void solution(ArrayList<Long> result, long currentNum, int lastDigit) {
        result.add(currentNum);
        for(int i = 0; i < lastDigit; i++) {
            long nextNum = currentNum * 10 + i;
            solution(result, nextNum, i);
        }
    }
}
