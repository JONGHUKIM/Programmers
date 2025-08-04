class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {0,0};
        
        for (int number : num_list) {
            int result = (number % 2 == 0) ? answer[0]++ : answer[1]++;
        }

        return answer;
    }
}