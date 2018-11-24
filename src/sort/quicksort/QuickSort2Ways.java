package sort.quicksort;

import sort.insertionsort.InsertionSort;
import sort.sorthelper.SortHelper;

/**
 * 快速排序——双路快排
 */
public class QuickSort2Ways {
    // 双路快速排序的partition
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r){

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );

        Comparable v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l+1, j = r;
        while( true ){
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            // 思考一下为什么?
            while( i <= r && arr[i].compareTo(v) < 0 )
                i ++;

            // 注意这里的边界, arr[j].compareTo(v) > 0, 不能是arr[j].compareTo(v) >= 0
            //这是因为对于连续出现相等的情况，>/<方式会交换i和j的值；而<=/>=方式则会将连续出现的这些值归为其中一方，使得两棵子树不平衡
            while( j >= l+1 && arr[j].compareTo(v) > 0 )
                j --;

            if( i > j )
                break;

            swap( arr, i, j );
            i ++;
            j --;
        }

        swap(arr, l, j);

        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r){

        // 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p-1 );
        sort(arr, p+1, r);
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
        SortHelper.testSort("sort.quicksort.QuickSort2Ways" , arr);
        return;
    }
}
