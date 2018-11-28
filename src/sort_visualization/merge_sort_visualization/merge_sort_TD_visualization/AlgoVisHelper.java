package sort_visualization.merge_sort_visualization.merge_sort_TD_visualization;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * 可视化算法辅助工具
 */
public class AlgoVisHelper {
    /**
     * 无参构造
     */
    private AlgoVisHelper(){}

    /**
     * 颜色
     */
    public static final Color Red = new Color(0xF44336);
    public static final Color Pink = new Color(0xE91E63);
    public static final Color Purple = new Color(0x9C27B0);
    public static final Color DeepPurple = new Color(0x673AB7);
    public static final Color Indigo = new Color(0x3F51B5);
    public static final Color Blue = new Color(0x2196F3);
    public static final Color LightBlue = new Color(0x03A9F4);
    public static final Color Cyan = new Color(0x00BCD4);
    public static final Color Teal = new Color(0x009688);
    public static final Color Green = new Color(0x4CAF50);
    public static final Color LightGreen = new Color(0x8BC34A);
    public static final Color Lime = new Color(0xCDDC39);
    public static final Color Yellow = new Color(0xFFEB3B);
    public static final Color Amber = new Color(0xFFC107);
    public static final Color Orange = new Color(0xFF9800);
    public static final Color DeepOrange = new Color(0xFF5722);
    public static final Color Brown = new Color(0x795548);
    public static final Color Grey = new Color(0x9E9E9E);
    public static final Color BlueGrey = new Color(0x607D8B);
    public static final Color Black = new Color(0x000000);
    public static final Color White = new Color(0xFFFFFF);

    /**
     * 构造一个空心圆
     * @param g
     * @param x 屏幕坐标系左上角x坐标
     * @param y 屏幕坐标系左上角y坐标
     * @param r 半径
     */
    public static void strokeCircle(Graphics2D g, int x, int y, int r){
        //Ellipse2D 类描述窗体矩形定义的椭圆。 此类是所有存储 2D 椭圆的对象的惟一抽象超类。
        //坐标的实际存储表示形式由子类决定。
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        //绘制图像
        g.draw(circle);
    }

    /**
     * 构造一个实心圆
     * @param g
     * @param x 屏幕坐标系左上角x坐标
     * @param y 屏幕坐标系左上角y坐标
     * @param r 半径
     */
    public static void fillCircle(Graphics2D g, int x, int y, int r){

        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g.fill(circle);
    }

    /**
     * 构造一个空心矩形
     * @param g
     * @param x 屏幕坐标系左上角x坐标
     * @param y 屏幕坐标系左上角坐标
     * @param w 矩形宽度
     * @param h 矩形高度
     */
    public static void strokeRectangle(Graphics2D g, int x, int y, int w, int h){
        //Rectangle2D 类描述通过位置 (x,y) 和尺寸 (w x h) 定义的矩形。
        //此类是所有存储 2D 矩形的对象的惟一抽象超类。坐标的实际存储表示形式由子类决定。
        Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
        g.draw(rectangle);
    }
    /**
     * 构造一个实心矩形
     * @param g
     * @param x 屏幕坐标系左上角x坐标
     * @param y 屏幕坐标系左上角坐标
     * @param w 矩形宽度
     * @param h 矩形高度
     */
    public static void fillRectangle(Graphics2D g, int x, int y, int w, int h){

        Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
        g.fill(rectangle);
    }

    /**
     * 设置颜色
     * @param g
     * @param color 颜色
     */
    public static void setColor(Graphics2D g, Color color){
        g.setColor(color);
    }

    /**
     * 设置
     * @param g
     * @param w
     */
    public static void setStrokeWidth(Graphics2D g, int w){
        int strokeWidth = w;
        g.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    /**
     * 睡眠时间
     * @param t
     */
    public static void pause(int t) {
        try {
            Thread.sleep(t);
        }
        catch (InterruptedException e) {
            System.out.println("Error sleeping");
        }
    }

    /**
     * 设置图像
     * @param g
     * @param x
     * @param y
     * @param imageURL 图像URL
     */
    public static void putImage(Graphics2D g, int x, int y, String imageURL){

        ImageIcon icon = new ImageIcon(imageURL);
        Image image = icon.getImage();

        g.drawImage(image, x, y, null);
    }

    /**
     * 设置文本
     * @param g
     * @param text
     * @param centerx
     * @param centery
     */
    public static void drawText(Graphics2D g, String text, int centerx, int centery){

        if(text == null){
            throw new IllegalArgumentException("Text is null in drawText function!");
        }

        FontMetrics metrics = g.getFontMetrics();
        int w = metrics.stringWidth(text);
        int h = metrics.getDescent();
        g.drawString(text, centerx - w/2, centery + h);
    }
}

