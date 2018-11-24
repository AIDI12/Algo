package sort.quicksort;

import sort.insertionsort.InsertionSort;
import sort.sorthelper.SortHelper;

/**
 * 快速排序——三路快排
 */
public class QuickSort3Ways {
    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r){

        // 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l, (int)(Math.random()*(r-l+1)) + l );

        Comparable v = arr[l];

        int lt = l;     // arr[l+1...lt] < v，左标记
        int gt = r + 1; // arr[gt...r] > v，右标记
        int i = l+1;    // arr[lt+1...i) == v，基准点比较标记

        while( i < gt ){
            //小于基准点
            if( arr[i].compareTo(v) < 0 ){
                //交换比较点和左标记
                swap( arr, i, lt+1);
                //基准点向后移
                i ++;
                lt ++;
            }
            else if( arr[i].compareTo(v) > 0 ){//大于基准点
                //交换比较点和右标记
                swap( arr, i, gt-1);
                //右标记前移
                gt --;
            }
            else{ // arr[i] == v
                //基准点标记往后移
                i ++;
            }
        }

        swap( arr, l, lt );

        sort(arr, l, lt-1);
        sort(arr, gt, r);
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        sort(arr, 0, n-1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortHelper.generateRandomArray( N, 0, 1000000);
        SortHelper.testSort("sort.quicksort.QuickSort3Ways" , arr);
        return;
    }
}
