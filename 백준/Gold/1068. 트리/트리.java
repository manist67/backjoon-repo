import java.util.*;
import java.io.*;


public class Main {
    static ArrayList<HashSet<Integer>> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        int root = -1;
        for(int i = 0 ; i < N; i++) {
            var node = new HashSet<Integer>();
            tree.add(node);
        }

        for(int i = 0 ; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) {
                root = i;
                continue;
            }

            tree.get(parent).add(i);
        }

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        if(R != root) {
            for(int i = 0 ; i < N; i++) {
                tree.get(i).remove(R);
            }

            int ans = countTree(root);

            System.out.printf("%d", ans);

        } else {
            System.out.printf("%d", 0);
        }
    }

    public static int countTree(int curr) {
        int ans = 0;
        if(tree.get(curr).size() == 0) return 1;
        for(int child : tree.get(curr)) {
            ans += countTree(child);
        }
        return ans;
    }
}
