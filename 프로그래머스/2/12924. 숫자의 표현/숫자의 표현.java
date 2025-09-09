// 복습

class Solution {
    public int solution(int n) {
        int count = 1;
        int sum = 1;
        int start = 1;
        int end = 1;
        
        while (end != n) {
            if (sum == n) {
                count++;
                end++;
                sum = sum + end;
            } else if (sum > n) {
                sum = sum - start;
                start++;
            } else {
                end++;
                sum = sum + end;
            }
        }
        return count;
    }
}