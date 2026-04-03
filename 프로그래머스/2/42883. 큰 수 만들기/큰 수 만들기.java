class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int len = number.length();
        for(int i = 0 ; i < len; i++) {
            char current = number.charAt(i);
            
            while(sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) < current) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            
            sb.append(current);
        }
        return sb.substring(0, sb.length()-k);
    }
}