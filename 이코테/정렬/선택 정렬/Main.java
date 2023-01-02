import java.util.*;

class Main {

  static int n = 10;
  static int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
  
  public static void main(String[] args) {
    // 선택 정렬
    for (int i = 0; i < n; i++) {
      int minIndex = i;  // 가장 작은 원소의 인덱스

      for (int j = i + 1; j < n; j++) {
        if (arr[minIndex] > arr[j]) minIndex = j;
      }

      swap(i, minIndex);
    }

    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void swap(int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}