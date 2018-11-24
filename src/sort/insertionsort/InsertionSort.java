package sort.insertionsort;

import sort.sorthelper.SortHelper;

/**
 * 插入排序算法
 */
public class InsertionSort {

    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int l, int r){

        for( int i = l + 1 ; i <= r ; i ++ ){
            Comparable e = arr[i];
            int j = i;
            //消除法
            for( ; j > l && arr[j-1].compareTo(e) > 0 ; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }
    public static void sort(Comparable[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            //寻找元素arr[i]合适的插入位置
            //写法一
//            for (int j = i; j > 0; j--)
//                if (arr[j].compareTo(arr[j - 1]) < 0)
//                    swap(arr, j, j - 1);
//                else
//                    break;

            //每次往后增加一个数，通过比较插入到合适的位置
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0 ; j--) {
                swap(arr, j, j - 1);
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
        SortHelper.testSort("sort.insertionsort.InsertionSort" , arr);
        return;
     }
}
