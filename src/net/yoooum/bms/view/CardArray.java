package net.yoooum.bms.view;

import com.formdev.flatlaf.FlatIntelliJLaf;


import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.ScrollPane;

/**
 * @author Yoooum
 */
public class CardArray extends JPanel {
    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 800, 600);
        frame.add(new CardArray());
        frame.setVisible(true);
    }

    public CardArray() {
        JPanel cards = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));

        for (int i = 0; i < 20; i++) {
            cards.add(new BookItem());
        }

        add(cards);

    }


}
