package sort.heapsort;

import sort.sorthelper.SortHelper;

/**
 * 堆排序——有辅助空间版——最大堆
 */
public class HeapSort2 {
    // 对整个arr数组使用HeapSort排序
    // HeapSort2, 将所有的元素依次添加到堆中, 在将所有元素从堆中依次取出来, 即完成了排序
    // 无论是创建堆的过程, 还是从堆中依次取出元素的过程, 时间复杂度均为O(nlogn)
    // 整个堆排序的整体时间复杂度为O(nlogn)
    //但是多了O(n)的空间复杂度
    public static void sort(Comparable[] arr){
        //计算数组长度
        int n = arr.length;
        //构建最大堆
        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(n);
        //插入数组数据
        for( int i = 0 ; i < n ; i ++ )
            maxHeap.insert(arr[i]);
        //依次取出堆顶
        for( int i = n-1 ; i >= 0 ; i -- )
            arr[i] = maxHeap.extractMax();
    }
    public static void sortMinHeap(Comparable[] arr){

        int n = arr.length;
        MinHeap<Comparable> minHeap = new MinHeap<Comparable>(n);
        for( int i = 0 ; i < n ; i ++ )
            minHeap.insert(arr[i]);

        for( int i = 0 ; i < n ; i ++ )
            arr[i] = minHeap.extractMin();
    }
    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortHelper.generateRandomArray(N, 0, 1000000);
        SortHelper.testSort("sort.heapsort.HeapSort2" ,arr);
        return;
    }
}
