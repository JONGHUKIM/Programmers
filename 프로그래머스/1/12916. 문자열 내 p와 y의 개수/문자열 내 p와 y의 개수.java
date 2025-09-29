// 복습

class Solution {
    boolean solution(String s) {
        s = s.toLowerCase(); // 입력값을 소문자로 변환
        
        int pCount = 0; // p를 셀 변수
        int yCount = 0; // y를 셀 변수
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == 'p') { // c가 p or y와 같다면 ++;
                pCount++;
            } else if (c == 'y') {
                yCount++;
            }
        }

        return pCount == yCount;
    }
}