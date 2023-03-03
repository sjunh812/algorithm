import java.util.*;
import java.io.*;

class Main {

  long answer = 0;

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    mergeSort(arr);

    System.out.println(answer);
  }

  public int[] copyArray(int[] arr, int start, int end) {
    int[] copyArray = new int[end - start + 1];
    
    for (int i = 0; i <= end - start; i++) {
      copyArray[i] = arr[start + i];
    }
    
    return copyArray;
  }

  public int[] mergeSort(int[] arr) {
    if (arr.length > 1) {
      int mid = arr.length / 2;
      return merge(mergeSort(copyArray(arr, 0, mid - 1)), mergeSort(copyArray(arr, mid, arr.length - 1)));
    }

    return arr;
  }

  public int[] merge(int[] arr1, int[] arr2) {
    int[] mergeArray = new int[arr1.length + arr2.length];
    int i = 0;
    int j = 0;
    int index = 0;
    
    while (true) {
      if (i == arr1.length) {
        for (; j < arr2.length; j++) {
          mergeArray[index++] = arr2[j];
        }
        break;
      }

      if (j == arr2.length) {
        for (; i < arr1.length; i++) {
          mergeArray[index++] = arr1[i];
        }
        break;
      }

      if (arr1[i] <= arr2[j]) {
        mergeArray[index++] = arr1[i++];
      } else {
        mergeArray[index++] = arr2[j++];
        answer += arr1.length - i;
      }
    }

    return mergeArray;
  }
}