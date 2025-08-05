class Solution {
    public int[] solution(int money) {
        int iceImericanoPrice = 5500;
        
        int cups = money / iceImericanoPrice;
        
        int change = money % iceImericanoPrice;
        
        int[] answer = {cups,change};
        
        return answer;
    }
}