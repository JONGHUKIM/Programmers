class Solution {
    
    int answer;
    int[] numbers;
    int target;
    
    private void dfs(int index, int sum) {
        //종료 조건
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        // 수행 동작
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        // 멤버 변수 연결
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, 0);
        
        return answer;
    }
}