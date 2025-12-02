import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 정렬
        Arrays.sort(phone_book);
        
        // i와 i+1만 비교
        for (int i = 0; i < phone_book.length - 1; i++) {
            // 뒷 번호(i+1)가 앞 번호(i)로 시작?
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }                
        }
        
        return true;
    }
}