class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start = 0;
        int end = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        
        while (end != sequence.length) {
            sum += sequence[end];
            
            while (sum > k) {
                sum -= sequence[start];
                start++;
            }
            
            if (sum == k) {
                int leng = end - start + 1;
                if (leng < minLength) {
                    minLength = leng;
                    answer[0] = start;
                    answer[1] = end;
                }
            }
            
            end++;
        }
        
        return answer;
    }
}