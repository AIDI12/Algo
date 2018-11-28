package sort_visualization.merge_sort_visualization.merge_sort_TD_visualization;


/**
 * 归并排序数据模型
 */
public class MergeSortData {

    public int[] numbers;     //待排序数组
    public int l, r;          //左右标志
    public int mergeIndex;    //正在排序的元素下标

    /**
     * 构造——随机生成数组
     * @param N 数组长度
     * @param randomBound 数组数值范围
     */
    public MergeSortData(int N, int randomBound){

        numbers = new int[N];

        for( int i = 0 ; i < N ; i ++)
            numbers[i] = (int)(Math.random()*randomBound) + 1;
    }
    /**
     * 返回数组长度
     * @return
     */
    public int N(){
        return numbers.length;
    }
    /**
     * 返回index的数组元素
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
        if( i < 0 || i >= numbers.length || j < 0 || j >= numbers.length){
            throw new IllegalArgumentException("Invalid index to access Sort Data.");
        }

        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }
}
