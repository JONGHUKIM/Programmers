import java.util.*;
import java.io.*;

public class Main {

    private static void mergeSort (int[] arr) {
        // 정렬된 값을 임시로 저장할 배열을 원본 배열과 같은 크기로 생성
        int[] temp =  new int[arr.length];
        
        // 배열 전체(0 ~ n-1)를 분할 및 병합 작업을 시작
        mergeSort(arr, temp, 0, arr.length - 1);
    }
    
    private static void mergeSort(int[] arr, int[] temp, int start, int end) {
        // 시작점이 끝점보다 작을 때만(분할할 원소가 2개 이상일 때만) 재귀 호출
        if (start < end) {
            // 현재 배열의 중앙 인덱스를 계산
            int mid = start+(end-start) / 2; // 오버플로우 방지
            
            // 왼쪽 부분 배열을 재귀적으로 다시 분할
            mergeSort(arr, temp, start, mid);
            // 오른쪽 부분 배열을 재귀적으로 다시 분할
            mergeSort(arr, temp, mid + 1, end);
            
            // 분할된 두 부분 배열을 정렬하면서 하나로 합침
            merge(arr, temp, start, mid, end);
        }
    }
    
    private static void merge(int[] arr, int[] temp, int start, int mid, int end) {
         // 비교 작업을 위해 현재 범위의 원본 배열 내용을 임시 배열로 복사
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        
        // 왼쪽 부분 배열을 가리키는 포인터
        int part1 = start;
        // 오른쪽 부분 배열을 가리키는 포인터
        int part2 = mid + 1;
        // 원본 배열에 정렬된 값을 채워 넣을 위치를 가리키는 인덱스
        int index = start;
        
        // 두 부분 배열 중 하나의 포인터가 끝에 도달할 때까지 반복
        while (part1 <= mid && part2 <= end) {
            // 왼쪽 배열의 값이 오른쪽 배열의 값보다 작거나 같으면
            if (temp[part1] <= temp[part2]) {
                // 왼쪽 값을 원본 배열에 넣고 왼쪽 포인터를 한 칸 이동
                arr[index] = temp[part1];
                part1++;
            } else {
                // 오른쪽 배열의 값이 더 작으면
                // 오른쪽 값을 원본 배열에 넣고 오른쪽 포인터를 한 칸 이동
                arr[index] = temp[part2];
                part2++;
            }
            // 원본 배열에 값을 하나 채웠으므로 다음 위치로 인덱스 이동
            index++;
        }
        
        // 위의 while문이 끝나면 둘 중 한쪽 배열의 원소는 모두 사용된 상태
        // 아직 남아있는 다른 쪽 배열의 원소들을 그대로 원본 배열의 뒤쪽에 이어 붙인다
        // 왼쪽 배열에 원소가 남아있는 경우 처리 (오른쪽 배열은 이미 다 채워져 있으므로 신경 쓸 필요 없음)
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = temp[part1 + i];
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
        System.out.print(sb);
        
    }
}