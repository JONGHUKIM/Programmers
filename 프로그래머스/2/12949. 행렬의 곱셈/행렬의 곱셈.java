class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;
        
        int[][] answer = new int[r1][c2];
        // 행렬의 곱은 c1 == r2 ( r1 * c2 의 행렬이 만들어짐 )
        
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    // 첫 번째 열과 두번 째 행이 같아야 곱셈 가능
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}