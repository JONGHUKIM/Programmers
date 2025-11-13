import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // 정답 배열이 다르기에 ArrayList로 선언
        ArrayList<String> answer = new ArrayList<>();
        // id는 고정, name값은 바뀌면 기존 name값도 변경이 되어야함
        // 키(id)값으로 value(name)값을 불러와야 하기에 HashMap선언
        HashMap<String, String> idMap = new HashMap<>();
        
        // 최신 ID와 NAME값을 저장
        for (String str : record) {
            // 공백으로 단어는 구분 되어있어 StringTokenizer 선언
            StringTokenizer st = new StringTokenizer(str);
            // 제일 처음 입력받는 명령어 처리
            String cmd = st.nextToken();
            // 명령어가 Enter or Change라면
            if (cmd.equals("Enter") || cmd.equals("Change")) {
                // id, name 처리
                String id = st.nextToken();
                String name = st.nextToken();
                // 입력 받은 id, name 저장
                idMap.put(id, name);
            }
        }
        
        // 채팅방을 순회하며 처리
        for (String str : record) {
            StringTokenizer st = new StringTokenizer(str);
            String cmd = st.nextToken();
            
            // 명령어가 Enter or Leave라면 answer에 최신 키(id)값으로 저장
            if (cmd.equals("Enter")) {
                String id = st.nextToken();
                answer.add(idMap.get(id) + "님이 들어왔습니다.");
            } else if (cmd.equals("Leave")) {
                String id = st.nextToken();
                answer.add(idMap.get(id) + "님이 나갔습니다.");            }
        }
        
        return answer.stream().toArray(String[]::new);
    }
}