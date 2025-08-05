class Solution {
    public String solution(String rsp) {
        // 가위 2 바위 0 보 5
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < rsp.length(); i++) {
            char myMove = rsp.charAt(i);
            
            switch(myMove) {
                case '2':
                    answer.append('0');
                    break;
                case '0':
                    answer.append('5');
                    break;
                case '5':
                    answer.append('2');
                    break;
            }
        }
        return answer.toString();
    }
}