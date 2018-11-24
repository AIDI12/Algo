package sort.selectionsort;

import sort.sorthelper.SortHelper;

/**
 * 选择排序改良版
 * 在每一轮中, 可以同时找到当前未处理元素的最大值和最小值
 */
public class SelectionSort2 {
    //主算法
    public static void sort(Comparable[] arr){
        int right  = arr.length - 1,left = 0;
        while (left < right){
            int minIndex = left;
            int maxIndex = right;
            // 在每一轮查找时, 要保证arr[minIndex] <= arr[maxIndex]
            if (arr[minIndex].compareTo(arr[maxIndex]) > 0){
                swap(arr, minIndex, maxIndex);
            }
            for (int i = left + 1; i < right; i++) {
                if (arr[i].compareTo(arr[minIndex]) < 0) {
                    minIndex = i;
                }
                if(arr[i].compareTo(arr[maxIndex]) > 0){
                    maxIndex = i;
                }
            }
            swap(arr, left, minIndex);
            swap(arr, right, maxIndex);

            left++;
            right--;
        }
    }

    /**
     * 交换方法
     */
    private static void swap(Object[] arr, int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortHelper.generateRandomArray(N, 0, 1000000);
        SortHelper.testSort("sort.selectionsort.SelectionSort2" ,arr);
        return;
    }
}
