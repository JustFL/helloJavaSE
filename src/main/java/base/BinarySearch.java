package base;

/**
 * 二分查找
 * @author summerKiss
 *
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {111,84,22,41,55,761,123,2325};

        //排序
        int[] sortedArr = BubbleSort.sort(arr);

        //使用while循环实现
        int value = 33;
        int start = 0;
        int end = sortedArr.length - 1;
        int middle = (start + end) / 2;
        boolean exist = true;
        while(sortedArr[middle] != value) {
            if (sortedArr[middle] > value) {
                end = middle - 1;
            }else if(sortedArr[middle] < value) {
                start = middle + 1;
            }
            if(start > end) {
                exist = false;
                break;
            }
            middle = (start + end) / 2;
        }

        System.out.println(exist);

        //System.out.println(search(sortedArr,0,sortedArr.length-1, 55));
    }


    //使用递归
    public static boolean search(int[] arrs, int start, int end, int value) {
        boolean exist = false;

        if (start > end) {
            exist=false;
            return exist;
        }

        int middle = (start + end) / 2;

        if (arrs[middle] > value) {
            exist = search(arrs, start, middle-1, value);
        }else if(arrs[middle] < value) {
            exist = search(arrs, middle+1, end, value);
        }else {
            exist=true;
        }

        return exist;
    }
}
