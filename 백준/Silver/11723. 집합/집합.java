import java.util.*;
import java.io.*;


public class Main {
    public static class MySet {
        boolean[] data = new boolean[21];
        public void add(int x) {
            data[x] = true;
        }

        public void remove(int x) {
            data[x] = false;
        }

        public boolean check(int x) {
            return data[x];
        }
        
        public void toggle(int x) {
            data[x] = !data[x];
        }

        public void all() {
            Arrays.fill(data, true);
        }

        public void empty() {
            Arrays.fill(data, false);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        
        StringBuilder ans = new StringBuilder();
        MySet ms = new MySet();

        for(int i = 0 ; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String code = st.nextToken();
            int operand = -1;
            switch (code) {
                case "add":
                    operand = Integer.parseInt(st.nextToken());
                    ms.add(operand);
                    break;
                case "remove":
                    operand = Integer.parseInt(st.nextToken());
                    ms.remove(operand);
                    break;
                case "toggle":
                    operand = Integer.parseInt(st.nextToken());
                    ms.toggle(operand);
                    break;
                case "check":
                    operand = Integer.parseInt(st.nextToken());
                    ans.append(ms.check(operand) ? "1": "0").append('\n');
                    break;
                case "all":
                    ms.all();
                    break;
                case "empty":
                    ms.empty();
                    break;
            
                default:
                    break;
            }
        }
        
        System.out.println(ans.toString());
    }
}
