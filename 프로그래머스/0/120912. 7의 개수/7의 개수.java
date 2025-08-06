class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for (int n : array) {
            String strN = String.valueOf(n);
            for ( char c : strN.toCharArray()) {
                if (c == '7') {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}