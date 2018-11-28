package sort_visualization.insertion_sort_visualization;

import java.util.Arrays;

/**
 * 插入排序数据
 */
public class InsertionSortData {
    /**
     * 排序类型
     */
    public enum Type{
        Default,         //默认排序
        NearlyOrdered    //近乎有序
    }

    private int[] numbers;         //排序数组长度
    public int orderedIndex;       //已经排序好的部分的尾下标
    public int currentIndex;       //当前待排序的下标

    /**
     * 构造插入排序数据模型
     * @param N  数组长度
     * @param randomBound   数据范围
     * @param dataType
     */
    public InsertionSortData(int N, int randomBound, Type dataType){

        numbers = new int[N];
        //生成随机数组
        for( int i = 0 ; i < N ; i ++)
            numbers[i] = (int)(Math.random()*randomBound) + 1;
        //生成近乎有序的数组
        if(dataType == Type.NearlyOrdered){
            Arrays.sort(numbers);
            int swapTime = (int)(0.02*N);
            for(int i = 0 ; i < swapTime; i ++){
                int a = (int)(Math.random()*N);
                int b = (int)(Math.random()*N);
                swap(a, b);
            }
        }
    }

    public InsertionSortData(int N, int randomBound){
        this(N, randomBound, Type.Default);
    }

    /**
     * 获取数组长度
     * @return
     */
    public int N(){
        return numbers.length;
    }

    /**
     * 获取数组元素下标
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
     * 交换 i j
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        if( i < 0 || i >= numbers.length || j < 0 || j >= numbers.length){
            throw new IllegalArgumentException("Invalid index to access Sort Data.");
        }

        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }
}
