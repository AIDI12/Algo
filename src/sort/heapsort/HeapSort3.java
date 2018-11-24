package sort.heapsort;

import sort.sorthelper.SortHelper;

/**
 * 堆排序——有辅助空间优化版——最大堆
 */
public class HeapSort3 {
    // 对整个arr数组使用HeapSort2排序
    // HeapSort3, 借助我们的heapify（堆化）过程创建堆
    // 此时, 创建堆的过程时间复杂度为O(n), 将所有元素依次从堆中取出来, 实践复杂度为O(nlogn)
    // 堆排序的总体时间复杂度依然是O(nlogn), 但是比HeapSort1性能更优, 因为创建堆的性能更优
    public static void sort(Comparable[] arr){

        int n = arr.length;
        //直接用数组创建堆
        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(arr);
        //取出堆顶
        for( int i = n-1 ; i >= 0 ; i -- )
            arr[i] = maxHeap.extractMax();
    }
    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortHelper.generateRandomArray(N, 0, 1000000);
        SortHelper.testSort("sort.heapsort.HeapSort3" ,arr);
        return;
    }
}
