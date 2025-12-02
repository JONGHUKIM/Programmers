import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 전화번호를 저장할 map 선언
        Map<String, Boolean> map = new HashMap<>();
                
        // map에 전화번호 저장
        for (String num : phone_book) {
            map.put(num, true);
        }
        
        // 접두어 확인
        for (int i = 0; i < phone_book.length; i++) {
            // j < phone_book[i].length() -> 접두어가 아닌 자기 자신 전체는 검사에서 제외
            for (int j = 1; j < phone_book[i].length(); j++) {
                // phone_book[i]의 0부터 j까지 자른 문자열이 map에 있는지 확인
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}