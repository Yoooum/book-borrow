package net.yoooum.bms.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;



/**
 * @author Yoooum
 */
public class AddBook extends JDialog {
    private JPanel contentPane;
    private JTextField addNameTextField;
    private JTextField addAuthorTextField;
    private JTextField addPressTextField;
    private JTextField addPriceTextField;
    private JTextField addCoverTextField;
    private JTextField addSnTextField;
    private JButton addBookButton;
    private JButton cancelButton;
    private JRadioButton customRadioButton;
    private JRadioButton defaultRadioButton;
    private JTextField addSumTextField;
    private JLabel addNameLabel;
    private JLabel addAuthorLabel;
    private JLabel addCoverLabel;
    private JLabel addPriceLabel;
    private JLabel addSumLabel;
    private JLabel addSnLabel;
    private JLabel hintTextLabel;
    private JLabel addPressLabel;
    private JLabel coverImg;
    private JRadioButton testRadioButton;

    public AddBook(String addBook, Point position) {
        setTitle(addBook);
        setContentPane(contentPane);
        setModal(true);
        setLocation(position);
        getRootPane().setDefaultButton(addBookButton);
        Random randomImg = new Random();
        int imgNum = randomImg.nextInt(32);
        Image img = new ImageIcon("src/img/" + "cover_" + imgNum + ".jpg").getImage();
        Image scaledImage = img.getScaledInstance(200, 350, Image.SCALE_SMOOTH);
        coverImg.setIcon(new ImageIcon(scaledImage));
        pack();

        addBookButton.addActionListener(e -> onAdd());

        cancelButton.addActionListener(e -> onCancel());

        // ?????? X ????????? onCancel()
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // ?????? ESCAPE ????????? onCancel()
        contentPane.registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        defaultRadioButton.addActionListener(e -> {
            defaultRadioButton.setSelected(true);
            customRadioButton.setSelected(false);
            testRadioButton.setSelected(false);
            hintTextLabel.setText("*??????????????????ISBN????????????????????????????????????");
            System.out.println(defaultRadioButton.isSelected());
        });
        customRadioButton.addActionListener(e -> {
            customRadioButton.setSelected(true);
            defaultRadioButton.setSelected(false);
            testRadioButton.setSelected(false);
            hintTextLabel.setText("*????????????????????????");
            System.out.println(customRadioButton.isSelected());
        });
        testRadioButton.addActionListener(e -> {
            testRadioButton.setSelected(true);
            customRadioButton.setSelected(false);
            defaultRadioButton.setSelected(false);
            hintTextLabel.setText("*??????????????????");
            System.out.println(testRadioButton.isSelected());
        });
        setVisible(true);

    }

    private void onAdd() {
        // ???????????????????????????
        dispose();
    }

    private void onCancel() {
        // ????????????????????????????????????
        dispose();
    }

    public static void main(String[] args) {
        AddBook dialog = new AddBook("????????????", new Point(100, 100));
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
