import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        ArrayList<Double> avgScores = new ArrayList();
        
        for (int i = 0; i < score.length; i++) {
            double avg = (double) (score[i][0] + score[i][1]) / 2;
            avgScores.add(avg);
        }
        
        int[] ranks = new int[score.length];
        
        for (int i = 0; i < score.length; i++) {
            int rank = 1;
            for (int j = 0; j < score.length; j++) {
                if (avgScores.get(i) < avgScores.get(j)) {
                    rank++;
                }
            }
            ranks[i] = rank;
        }
        
        return ranks;
    }
}