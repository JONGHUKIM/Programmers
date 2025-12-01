class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer;

        for (answer = 0; a != b; answer++) {
            // 부모 = (자식 + 1) / 2
            a = (a + 1) / 2;
            b = (b + 1) / 2;                
        }

        return answer;
    }
}