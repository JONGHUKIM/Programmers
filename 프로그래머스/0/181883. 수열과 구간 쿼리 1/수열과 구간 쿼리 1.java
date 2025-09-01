class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] diff = new int[n + 1];

        for (int[] q : queries) {
            int s = q[0];
            int e = q[1];
            diff[s] += 1;
            if (e + 1 < n) diff[e + 1] -= 1;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            arr[i] += sum;
        }

        return arr;
    }
}
