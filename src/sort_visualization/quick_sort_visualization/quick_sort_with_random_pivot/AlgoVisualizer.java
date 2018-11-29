package sort_visualization.quick_sort_visualization.quick_sort_with_random_pivot;

import sort_visualization.selection_sort_visualization.SelectionSortData;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * 可视化算法视图
 */
public class AlgoVisualizer {
    private static int DELAY = 40;
    // TODO: 创建自己的数据
    private QuickSortData data;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){

        // 初始化数据
        data = new QuickSortData(N, sceneHeight);

        // 初始化视图
        //利用事务队列执行
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Quick Sort Visualization", sceneWidth, sceneHeight);
            // TODO: 根据情况决定是否加入键盘鼠标事件监听器
//            frame.addKeyListener(new AlgoKeyListener());
//            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){
        //初始时，左标志为-1，右标志为-1，当前基准点为-1，当前有序元素为-1
        setData(-1, -1, -1, -1, -1);

        quickSort(0, data.N()-1);
        //排序结束时，左标志为0，右标志为数组长度，当前基准点为-1，当前有序元素为-1
        setData(0, data.N()-1, -1, -1, -1);

    }

    /**
     * 递归进行快速排序
     * @param l
     * @param r
     */
    private void quickSort(int l, int r){
        //左标志大于右标志
        if( l > r ){
            return;
        }
        //左标志等于右标志，
        if( l == r ){
            setData(l, r, l, -1, -1);
            return;
        }

        setData(l, r, -1, -1, -1);
        //基准点已经排好序
        int p = partition(l, r);
        quickSort(l, p-1 );
        quickSort(p+1, r);
    }

    /**
     * 快排核心逻辑
     * @param l
     * @param r
     * @return
     */
    private int partition(int l, int r){
        //随机选择基准点
        int p = (int)(Math.random()*(r-l+1)) + l;
        setData(l, r, -1, p, -1);
        //交换基准点与左标志的位置
        data.swap(l, p);
        int v = data.get(l);
        setData(l, r, -1, l, -1);
        // 令arr[l+1...j] < v ; arr[j+1...i) > v
        int j = l;
        for( int i = l + 1 ; i <= r ; i ++ ) {
            setData(l, r, -1, l, i);
            if (data.get(i) < v) {
                //如果当前元素小于基准点，和后一个元素交换
                j++;
                data.swap(j, i);
                setData(l, r, -1, l, i);
            }
        }
        //把基准点放到合适的位置
        data.swap(l, j);
        setData(l, r, j, -1, -1);
        //返回基准点位置
        return j;
    }


    /**
     * 绘制
     * @param l 左标志
     * @param r 右标志
     * @param fixedPivot 已经有序标志
     * @param curPivot  当前基准点标志
     * @param curElement  当前有序元素标志
     */
    private void setData(int l, int r, int fixedPivot, int curPivot, int curElement){
        data.l = l;
        data.r = r;
        if(fixedPivot != -1){
            data.fixedPivots[fixedPivot] = true;
        }
        data.curPivot = curPivot;
        data.curElement = curElement;

        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    // TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
    private class AlgoKeyListener extends KeyAdapter { }
    private class AlgoMouseListener extends MouseAdapter { }


    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 100;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }
}

