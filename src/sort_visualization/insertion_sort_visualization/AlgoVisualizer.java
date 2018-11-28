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
    private InsertionSortData data;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N, InsertionSortData.Type dataType){

        // 初始化数据
        data = new InsertionSortData(N, sceneHeight, dataType);

        // 初始化视图
        //利用事务队列执行
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Insertion Sort Visualization", sceneWidth, sceneHeight);
            // TODO: 根据情况决定是否加入键盘鼠标事件监听器
//            frame.addKeyListener(new AlgoKeyListener());
//            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){
        this(sceneWidth, sceneHeight, N, InsertionSortData.Type.Default);
    }

    // 动画逻辑
    private void run(){
        //初始时，排好序的部分为0 ，正在比较的部分为-1，当前最小的为-1
        setData(0,-1);
//        //一般插入排序
//        for (int i = 0; i < data.N(); i++) {
//            setData(i, i);
//            for (int j = i; j > 0 && data.get(j) < data.get(j-1) ; j--) {
//                data.swap(j, j-1);
//                setData(i+1, j-1);
//            }
//        }
        //二分插入排序
        for (int i = 0; i < data.N(); i++) {
            setData(i, i);
            int mid = 0;
            int r = i - 1;
            int l = 0;
            while( l <= r ){
                mid = (r + l)/2;
                if (data.get(i) < data.get(mid)){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
            for (int j = i; j > l ; j--) {
                data.swap(j, j-1);
                setData(i+1, j-1);
            }
        }

        //排序完成
        setData(data.N(), -1);
    }
    private void setData(int orderedIndex, int currentIndex){
        data.orderedIndex = orderedIndex;
        data.currentIndex = currentIndex;

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

