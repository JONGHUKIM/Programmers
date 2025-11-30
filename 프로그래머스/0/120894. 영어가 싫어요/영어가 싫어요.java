class Solution {
    public long solution(String numbers) {
        // 영어 넘버 하드코딩
        String[] engNumbs = {"zero", "one", "two", "three", "four", "five", "six", 
                           "seven", "eight", "nine"};
        // 숫자 하드코딩
        String[] numbs = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        
        for (int i = 0; i < engNumbs.length; i++) {
            // 영어 -> 숫자로 변경
            numbers = numbers.replace(engNumbs[i], numbs[i]);
        }
        
        return Long.parseLong(numbers);
    }
}