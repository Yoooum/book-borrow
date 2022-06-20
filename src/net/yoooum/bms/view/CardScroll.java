package net.yoooum.bms.view;

import com.formdev.flatlaf.FlatIntelliJLaf;
import net.yoooum.bms.listener.ScrollListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * @author Yoooum
 */
public class CardScroll extends JScrollPane{
    public ScrollListener scrollListener;
    public void setListener() {
        this.scrollListener = new ScrollListener();
        this.addComponentListener(this.scrollListener);
    }

    public void setListener(ScrollListener scrollListener) {
        this.scrollListener = scrollListener;

    }

    public CardScroll() {
        getVerticalScrollBar().setUnitIncrement(30);
        setBorder(null);
        this.setListener();
    }
    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(125*8, 210*3+20);
        frame.setResizable(true);
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBackground(Color.decode("#F2F2F2"));
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);
        scrollPane.setBorder(null);
        int bookCount = 40;

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                int row = frame.getWidth()/120;
                int col = bookCount/row;
                System.out.println(scrollPane.getWidth() + " " + frame.getHeight());
                System.out.println("row = " + row + ", col = " + col);
                panel.setPreferredSize(new Dimension(frame.getWidth()-30, col*240));
            }

        });
        for (int i = 0; i < bookCount; i++) {
            panel.add(new BookItem());
            panel.setPreferredSize(new Dimension(frame.getWidth()-30, 230));



        }
        frame.add(scrollPane);
        frame.setVisible(true);
    }
}
