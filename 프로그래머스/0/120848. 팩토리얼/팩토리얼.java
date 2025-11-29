// 팩토리얼

class Solution {
    public int solution(int n) {
        int i = 1;
        int fact = 1;
        
        while(true) {
            fact *= i;
            if (fact > n) {
                return i - 1;
            } else if (fact == n ) {
                return i;
            }
            i++;
        }
    }
}