package base;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {111,84,22,41,55,761,123,2325};
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    for (int k = i; k > j; k--) {
                        arr[k] = arr[k-1];
                    }
                    arr[j] = temp;
                }
            }
        }

        for(int n: arr) {
            System.out.println(n);
        }
    }
}
