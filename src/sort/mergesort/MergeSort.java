package sort.mergesort;

import sort.sorthelper.SortHelper;

import java.util.Arrays;

/**
 * 归并排序——分治法
 */
public class MergeSort {
    //外层包装
    public static void sort(Comparable[] arr){
        int n = arr.length;
        sort(arr, 0, n-1);
    }
    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r){
            return;
        }
        //分割成两部分
        //用l+(r-l)/2 的形式防止溢出
        int mid = l + (r-l)/2;
        sort(arr, l, mid);
        sort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }
    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        //复制数组
        // 其中aux为完成merge过程所需要的辅助空间
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid+1;
        for (int k = l; k <= r; k++) {

            if (i > mid) { // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l];
                j++;
            } else if (j > r) { // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l];
                i++;
            } else if( aux[i-l].compareTo(aux[j-l]) < 0 ){  // 左半部分所指元素 < 右半部分所指元素,后面两两步是归并比较
                arr[k] = aux[i-l];
                i ++;
            } else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l];
                j ++;
            }
        }
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortHelper.generateRandomArray(N, 0, 1000000);
        SortHelper.testSort("sort.mergesort.MergeSort" ,arr);
        return;
    }

}
