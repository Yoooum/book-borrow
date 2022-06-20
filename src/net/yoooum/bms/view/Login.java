package net.yoooum.bms.view;

import com.formdev.flatlaf.FlatIntelliJLaf;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;




/**
 * @author Yoooum
 */
public class Login extends JDialog {
    private JPanel contentPane;
    private JButton buttonLogin;
    private JButton buttonCancel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton buttonRegister;
    private JLabel iconImg;


    public Login() {
        setContentPane(contentPane);
        setModal(true);
        setTitle("登录");


        pack();

        setIconImage(new ImageIcon("src/img/" + "icon.png").getImage());
        setResizable(false);

        buttonRegister.setContentAreaFilled(false);
        buttonRegister.setBorderPainted(false);
        buttonRegister.setMargin(new Insets(0, 0, 0, 0));
        buttonRegister.setForeground(Color.getColor("#3E86A0"));
        getRootPane().setDefaultButton(buttonLogin);


        buttonLogin.addActionListener(e -> onLogin());

        buttonCancel.addActionListener(e -> onCancel());

        // 点击 X 时调用 onCancel()
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // 遇到 ESCAPE 时调用 onCancel()
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        setVisible(true);
    }

    private void onLogin() {
        // 在此处添加您的代码
        dispose();
    }

    private void onCancel() {
        // 必要时在此处添加您的代码
        dispose();
    }

    public static void main(String[] args)  {
        FlatIntelliJLaf.setup();
//        Login dialog = new Login(BaseFrame);
//
//        dialog.pack();
//        dialog.setTitle("登录2");
//        dialog.setIconImage(new ImageIcon(path + "icon.png").getImage());
//        dialog.setVisible(true);
//        System.exit(0);
    }

}
