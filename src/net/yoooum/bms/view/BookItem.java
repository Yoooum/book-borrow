package net.yoooum.bms.view;

import com.formdev.flatlaf.FlatIntelliJLaf;
import net.yoooum.bms.listener.ScrollListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.URL;
import java.util.Random;

import static net.yoooum.bms.utils.ImageScale.coverScaled;

/**
 * @author Yoooum
 */
public class BookItem extends JButton {
    public int id;
    public String name;
    public String url;

    public BookItem() {
        setDefaultCover();
        setText("图书名称");
        setBookStyle();
    }

    public BookItem(int r) {
        this.id = r;
        setText(String.valueOf(r));
        setBookStyle();
        setIcon(coverScaled("src/img/cover_"+ r +".jpg", 100, 160, false));
    }

    public BookItem(String bookName) {
        setDefaultCover();
        setText(bookName);
        setBookStyle();
    }

    public BookItem(String bookName, String coverName, int id, boolean isUrl) {
        this.id = id;
        try {
            setIcon(coverScaled(coverName, 100, 160, isUrl));
            setText(bookName);
            setBookStyle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setBookStyle() {
        setBounds(0, 0, 120, 200);
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setBorderPainted(false);
        setMargin(new Insets(5, 5, 5, 5));
        setVisible(true);

    }

    private void setDefaultCover() {
        Random randomImg = new Random();
        int imgNum = randomImg.nextInt(32);
        this.id=imgNum;
        setIcon(coverScaled("src/img/cover_"+ imgNum +".jpg", 100, 160, false));
    }


}

