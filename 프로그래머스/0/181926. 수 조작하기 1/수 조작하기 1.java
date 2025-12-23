class Solution {
    public int solution(int n, String control) {
        
        // 문자열을 문자 배열로 변환하여 하나씩 꺼냄 ('w', 's', 'd', 'a')
        for (char ch : control.toCharArray()) {
            switch (ch) {
                case 'w': 
                    n += 1; 
                    break;
                case 's': 
                    n -= 1; 
                    break;
                case 'd': 
                    n += 10; 
                    break;
                case 'a': 
                    n -= 10; 
                    break;
            }
        }
        
        return n; // 계산된 최종 n 값을 반환
    }
}