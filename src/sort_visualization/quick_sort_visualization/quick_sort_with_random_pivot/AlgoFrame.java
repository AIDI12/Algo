package sort_visualization.quick_sort_visualization.quick_sort_with_random_pivot;

import sort_visualization.selection_sort_visualization.SelectionSortData;

import javax.swing.*;
import java.awt.*;

/**
 *可视化算法模型
 */
public class AlgoFrame extends JFrame {
    //界面宽高
    private int canvasWidth;
    private int canvasHeight;

    /**
     * 设置界面
     * @param title 标题
     * @param canvasWidth 界面宽度
     * @param canvasHeight 界面高度
     */
    public AlgoFrame(String title, int canvasWidth, int canvasHeight){

        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }

    /**
     * 默认构造
     * @param title
     */
    public AlgoFrame(String title){

        this(title, 1024, 768);
    }

    /**
     * 获取界面的宽高
     * @return
     */
    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}

    // TODO: 设置自己的数据
    private QuickSortData data;
    public void render(QuickSortData data){
        this.data = data;
        repaint();
    }

    /**
     * 设置面板类
     */
    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
            // 双缓存
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            // 抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            // 具体绘制
            // TODO： 绘制自己的数据data
            //每个矩形的宽度是面板宽度/数组元素数量
            int w = canvasWidth/data.N();
            for (int i = 0; i < data.N() ; i++) {
                //设置颜色
                //当前比较的部分
                if ( i >= data.l && i <= data.r){
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Green);
                } else{ //未比较的部分
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Grey);
                }
                //当前基准点
                if( i == data.curPivot ){
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Indigo);
                }
                //当前排好序的元素
                if( i == data.curElement){
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.LightBlue);
                }
                //已经排好序的部分
                if( data.fixedPivots[i] ){
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Red);
                }
                //设置矩形的坐标以及宽高，每个矩形的x坐标为元素下标*矩形宽度，y坐标为面板高度-元素大小，矩形高度为元素大小
                AlgoVisHelper.fillRectangle(g2d, i * w, canvasHeight - data.get(i), w - 1, data.get(i));
            }
        }

        /**
         * 设置面板初始大小
         * @return
         */
        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
