package sort.shellsort;
import sort.sorthelper.SortHelper;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void sort(Comparable[] arr) {

        int n = arr.length;
        int h = 1;
        //初始增量，每次递增三倍
        while (h < n / 3){
            h = 3 * h + 1;
        }

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {
                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                Comparable e = arr[i];
                int j = i;
                //j = i = h
                //移除法进行插入排序
                for (; j >= h && e.compareTo(arr[j - h]) < 0; j -= h)
                    arr[j] = arr[j - h];
                arr[j] = e;
            }
            //缩小增量，递减三倍
            h /= 3;
        }

    }
    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortHelper.generateRandomArray(N, 0, 1000000);
        SortHelper.testSort("sort.shellsort.ShellSort" ,arr);
        return;
    }
}
