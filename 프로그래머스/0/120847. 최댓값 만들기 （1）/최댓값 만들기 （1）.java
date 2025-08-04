import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        
        Arrays.sort(numbers);
        
        int n = numbers.length;
        
        int product1 = numbers[n - 1] * numbers[n - 2];
        int product2 = numbers[0] * numbers[1];
        
        return Math.max(product1, product2);
    }
}