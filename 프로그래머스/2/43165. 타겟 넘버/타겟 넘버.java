class Solution {
    
    // target을 만들 수 있는 경우의 수
    int answer;
    // 사용할 숫자 배열
    int[] numbers;
    // 만들고 싶은 목표 값
    int target;
    
    // index 현재까지 사용한 숫자의 개수 (다음에 사용할 numbers의 인덱스)
    // sum index 이전까지 선택한 (+ / -) 결과의 누적 합
    private void dfs (int index, int sum) {
        // 종료 조건
        // 모든 숫자를 한 번씩 다 사용 (리프 노드)
        if (index == numbers.length) {
            // 누적합이 target과 같으면
            if (sum == target) {
                answer++; // answer증가
            }
            return;
        }
        
        // 동작 수행
        // 다음 index로 이동하면서 sum에 더함
        dfs(index + 1, sum + numbers[index]);
        // 다음 index로 이동하면서 sum에서 뺌
        dfs(index + 1, sum - numbers[index]);
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        // 멤버 변수에 저장(dfs 사용)
        this.numbers = numbers;
        this.target = target;
        
        // dfs 초기화
        dfs(0, 0);
        
        return answer;
    }
}