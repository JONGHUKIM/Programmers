import java.util.*;
import java.io.*;

public class Main {
    
    static long count;
    
    private static void mergeSort(int[] arr) {
        int[] tem = new int[arr.length]; // 머지소트를 위한 임시배열
        mergeSort(arr, tem, 0, arr.length - 1);
    }
    
    // mergeSort 재귀함수 생성
    private static void mergeSort(int[] arr, int[] tem, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2; // 오버 플로우 방지
            mergeSort(arr, tem, start, mid);
            mergeSort(arr, tem, mid + 1, end);
            merge(arr, tem, start, mid, end);
        }
    }
    
    // merge 재귀함수 생성
    private static void merge(int[] arr, int[] tem, int start, int mid, int end) {
        // 임시배열에 복사
        for (int i = start; i <= end; i++) {
            tem[i] = arr[i];
        }
        
        // 시작 포인터 설정
        int part1 = start;
        int part2 = mid + 1;
        // 현재 저장할 인덱스 설정
        int index = start;
        
        // 시작 포인터가 끝 포인터에 도달할 때까지 반복
        while (part1 <= mid && part2 <= end) {
            if (tem[part1] <= tem[part2]) {
                arr[index] = tem[part1];
                part1++;
            } else {
                arr[index] = tem[part2];
                part2++;
                count += (mid - part1 + 1); // 여기서 count++
            }
            index++;
        }
        // 앞의 데이터가 남으면 채워줌
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tem[part1 + i]; 
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        
        StringTokenizer st = 
            new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        mergeSort(a);
        System.out.println(count);
        br.close();
    }
}