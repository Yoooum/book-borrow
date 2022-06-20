package net.yoooum.bms.view;

import net.yoooum.bms.database.Select;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import static net.yoooum.bms.utils.ImageScale.coverScaled;
/**
 * @author Yoooum
 */
public class BookInfo extends JDialog {
    private JPanel contentPane;
    private JButton buttonBorrow;
    private JButton buttonCancel;
    private JLabel bookCoverLabel;
    private JLabel bookNameLabel;
    private JLabel bookAuthorLabel;
    private JLabel bookPressLabel;
    private JLabel bookSumLabel;
    private JLabel bookPriceLabel;
    private JLabel bookSnLabel;
    private JButton alterButton;
    private JButton deleteButton;


    public BookInfo(int i,Point p ,int w,int h,boolean isRandom) {
        setContentPane(contentPane);
        setModal(true);
        System.out.println(p.x+" "+p.y +" "+w+" "+h);
        setLocation((w/2+p.x)/2+80,(h/2+p.y)/2);
        setTitle("图书信息");
        setResizable(false);
        getRootPane().setDefaultButton(buttonBorrow);
        randomBook(i);
        pack();
        setVisible(true);
    }
    public BookInfo(int id, Point p,int w,int h) {
        setContentPane(contentPane);
        setModal(true);
        System.out.println(p.x+" "+p.y +" "+w+" "+h);
        setLocation((w/2+p.x)/2+80,(h/2+p.y)/2);
        setTitle("图书信息");
        setResizable(false);
        getRootPane().setDefaultButton(buttonBorrow);
        searchBook(id);
        pack();
        setVisible(true);

        buttonBorrow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onBorrow();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // 点击 X 时调用 onCancel()
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // 遇到 ESCAPE 时调用 onCancel()
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onBorrow() {
        // 在此处添加您的代码
        dispose();
    }

    private void onCancel() {
        // 必要时在此处添加您的代码
        dispose();
    }



    public void searchBook(int id) {
        Select sql = new Select();

           try(ResultSet rs = sql.select("select * from book_info where book_id = " + id)) {
               while (rs.next()) {
                   bookCoverLabel.setIcon(coverScaled(rs.getString("cover_url"),200,300, true));
                   bookNameLabel.setText(rs.getString("book_name"));
                   bookAuthorLabel.setText("作者: "+rs.getString("author"));
                   bookPressLabel.setText("价格: "+rs.getString("press"));
                   bookSumLabel.setText("可借数量: "+rs.getString("volume"));
                   bookPriceLabel.setText("单价: "+rs.getString("price"));
                   bookSnLabel.setText("ISBN: "+rs.getString("isbn"));
               }
           }

         catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void randomBook(int i) {
        bookCoverLabel.setIcon(coverScaled("src/img/cover_"+ i +".jpg", 200, 350, false));
        bookNameLabel.setText("书名: "+"第"+i+"本书");
        bookAuthorLabel.setText("作者: "+"第"+i+"本书");
        bookPressLabel.setText("出版社: "+"第"+i+"本书");
        bookSumLabel.setText("可借数量: "+"第"+i+"本书");
        bookPriceLabel.setText("单价: "+"第"+i+"本书");
        bookSnLabel.setText("ISBN: "+"第"+i+"本书");
    }

}
