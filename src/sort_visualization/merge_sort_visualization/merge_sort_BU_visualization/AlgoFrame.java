package sort_visualization.merge_sort_visualization.merge_sort_BU_visualization;

import sort_visualization.merge_sort_visualization.merge_sort_TD_visualization.AlgoVisHelper;

import javax.swing.*;
import java.awt.*;

/**
 *可视化算法模型
 */
public class AlgoFrame extends JFrame{
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

    // data
    private sort_visualization.merge_sort_visualization.merge_sort_BU_visualization.MergeSortData data;
    public void render(MergeSortData data){
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
            // 具体绘制
            int w = canvasWidth/data.N();
            //AlgoVisHelper.setColor(g2d, AlgoVisHelper.Grey);
            for(int i = 0 ; i < data.N() ; i ++ ) {
                if ( i >= data.l && i <= data.r)
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Green);
                else
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Grey);

                if( i >= data.l && i <= data.mergeIndex )
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Red);

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
