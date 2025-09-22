import java.util.*;
import java.io.*;

public class Main {
    
    private static void mergeSort(int[] arr) {
        int[] tem = new int[arr.length];
        mergeSort(arr, tem, 0, arr.length - 1);
    }
    
    private static void mergeSort(int[] arr, int[] tem, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, tem, start, mid);
            mergeSort(arr, tem, mid + 1, end);
            merge(arr, tem, start, mid, end);
        }
    }
    
    private static void merge(int[] arr, int[] tem, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tem[i] = arr[i];
        }
        
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        
        while (part1 <= mid && part2 <= end) {
            if (tem[part1] <= tem[part2]) {
                arr[index] = tem[part1];
                part1++;
            } else {
                arr[index] = tem[part2];
                part2++;
            }
            index++;
        }
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tem[part1 + i];
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        
        mergeSort(a);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(a[i]).append("\n");
        }
        System.out.print(sb.toString());
    }
}