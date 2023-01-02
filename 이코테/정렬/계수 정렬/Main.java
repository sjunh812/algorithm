import java.util.*;

class Main {

  public static void main(String[] args) {
    // 계수 정렬
    // 모든 원소의 값이 0보다 크거나 같다고 가정
    int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
    // 모든 범위를 포함하는 배열 선언(모든 값은 0으로 초기화)
    int[] cnt = new int[10];  

    for (int i = 0; i < arr.length; i++) {
      cnt[arr[i]]++;  // 각 데이터에 해당하는 인덱스의 값 증가 
    }

    for (int i = 0; i < cnt.length; i++) {  // 배열에 기록된 정렬 정보 확인
      for (int j = 0; j < cnt[i]; j++) {
        System.out.print(i + " ");
      }
    }
  }
}