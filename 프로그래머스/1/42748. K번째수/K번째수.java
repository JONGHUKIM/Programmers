import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int k = commands[i][2] - 1;
            
            // 자른 배열
            int[] temp = Arrays.copyOfRange(array, start, end);
            // 정렬
            Arrays.sort(temp);
            // K번째 수 뽑기
            answer[i] = temp[k];
        }
        
        return answer;
    }
}