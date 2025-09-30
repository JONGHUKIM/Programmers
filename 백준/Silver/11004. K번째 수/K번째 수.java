import java.util.*;
import java.io.*;

public class Main {
    
    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    
    private static void quickSort(int[] arr, int start, int end) {
        int part2 = partition(arr, start, end);
        
        if (start < part2 - 1) {
            quickSort(arr, start, part2 - 1);
        }
        if (part2 < end) {
            quickSort(arr, part2, end);
        }        
    }
    
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start + (end - start) / 2];
        
        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            if (start <= end) {
                swap (arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }
    
    private static void swap(int[] arr, int start, int end) {
        int tem = arr[start];
        arr[start] = arr[end];
        arr[end] = tem;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        quickSort(a);
        bw.write(String.valueOf(a[k-1]));
        bw.flush();
        bw.close();
        br.close();
        
    }
}