class Solution {
    
    private int[] pos(int num) {
        if (num == 0) {
            return new int[]{3, 1};
        }
        int idx = num - 1;
        return new int[]{idx / 3, idx % 3};
    }
    
    private int dist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int[] leftPos = new int[]{3, 0};
        int[] rightPos = new int[]{3, 2};
        
        boolean rightPref = hand.equals("right");
        
        for (int num : numbers) {
            
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                leftPos = pos(num);
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                rightPos = pos(num);
            } else {
                int[] target = pos(num);
                
                int dl = dist(leftPos, target);
                int dr = dist(rightPos, target);
                
                if (dl < dr) {
                    sb.append("L");
                    leftPos = target;
                } else if (dr < dl) {
                    sb.append("R");
                    rightPos = target;
                } else {
                    if (rightPref) {
                        sb.append("R");
                        rightPos = target;
                    } else {
                        sb.append("L");
                        leftPos = target;
                    }
                }
            }
        }
        return sb.toString();
    }
}