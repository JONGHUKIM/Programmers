class Solution {
    public int solution(int hp) {
        // 장군 5 공격, 병정 3 공격, 일 1 공격
        int answer = 0;
        
        answer += hp / 5;
        hp %= 5;
        
        answer += hp / 3;
        hp %= 3;
        
        answer += hp;

        return answer;
    }
}