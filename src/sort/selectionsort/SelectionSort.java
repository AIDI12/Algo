package sort.selectionsort;

import sort.sorthelper.SortHelper;

/**
 * 选择排序
 */
public class SelectionSort {
    //主算法
    public static void sort(Comparable[] arr){
        int n  = arr.length;
        //选择第一个数
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            //依次向后比较，
            for (int j = i + 1; j < n; j++) {
                //如果比较的数比之前选择的数小，则将比较的数的索引置为最小的索引
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            //交换选择的数和最小的数
            swap(arr , i ,minIndex);
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
        SortHelper.testSort("sort.selectionsort.SelectionSort" ,arr);
        return;
    }
}