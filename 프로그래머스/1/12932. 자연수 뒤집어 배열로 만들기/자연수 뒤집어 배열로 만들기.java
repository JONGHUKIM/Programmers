class Solution {
    public int[] solution(long n) {
        String sArr = String.valueOf(n);
        
        int[] answer = new int[sArr.length()];
        
        for (int i = 0; i < sArr.length(); i++) {
            answer[i] = Character.getNumericValue(sArr.charAt(sArr.length() - 1 - i));
        }
        
        return answer;
    }
}