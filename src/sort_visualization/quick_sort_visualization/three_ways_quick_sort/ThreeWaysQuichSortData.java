package sort_visualization.quick_sort_visualization.three_ways_quick_sort;

import java.util.Arrays;

/**
 * 三路快速排序数据模型
 */
public class ThreeWaysQuichSortData {
    /**
     * 排序类型
     */
    public enum Type{
        Default,
        NearlyOrdered,
        Identical
    }

    private int[] numbers;              //待排序数组
    public int l, r;                    //左右标志
    public boolean[] fixedPivots;       //已经排好序的标志
    public int curPivot;                //当前基准点标志
    public int curL, curR;              //当前
    /**
     * 构造方法——生成随机数组
     * @param N
     * @param randomBound
     * @param dataType
     */
    public ThreeWaysQuichSortData(int N, int randomBound, Type dataType){

        numbers = new int[N];
        fixedPivots = new boolean[N];

        int lBound = 1;
        int rBound = randomBound;
        //相同元素
        if(dataType == Type.Identical){
            int avgNumber = (lBound + rBound) / 2;
            lBound = avgNumber;
            rBound = avgNumber;
        }

        for( int i = 0 ; i < N ; i ++) {
            numbers[i] = (int)(Math.random()*(rBound-lBound+1)) + lBound;
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

    public ThreeWaysQuichSortData(int N, int randomBound){
        this(N, randomBound, Type.Default);
    }

    public int N(){
        return numbers.length;
    }

    public int get(int index){
        if( index < 0 || index >= numbers.length){
            throw new IllegalArgumentException("Invalid index to access Sort Data.");
        }
        return numbers[index];
    }

    public void swap(int i, int j) {

        if( i < 0 || i >= numbers.length || j < 0 || j >= numbers.length){
            throw new IllegalArgumentException("Invalid index to access Sort Data.");
        }
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }
}
