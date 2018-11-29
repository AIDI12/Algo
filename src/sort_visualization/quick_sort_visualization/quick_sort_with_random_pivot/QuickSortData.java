package sort_visualization.quick_sort_visualization.quick_sort_with_random_pivot;

import java.util.Arrays;

/**
 * 快速排序数据模型
 */
public class QuickSortData {
    /**
     * 排序类型
     */
    public enum Type{
        Default,         //默认
        NearlyOrdered    //近乎有序
    }

    private int[] numbers;              //待排序数组
    public int l, r;                    //左右标志
    public boolean[] fixedPivots;       //已经排好序的标志
    public int curPivot;                //当前基准点标志
    public int curElement;              //当前排序元素

    /**
     * 构造方法——生成随机数组
     * @param N
     * @param randomBound
     * @param dataType
     */
    public QuickSortData(int N, int randomBound, Type dataType){

        numbers = new int[N];
        fixedPivots = new boolean[N];

        for( int i = 0 ; i < N ; i ++) {
            numbers[i] = (int)(Math.random()*randomBound) + 1;
            fixedPivots[i] = false;
        }

        if(dataType == Type.NearlyOrdered){
            Arrays.sort(numbers);
            int swapTime = (int)(0.01*N);
            for(int i = 0 ; i < swapTime; i ++){
                int a = (int)(Math.random()*N);
                int b = (int)(Math.random()*N);
                swap(a, b);
            }
        }
    }

    public QuickSortData(int N, int randomBound){
        this(N, randomBound, Type.Default);
    }

    /**
     * 返回数组长度
     * @return
     */
    public int N(){
        return numbers.length;
    }

    /**
     * 获取数组元素
     * @param index
     * @return
     */
    public int get(int index){
        if( index < 0 || index >= numbers.length){
            throw new IllegalArgumentException("Invalid index to access Sort Data.");
        }
        return numbers[index];
    }

    /**
     * 交换
     * @param i
     * @param j
     */
    public void swap(int i, int j) {

        if( i < 0 || i >= numbers.length || j < 0 || j >= numbers.length)
            throw new IllegalArgumentException("Invalid index to access Sort Data.");

        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }
}
