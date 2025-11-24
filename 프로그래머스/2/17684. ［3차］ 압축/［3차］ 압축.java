import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 사전 초기화
        Map<String, Integer> map = new HashMap<>();        
        // 사전에 넣을 때 사용할 인덱스
        int idx = 1; 
        
        for (char c = 'A'; c <= 'Z'; c++) {
            String s = String.valueOf(c);
            map.put(s, idx++); // ex) A = 1, B = 2 
        }
        
        // 정답을 임시로 담아 둘 리스트 선언
        ArrayList<Integer> answer = new ArrayList<>();
        
        // msg의 시작 인덱스
        int start = 0;
        
        // msg를 처음부터 끝까지 탐색
        while (start < msg.length()) {
            
            // 현재까지 찾은 사전에 있는 가장 긴 문자열
            String w = "";             
            int end = start + 1;
            
            // start ~ end 구간의 문자열이 사전에 있으면,
            // 계속 end를 키워가며 가장 긴 문자열 확인
            // ex) msg = KAKAO, start=0 이면
            // end=1, "K"   -> 사전에 있음
            // end=2, "KA"  -> 처음에는 없음
            // 그래서 "K"가 w가 됨
            while (end <= msg.length() && 
                  // msg.substring(start, end): start부터 end-1까지 자른 문자열이
                  // 사전에 있는지 확인
                  map.containsKey(msg.substring(start, end))) {
                
                // 현재까지 사전에 존재하는 문자열을 w에 저장
                w = msg.substring(start, end);
                // 더 긴 문자열이 사전에 있는지 확인하기 위해 end를 1 증가
                end++;                
            }
            
            //    위의 while문이 끝났다는 뜻은
            //    더 이상 사전에 없는 문자열을 만났거나
            //    문자열 끝까지 온 것임
            //    그 직전까지의 w는 사전에서 찾은 가장 긴 문자열 상태
            //    -> 그 w에 해당하는 사전 번호를 정답에 추가
            answer.add(map.get(w));
            
            //    새로운 단어 (w + 다음 글자) 를 사전에 추가
            //    end는 현재 사전에 없는 상태까지 증가된 값
            //    start~end 구간은 w + 다음 글자에 해당
            //
            //    예: w="K", start=0, end=2 이면
            //    msg.substring(0,2) = "KA" -> 새 단어
            if (end <= msg.length()) { 
                String wc = msg.substring(start, end); // w + 다음 글자
                map.put(wc, idx++);                   // 사전에 새로 등록 (새 번호 할당)
            }
            
            //    start를 w의 길이만큼 앞으로 이동
            //    우리는 w를 이미 처리했으니 그 다음 위치부터 다시 탐색
            //
            //    예: w="K" (길이 1) 이면 start = 0 + 1 = 1 이 되어 다음 글자부터 진행
            start += w.length();
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}