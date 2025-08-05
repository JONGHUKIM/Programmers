class Solution {
    public int solution(int price) {
        // 10만원이상 5%, 30만원 이상 10%, 50만원이상 20% 할인 return 지불금액
        double discountRate = 0.0;
        
        if (price >= 500000) {
            discountRate = 0.20;
        } else if ( price >= 300000) {
            discountRate = 0.10;
        } else if (price >= 100000) {
            discountRate = 0.05;
        }
        
        int discountPrice = (int)(price * (1 - discountRate));
        
        return discountPrice;
    }
}