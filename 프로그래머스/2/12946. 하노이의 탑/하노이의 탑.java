import java.util.*;

class Solution {
    
    private List<int[]> column;
    
    public int[][] solution(int n) {
        column = new ArrayList<>();
        
        hanoi(n, 1, 2, 3);
        
        return column.toArray(new int[column.size()][]);
    }
    
    private void hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            column.add(new int[]{start, end});
            return;
        }
        
        hanoi(n - 1, start, end, mid);
        
        column.add(new int[]{start, end});
        
        hanoi(n - 1, mid, start, end);
    }
}