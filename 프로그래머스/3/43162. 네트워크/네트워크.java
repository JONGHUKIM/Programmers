class Solution {
    
    int node;
    int[][] computers;
    boolean[] visited;
    
    private void dfs(int index) {
        visited[index] = true;
        
        for (int i = 0; i < node; i++) {
            if (computers[index][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        this.node = n;
        this.computers = computers;
        
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }
        
        return answer;
    }
}