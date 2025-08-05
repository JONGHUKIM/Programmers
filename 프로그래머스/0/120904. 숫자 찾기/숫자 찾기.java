class Solution {
    public int solution(int num, int k) {
        String strNum = String.valueOf(num);
        String strK = String.valueOf(k);
        
        int index = strNum.indexOf(strK);
        
        if (index != -1) {
            return index + 1;
        } else {
            return -1;
        }
    }
}