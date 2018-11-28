package sort_visualization.insertion_sort_visualization;

import sort_visualization.selection_sort_visualization.SelectionSortData;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * 可视化算法视图
 */
public class AlgoVisualizer {
    private static int DELAY = 1;
    // TODO: 创建自己的数据
    private SelectionSortData data;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){

        // 初始化数据
        data = new SelectionSortData(N, sceneHeight);

        // 初始化视图
        //利用事务队列执行
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Selection Sort Visualization", sceneWidth, sceneHeight);
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
        //初始时，排好序的部分为0 ，正在比较的部分为-1，当前最小的为-1
        setData(0,-1, -1);

        for (int i = 0; i < data.N(); i++) {
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < data.N(); j++) {
                //排好序的部分为i ，正在比较的部分为j，当前最小的为minIndex
                setData(i, j, minIndex);
                if (data.get(j) < data.get(minIndex)){
                    minIndex = j;
                    //排好序的部分为i ，正在比较的部分为j，当前最小的为minIndex
                    setData(i, j, minIndex);
                }
            }
            data.swap(i, minIndex);
            //排序完成
            setData(data.N(), -1, -1);
        }
    }
    private void setData(int orderedIndex, int currentCompareIndex, int currentMinIndex){
        data.orderedIndex = orderedIndex;
        data.currentCompareIndex = currentCompareIndex;
        data.currentMinIndex = currentMinIndex;

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

