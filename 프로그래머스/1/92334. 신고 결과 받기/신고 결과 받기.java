import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // <신고당한 유저, 그 유저를 신고한 사람들 목록> 을 저장하는 맵
        // ex) "muzi" -> ["frodo", "apeach"]
        HashMap<String, HashSet<String>> reportedUser = new HashMap<>();
        
        // <메일을 받은 유저, 받은 메일 수>
        // 처리 결과가 나왔을 때, 몇 번 메일이 가는지 저장
        HashMap<String, Integer> mail = new HashMap<>();
        
        // report 하나씩 순회
        for (String r : report) {
            // 신고 문자열 예: "muzi frodo"
            // 앞: 신고한 사람, 뒤: 신고당한 사람
            String[] s = r.split(" ");
            String userId = s[0];     // 신고한 사람
            String reportedId = s[1]; // 신고당한 사람
            
            // 신고당한 사람이 처음 등장하면 초기화
            if (!reportedUser.containsKey(reportedId)) {
                reportedUser.put(reportedId, new HashSet<>());
            }
            
            // 신고당한 유저의 맵에 신고한 사람을 추가
            // HashSet이므로 똑같은 사람이 여러 번 신고해도 중복제거
            reportedUser.get(reportedId).add(userId);
        }
        
        // 각 신고당한 유저가 몇 명에게 신고받았는지 확인
        for (Map.Entry<String, HashSet<String>> entry : reportedUser.entrySet()) {
            
            // entry.getValue() = 신고한 사람들 목록
            // entry.getValue().size() = 신고자 수
            if (entry.getValue().size() >= k) { 
                // 정지 기준(k명 이상 신고)을 넘겼다면
                
                // 이 유저를 신고한 사람들에게 모두 메일에 +1
                for (String uid : entry.getValue()) {
                    mail.put(uid, mail.getOrDefault(uid, 0) + 1);
                }
            }
        }
        
        // id_list 순서대로 메일 개수를 배열에 담기
        int[] answer = new int[id_list.length];
        
        for (int i = 0; i < id_list.length; i++) {
            // mail 맵에 없으면 0으로 처리
            answer[i] = mail.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}
