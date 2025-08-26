import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        // 누적된 값이 최소 (최솟값 * 최댓값)
        Arrays.sort(A);
        Arrays.sort(B);
        
        int x = 0;
        
        for ( int i = 0; i < A.length; i++) {
            x += A[i] * B[B.length - 1 - i];
        }
        
        return x;
        
    }
}