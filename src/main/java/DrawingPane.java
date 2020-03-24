import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


class DrawingPane extends JComponent {
    private List<ColorPoint> points;
    private Color pointColor;
    private JSlider pointSize;
    private DrawingPane pane;
    public DrawingPane() {
        setPreferredSize(new Dimension(600, 400));
        setBorder(new LineBorder(Color.GRAY));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ColorPoint point = new ColorPoint(e.getX(), e.getY(),
                        pointSize.getValue(), pointColor);
                points.add(point);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (ColorPoint p : points) {
            g2.setColor(p.getColor());
            int x = p.getX();
            int y = p.getY();
            int size = p.getSize();
            g2.fillOval(x - size / 2, y - size / 2, size, size);
        }
    }
}
