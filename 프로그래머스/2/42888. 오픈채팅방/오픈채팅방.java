import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, String> idMap = new HashMap<>();
        
        // 최신 기록을 저장
        for (String str : record) {
            StringTokenizer st = new StringTokenizer(str);
            String cmd = st.nextToken();
            
            if (cmd.equals("Enter") || cmd.equals("Change")) {
                String id = st.nextToken();
                String name = st.nextToken();
                idMap.put(id, name);
            }
        }
        
        // 최신 기록을 순회하며 메시지 출력
        for (String str : record) {
            StringTokenizer st = new StringTokenizer(str);
            String cmd = st.nextToken();
            
            if (cmd.equals("Enter")) {
                String id = st.nextToken();
                answer.add(idMap.get(id) + "님이 들어왔습니다.");
            } else if (cmd.equals("Leave")) {
                String id = st.nextToken();
                answer.add(idMap.get(id) + "님이 나갔습니다.");
            }
        }
        
        return answer.stream().toArray(String[]::new);
    }
}