class Solution {
    public long solution(int a, int b) {
        if ( a == b ) {
            return a;
        } 
        
        long startNum = Math.min(a, b);
        long endNum = Math.max(a, b);
        
        return (startNum + endNum) * (endNum - startNum + 1) / 2;
    }
}