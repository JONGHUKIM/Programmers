import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        
        Map<String, String> map = new HashMap<>();
        
        for (String str : record) {
            StringTokenizer st = new StringTokenizer(str);
            String cmd = st.nextToken();
            
            if (cmd.equals("Enter") || cmd.equals("Change")) {
                String id = st.nextToken();
                String pw = st.nextToken();
                map.put(id, pw);
            }
        }
        
        for (String str : record) {
            StringTokenizer st = new StringTokenizer(str);
            String cmd = st.nextToken();
            
            if (cmd.equals("Enter")) {
                String id = st.nextToken();
                answer.add(map.get(id) + "님이 들어왔습니다.");
            } else if (cmd.equals("Leave")) {
                String id = st.nextToken();
                answer.add(map.get(id) + "님이 나갔습니다.");
            }
        }
        
        
        return answer.toArray(new String[0]);
    }
}