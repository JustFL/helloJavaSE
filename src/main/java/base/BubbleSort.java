package base;

import java.util.Arrays;

/**
 * 冒泡排序
 * */
public class BubbleSort {
    public static void main(String[] args) {

        int[] arrs = {12,84,98,25,84,38,71,41,53,66,36,55};
        BubbleSort.sort(arrs);
        System.out.println(Arrays.toString(arrs));
    }

    public static int[] sort(int arrs[]) {
        for (int i = 0; i < arrs.length-1; i++) {
            for (int j = 0; j < arrs.length-1-i; j++) {
                if (arrs[j] > arrs[j+1]) {
                    int temp = arrs[j+1];
                    arrs[j+1] = arrs[j];
                    arrs[j] = temp;
                }
            }
        }

        return arrs;
    }
}
