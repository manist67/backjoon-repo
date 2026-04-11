import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        char[] candidates = new char[C];
        for(int i = 0 ; i < C; i++) {
            candidates[i] = st.nextToken().charAt(0);   
        }

        Arrays.sort(candidates);
        
        solution(candidates, C, L);
    }

    public static void solution(char[] candidates, int C, int L) {
        recursive("", candidates, C, L, 0, 0, 0);
    }
    public static void recursive(String current, char[] candidates, int C, int L, int s, int vowels, int constants) {
        if(current.length() == L) {
            if(vowels >= 1 && constants >= 2) System.out.println(current);
            else return;
        }

        for(int i = s; i < C; i++) {
            char candidate = candidates[i];
            // System.out.println(">>> " + current + " : " + candidate);
            if(candidate == 'a' || candidate == 'e' || candidate == 'i' || candidate == 'o' || candidate == 'u') vowels++;
            else constants++;

            current = current + candidate;
            recursive(current, candidates, C, L, i + 1, vowels, constants);
            current = current.substring(0, current.length() - 1);

            if(candidate == 'a' || candidate == 'e' || candidate == 'i' || candidate == 'o' || candidate == 'u') vowels--;
            else constants--;
        }
    }
}
