import java.util.*;

class Main {

  static int n = 10;
  static int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
  
  public static void main(String[] args) {
    // 삽입 정렬
    for (int i = 1; i < n; i++) {
      // 인덱스 i부터 1까지 감소하면서 반복
      for (int j = i; j > 0; j--) {
        // 한 칸씩 왼쪽으로 이동
        if (arr[j] <= arr[j - 1]) swap(j, j - 1);
        else break;  // 자기보다 작은 데이터를 만나면 그 위치에서 멈춤
      }
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