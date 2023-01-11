package base;

import java.util.Arrays;

/**
 * Arrays工具类
 * @author summerKiss
 *
 */
public class ArraysTool {
    public static void main(String[] args) {
        int[] arr = {51,231,11,71,33};
        //展示数组
        System.out.println(Arrays.toString(arr));

        //排序 并且支持指定范围内排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        //二分查找
        System.out.println(Arrays.binarySearch(arr, 33));

        //填充
        Arrays.fill(arr, 111);
        System.out.println(Arrays.toString(arr));

        //复制
        int[] arr1 = {1,2,4,5,6};
        int[] arr2 = Arrays.copyOfRange(arr1, 2, 4);
        System.out.println(Arrays.toString(arr2));
        System.out.println(arr1);
        System.out.println(arr2);

        System.out.println("fourth");
    }
}
