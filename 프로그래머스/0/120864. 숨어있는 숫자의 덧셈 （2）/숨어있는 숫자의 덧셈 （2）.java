// 복습

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String[] numbers = my_string.replaceAll("[^0-9]", " ").trim().split(" ");
        
        for (String s : numbers) {
            if(!s.isEmpty()) {
                answer += Integer.parseInt(s);
            }
        }
        
        return answer;
    }
}