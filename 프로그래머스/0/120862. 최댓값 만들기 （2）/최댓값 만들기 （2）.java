import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        
        Arrays.sort(numbers);
        
        int product1 = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        int product2 = numbers[0] * numbers[1];
        
        return Math.max(product1, product2);
    }
}