import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class PointDraw extends JFrame {

    private List<ColorPoint> points;
    private Color pointColor;
    private JSlider pointSize;
    private DrawingPane pane;

    public PointDraw() {
        setTitle("test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        points = new ArrayList<>();
        pointColor = Color.BLACK;
        pane = new DrawingPane();

        JPanel topPanel = new JPanel();
        final JButton colorButton = new JButton();
        colorButton.setBackground(pointColor);
        colorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pointColor = JColorChooser.showDialog(PointDraw.this,
                        "Choose color", pointColor);
                colorButton.setBackground(pointColor);
            }
        });
        colorButton.setPreferredSize(new Dimension(40, 40));

        pointSize = new JSlider(0, 30, 10);
        pointSize.setMajorTickSpacing(10);
        pointSize.setMinorTickSpacing(2);
        pointSize.setPaintTicks(true);
        pointSize.setPaintLabels(true);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                points.clear();
                pane.repaint();
            }
        });

        topPanel.add(new JLabel("Color: "));
        topPanel.add(colorButton);
        topPanel.add(new JLabel("Size: "));
        topPanel.add(pointSize);
        topPanel.add(clearButton);

        add(pane);
        add(topPanel, BorderLayout.NORTH);
        pack();
    }
}





