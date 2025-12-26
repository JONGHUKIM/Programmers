import java.util.*;

class Solution {
    
    // 중복된 숫자를 자동으로 제거하기 위해 HashSet 사용
    Set<Integer> numberSet = new HashSet<>();
    
    private boolean isPrime(int num) {
        // 0과 1은 소수가 아니므로 false 반환
        if (num < 2) {
            return false;
        }
        
        // 에라토스테네스의 체 원리 적용
        // 해당 숫자의 제곱근까지만 약수가 있는지 확인하면 됨
        int lim = (int)Math.sqrt(num);
        
        // 2부터 제곱근까지 나누어 떨어지는지 검사
        for (int i = 2; i <= lim; i++) {
            // 나누어 떨어지면 소수가 아님
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    // comb: 현재까지 만들어진 숫자 조합 (문자열)
    // others: 아직 사용하지 않은 남은 숫자 카드들
    private void recursive(String comb, String others) {
        
        // 현재 조합된 숫자가 빈 문자열이 아니면 Set에 추가
        if (!comb.equals("")) {
            // Integer.valueOf는 "011"을 11로 변환해주며 Set이 중복을 걸러줌
            numberSet.add(Integer.parseInt(comb));
        }
        
        // 남은 숫자 카드를 하나씩 가져와서 조합을 이어감
        for (int i = 0; i < others.length(); i++) {
            
            // i번째 카드를 사용했으므로, 이를 제외한 나머지 카드들을 추려냄
            // substring(0, i): i 앞부분 + substring(i+1): i 뒷부분
            String remain = others.substring(0, i) + others.substring(i + 1);
            
            // 현재 조합(comb)에 i번째 카드를 붙여서 새로운 조합 생성
            String newCom = comb + others.charAt(i);
            
            // 새로운 조합과 줄어든 남은 카드를 넘겨줌 -> DFS
            recursive(newCom, remain);
        }
    }
    
    public int solution(String numbers) {
        int answer = 0;
        
        // 모든 가능한 숫자의 조합을 재귀적으로 찾아서 numberSet에 저장
        // 초기 상태: 빈 문자열 "", 모든 숫자 카드가 남음
        recursive("", numbers);
        
        // Set에 저장된 모든 숫자를 하나씩 꺼내서 확인
        Iterator<Integer> it = numberSet.iterator();
        while(it.hasNext()) {
            int number = it.next();
            
            // 해당 숫자가 소수라면 정답 카운트 증가
            if (isPrime(number)) {
                answer++;
            }
        }
        
        return answer;
    }
}