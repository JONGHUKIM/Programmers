class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int serv_drink = (n / 10) * 2000;  
        
        answer = (n * 12000) + (k * 2000) - serv_drink;
        
        return answer;
    }
}