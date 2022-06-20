package net.yoooum.bms.view;

import net.yoooum.bms.database.Select;
import net.yoooum.bms.utils.StringLimit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Random;

/**
 * @author Yoooum
 */
public class BaseView extends JFrame
{
    int bookCount = 20;
    public BaseView()
    {
        setTitle("图书借阅系统");
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/img/icon.png"));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = 125*8;
        int height = 210*3+20;
        int x = (screenSize.width - width) / 2;
        int y = (screenSize.height - height) / 2;
        setBounds(x, y, width, height);
        setBackground(Color.decode("#F2F2F2"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(navMenu());
        Container content =getContentPane();

        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);
        scrollPane.setBorder(null);


        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                int row = getWidth()/120;
                int col = bookCount/row;
                System.out.println("view = " + getWidth() + ", " + getHeight() + " | row = " + row + ", col = " + col);
                panel.setPreferredSize(new Dimension(getWidth()-30, col*230 + 300));
            }

        });

        Select select = new Select();

        BookItem bookItem;
        try {
            try (ResultSet resultSet = select.cardBook()) {
                while (resultSet.next()) {
                    bookCount++;
                    String bookName = resultSet.getString("book_name");
                    String coverUrl = resultSet.getString("cover_url");
                    int id = resultSet.getInt("book_id");
                    StringLimit nameSplit = new StringLimit(bookName,16);
                    panel.add(bookItem = new BookItem(nameSplit.limited(), coverUrl, id, true));
                    bookItem.addActionListener(e -> {
                        new BookInfo(id,getLocationOnScreen(),getWidth(),getHeight());
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        BookItem bookItemRandom;
        for (int i = 0; i < bookCount; i++) {
            Random random = new Random();
            int randomNum = random.nextInt(32);
            panel.add(bookItemRandom = new BookItem(randomNum));
            bookItemRandom.addActionListener(e -> {
                new BookInfo(randomNum,getLocationOnScreen(),getWidth(),getHeight(),true);
            });
            panel.setPreferredSize(new Dimension(getWidth()-30, 230));

        }
        content.add(scrollPane);
        setVisible(true);
    }

    public Point getPoint()
    {
        return getLocationOnScreen();
    }

    private JMenuBar navMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu borrow = new JMenu("借阅(B)");
        borrow.setMnemonic(KeyEvent.VK_B);
        JMenu manage = new JMenu("管理(M)");
        manage.setMnemonic(KeyEvent.VK_M);
        JMenu account = new JMenu("我的(A)");
        account.setMnemonic(KeyEvent.VK_A);
        JMenu help = new JMenu("帮助(H)");
        help.setMnemonic(KeyEvent.VK_H);

        //添加菜单项
        menuBar.add(borrow);
        menuBar.add(manage);
        menuBar.add(account);
        menuBar.add(help);
        //创建菜单项
        JMenuItem borrowed = new JMenuItem("已借阅");
        JMenuItem giveBack = new JMenuItem("已归还");
        JMenuItem search = new JMenuItem("图书查询");

        JMenuItem addBook = new JMenuItem("添加图书");
        addBook.addActionListener(e -> {
            new AddBook("添加图书",getLocationOnScreen());
        });
        JMenuItem delBook = new JMenuItem("删除图书");
        JMenuItem editBook = new JMenuItem("修改图书");

        JMenuItem exit = new JMenuItem("退出");
        JMenuItem helpInfo = new JMenuItem("帮助");
        JMenuItem aboutInfo = new JMenuItem("关于");

        JMenuItem accountInfo = new JMenuItem("我的账户");
        JMenuItem editPassword = new JMenuItem("修改密码");
        JMenu theme = new JMenu("主题");

        borrow.add(borrowed);
        borrow.add(giveBack);
        borrow.addSeparator();
        borrow.add(search);
        manage.add(addBook);
        manage.add(delBook);
        manage.add(editBook);
        account.add(accountInfo);
        account.add(editPassword);
        account.addSeparator();
        account.add(theme);
        help.add(helpInfo);
        help.add(aboutInfo);
        help.add(exit);

        JMenuItem themeLight = new JMenuItem("浅色");
        JMenuItem themeDark = new JMenuItem("深色");
        theme.add(themeLight);
        theme.add(themeDark);
        return menuBar;
    }


}
