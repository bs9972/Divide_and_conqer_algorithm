import java.util.Arrays;
import java.util.Random;

public class Divide_and_conquer {
    static final int N = 10;

    public static void main(String[] args) {
        Random random = new Random();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = random.nextInt(1000);
        }

        System.out.println("퀵정렬 전: " + Arrays.toString(arr));
        quickSort(0, N - 1, arr);
        System.out.println("퀵정렬 후: " + Arrays.toString(arr));
    }

    private static void quickSort(int s, int e, int[] arr) {
        if (s >= e)
            return;

        int left = s + 1, right = e;
        int pivot = arr[s];

        while (left <= right) {
            while (left <= e && arr[left] <= pivot)
                left++;
            while (right > s && arr[right] >= pivot)
                right--;

            if (left <= right) {
                swap(arr, left, right);
            } else {
                swap(arr, s, right);
            }
        }
        quickSort(s, right - 1, arr);
        quickSort(right + 1, e, arr);
    }
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}