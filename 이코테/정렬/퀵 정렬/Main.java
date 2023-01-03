import java.util.*;

class Main {

  public static void main(String[] args) {
    int n = 10;
    int[] arr = {3, 1, 10, 2, 7, 4, 9, 5, 8, 6};

    quickSort(arr, 0, n - 1);

    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  // 퀵 정렬
  public static void quickSort(int[] arr, int start, int end) {
    if (start >= end) return;  // 원소가 1개인 경우 종료

    int pivot = start;  // 피벗은 첫 번째 원소
    int left = start + 1;
    int right = end;

    while (left <= right) {
      // 피벗보다 큰 데이터를 찾을 때까지 반복
      while (left <= end && arr[pivot] >= arr[left]) left++;
      // 피벗보다 작은 데이터를 찾을 때까지 반복
      while (right > start && arr[pivot] <= arr[right]) right--;

      if (left > right) swap(arr, pivot, right);  // 엇갈렸다면 작은 데이터와 피벗을 교체 
      else swap(arr, left, right);  // 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
    }
    // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
    quickSort(arr, start, right - 1);
    quickSort(arr, right + 1, end);
  }

  public static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}