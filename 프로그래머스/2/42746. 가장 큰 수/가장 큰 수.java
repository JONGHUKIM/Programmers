import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (a, b) -> compareNum(a, b));
        
        if (arr[0].equals("0")) {
            return "0";
        }
        
        return String.join("", arr);
    }
    
    private static int compareNum(String a, String b) {
        String ab = a + b;
        String ba = b + a;
        
        return ba.compareTo(ab);
    }
}