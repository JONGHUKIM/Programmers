import java.util.*;

class Solution {
    
    // 중복을 제거할 set 멤버변수 선언
    Set<Integer> set = new HashSet<>();
    
    // 소수인지 확인하는 변수 선언
    private boolean isPrime(int numb) {
        // 0 과 1은 소수가 아님
        if (numb < 2) return false;
        
        // 에라토스테네스의 체 활용
        int lim = (int)Math.sqrt(numb);
        
        for (int i = 2; i <= lim; i++) {
            // i로 나눠지면 소수가 아님
            if (numb % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    // 소수를 찾을 dfs 선언
    private void dfs(String comb, String others) {
        // 콤이 빈 문자열이 아니면 set에 추가
        if (!comb.equals("")) {
            set.add(Integer.parseInt(comb));
        }
        
        // 남은 숫자만큼 반복
        for (int i = 0; i < others.length(); i++) {
            // 현재 조합에 i를 붙여서 새로운 조합을 만듦 
            String newCom = comb + others.charAt(i);
            
            // i번째 카드를 사용했으므로 이를 제외한 다음 숫자들을 추출
            String remain = others.substring(0, i) + others.substring(i + 1);
            
            dfs(newCom, remain);
        }
    }
    
    public int solution(String numbers) {
        
        set.clear();
        
        int answer = 0;
        
        // 모든 숫자의 조합을 찾음 dfs
        // 초기 조합은 빈 문자열과 모든 숫자
        dfs("", numbers);
        
        // for문 대신 iterator를 사용하여 소수의 갯수를 찾음
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
            
            int number = it.next();
            
            if (isPrime(number)) {
                answer++;
            }
        }
        
        // 소수의 갯수 리턴
        return answer;
    }
}