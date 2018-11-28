package sort_visualization.selection_sort_visualization;

/**
 * 选择排序数据
 */
public class SelectionSortData {

    private int[] numbers;                  //待排序的数组
    public int orderedIndex = -1;           // [0...orderedIndex) 是有序的
    public int currentCompareIndex = -1;    // 当前正在比较的元素索引
    public int currentMinIndex = -1;        // 当前找到的最小元素的索引

    /**
     * 构造——随机生成数组
     * @param N 数组长度
     * @param randomBound 数组数值范围
     */
    public SelectionSortData(int N, int randomBound){

        numbers = new int[N];
        //生成随机数组
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
        //校验i，j是否越界
        if( i < 0 || i >= numbers.length || j < 0 || j >= numbers.length){
            throw new IllegalArgumentException("Invalid index to access Sort Data.");
        }


        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }
}
