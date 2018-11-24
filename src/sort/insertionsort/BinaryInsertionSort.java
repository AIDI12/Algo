package sort.insertionsort;

import sort.sorthelper.SortHelper;

/**
 * 二分插入排序算法
 */
public class BinaryInsertionSort {


    public static void sort(Comparable[] arr){
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            Comparable e = arr[i];
            int mid = 0;
            int r = i - 1;
            int l = 0;
            while( l < r ){
                mid = (r + l)/2;
                if (e.compareTo(arr[mid]) < 0){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
            for (int j = i; j > l ; j--) {
                swap(arr, j, j-1);
            }
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
        Integer[] arr = SortHelper.generateRandomArray( N, 0, 1000000);
        SortHelper.testSort("sort.insertionsort.BinaryInsertionSort" , arr);

        return;
     }
}
