import java.util.*;
import java.io.*;
import java.sql.ResultSet;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] words = new String[N];
        HashSet<Character> characters = new HashSet<>();

        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            words[i] = word;

            for(int j = 0 ; j < word.length(); j++) {
                characters.add(word.charAt(j));
            }
        }

        
        var mustKnow = new char[] { 'a', 'n', 't', 'i', 'c' };

        var knowList = new HashSet<Character>();

        for(char m : mustKnow) {
            knowList.add(m);
            characters.remove(m);
        }

        ArrayList<Character> candidates = new ArrayList<>();
        for(char candidate : characters) candidates.add(candidate);

        // System.out.println(candidates);
        // System.out.println(characters);
        

        System.out.println(readable(K-5, 0, words, knowList, candidates));
    }

    public static boolean read(String word, HashSet<Character> knowList) {
        for(int i = 0 ; i < word.length(); i++) {
            if(!knowList.contains(word.charAt(i))) return false;
        }

        return true;
    }

    public static int readable(int K, int s, String[] words, HashSet<Character> knowList, ArrayList<Character> candidates) {
        if(K < 0) return 0;
        if(K == 0 || candidates.size() + 5 == knowList.size()) {
            int readCount = 0;
            for(String word : words) {
                if(read(word, knowList)) readCount++;
            }

            return readCount;
        }
        
        int readCount = 0;
        for(int i = s; i < candidates.size(); i++) {
            char candidate = candidates.get(i);
            knowList.add(candidate);
            
            readCount = Math.max(readCount, readable(K-1, i + 1, words, knowList, candidates));

            knowList.remove(candidate);
        }

        return readCount;
    }
}
