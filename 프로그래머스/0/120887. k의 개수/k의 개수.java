class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        String strK = String.valueOf(k);
        
        for (int num = i; num <= j; num++) {
            String numStr = String.valueOf(num);
            
            for (char c : numStr.toCharArray()) {
                if (String.valueOf(c).equals(strK)) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}