// arr1      arr2

// 2 3 2     5 4 3
// 4 2 4     2 4 1
// 3 1 4     3 1 1

// c[0][0]
// (2 x 5 = 10) + (3 x 2 = 6) + (2 x 3 = 6) = 22
// c[0][1]
// (2 x 4 = 8) + (3 x 4 = 12) + (2 x 1 = 2) = 22

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;
        
        // 결과를 저장할 answer값
        int[][] answer = new int[r1][c2];
        // 행렬의 곱은 r1 = c2
        
        for (int i = 0; i < r1; i++) { // 행
            for (int j = 0; j < c2; j++) { // 열
                for (int k = 0; k < c1; k++) { // 두 수의 값 저장
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}