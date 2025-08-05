class Solution {
    public int solution(int n) {
        int pizzaCount = 1;
        
        while(true) {
            if ((6 * pizzaCount) % n == 0) {
                return pizzaCount;
            }
            pizzaCount++;
        }
    }
}