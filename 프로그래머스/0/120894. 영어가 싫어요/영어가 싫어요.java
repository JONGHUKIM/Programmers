class Solution {
    public long solution(String numbers) {
        String[] engNumbs = {"zero", "one", "two", "three", "four", "five", "six", 
                           "seven", "eight", "nine"};
        String[] numbs = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        
        for (int i = 0; i < engNumbs.length; i++) {
            numbers = numbers.replace(engNumbs[i], numbs[i]);
        }
        
        return Long.parseLong(numbers);
    }
}