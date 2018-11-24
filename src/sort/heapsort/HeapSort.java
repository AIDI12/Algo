package sort.heapsort;

import sort.sorthelper.SortHelper;

/**
 * 堆排序——最大堆
 */
public class HeapSort {
    // 不使用一个额外的最大堆, 直接在原数组上进行"原地"的堆排序
    public static void sort(Comparable[] arr){
        int n = arr.length;
        // 注意，此时我们的堆是从0开始索引的
        // 从(最后一个元素的索引-1)/2开始
        //在0 - （n-1-1）/2的范围内建堆
        // 最后一个元素的索引 = n-1
        for( int i = (n-1-1)/2 ; i >= 0 ; i -- )
            shiftDown2(arr, n, i);
        //每次堆中0号位置上的最大值交换到末尾
        for( int i = n-1; i > 0 ; i-- ){
            swap( arr, 0, i);
            //重新建堆
            shiftDown2(arr, i, 0);
        }
    }

    // 交换堆中索引为i和j的两个元素
    private static void swap(Object[] arr, int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 原始的shiftDown过程
     * @param arr
     * @param n
     * @param k
     */
    private static void shiftDown(Comparable[] arr, int n, int k){
        //左子树的索引小于数组长度
        while( 2*k+1 < n ){
            //j=左子树
            int j = 2*k+1;
            //当右子树大于左子树
            if( j+1 < n && arr[j+1].compareTo(arr[j]) > 0 ){
                //j=右子树，即左右子树最大者
                j += 1;
            }
            //根节点大于等于左子树
            if( arr[k].compareTo(arr[j]) >= 0 ){
                break;
            }
            //交换根节点和最大孩子节点
            swap( arr, k, j);

            k = j;
        }
    }

    /**
     * 优化的shiftDown过程, 使用赋值的方式取代不断的swap,
     * 该优化思想和我们之前对插入排序进行优化的思路是一致的
     * @param arr 数组
     * @param n 堆索引范围
     * @param k 根节点
     */
    private static void shiftDown2(Comparable[] arr, int n, int k){
        //根节点
        Comparable e = arr[k];
        while( 2*k+1 < n ){
            int j = 2*k+1;
            if( j+1 < n && arr[j+1].compareTo(arr[j]) > 0 )
                j += 1;

            if( e.compareTo(arr[j]) >= 0 )
                break;
            //赋值
            arr[k] = arr[j];
            k = j;
        }
        //移除法
        arr[k] = e;
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortHelper.generateRandomArray(N, 0, 1000000);
        SortHelper.testSort("sort.heapsort.HeapSort" ,arr);
        return;
    }
}
