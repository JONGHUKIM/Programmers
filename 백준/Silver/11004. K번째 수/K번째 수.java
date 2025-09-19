import java.util.*;
import java.io.*;

public class Main {
    
    private static void quickSort(int[] arr) {
        // 배열 전체(0번 인덱스부터 마지막 인덱스까지)를 대상으로 정렬을 시작
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        // 파티셔닝을 통해 피벗을 기준으로 배열을 나눔
        // part2는 오른쪽 파티션의 시작 인덱스가 된다
        int part2 = partition(arr, start, end);
    
        // 왼쪽 파티션에 정렬할 원소가 2개 이상 남아있는 경우 왼쪽 파티션을 재귀 호출
        if (start < part2 - 1) {
        // 오른쪽 파티션이 시작점에서 1개 이상 차이 날때만 함수 호출
            quickSort(arr, start, part2 - 1); // 왼쪽 파티션
        }
    
    // 오른쪽 파티션에 정렬할 원소가 2개 이상 남아있는 경우 오른쪽 파티션을 재귀 호출
        if (part2 < end) {
            quickSort(arr, part2, end); // 오른쪽 파티션
        }
    }

    private static int partition(int[] arr, int start, int end) {
        // 배열의 중앙에 있는 값을 피벗으로 선택
        int pivot = arr[(start + end) / 2];
    
        // start 포인터가 end 포인터와 엇갈릴 때까지 계속 진행
        while (start <= end) {
            // start 포인터는 피벗보다 크거나 같은 값을 찾을 때까지 오른쪽으로 이동
            while (arr[start] < pivot) start++;
        
            // end 포인터는 피벗보다 작거나 같은 값을 찾을 때까지 왼쪽으로 이동
            while (arr[end] > pivot) end--;
        
            // 두 포인터가 아직 엇갈리지 않았다면 두 원소를 swap하고
            // 다음 비교를 위해 각 포인터를 한 칸씩 이동시킨다
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        // 파티셔닝이 끝난 후 오른쪽 파티션의 시작점이 될 인덱스를 반환
        return start;
    }

    // 배열의 두 원소 위치를 교환하는 메소드.
    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
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
        System.out.println(a[k-1]);
        
        br.close();
    }
}