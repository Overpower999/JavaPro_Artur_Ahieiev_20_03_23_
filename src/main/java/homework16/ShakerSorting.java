package homework16;

public class ShakerSorting {
    public static void main(String[] args) {
        int[] arr = { 5, 8, 1, 3, 7, 9, 2 };
        int left = 0;
        int right = arr.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (arr[i - 1] > arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = tmp;
                }
            }
            left++;
        } while (left <= right);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
