import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 신고 당한 유저, 신고를 한 유저 (중복 제거를 위해 hashSet)
        HashMap<String, HashSet<String>> reportedUser = new HashMap<>();
        HashMap<String, Integer> mail = new HashMap<>();
        
        for (String r : report) {
            String[] s = r.split(" ");
            String userId = s[0];
            String reportedId = s[1];
            
            if (!reportedUser.containsKey(reportedId)) {
                reportedUser.put(reportedId, new HashSet<>());
            }
            
            reportedUser.get(reportedId).add(userId);
        }
        
        for (Map.Entry<String, HashSet<String>> entry : reportedUser.entrySet()) {
            if (entry.getValue().size() >= k) {
                for (String uid : entry.getValue()) {
                    mail.put(uid, mail.getOrDefault(uid, 0) + 1);
                }
            }
        }
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = mail.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}