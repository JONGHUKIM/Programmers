class Solution {
    public int solution(int order) {
        int answer = 0;
        
        String strOr = String.valueOf(order);
        
        for (char c : strOr.toCharArray()) {
            if ( c == '3' || c == '6' || c == '9') {
                answer++;
            }
        }
        
        return answer;
    }
}