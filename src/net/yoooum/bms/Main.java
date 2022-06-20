package net.yoooum.bms;

import com.formdev.flatlaf.FlatIntelliJLaf;
import net.yoooum.bms.view.BaseView;

/**
 * @author Yoooum
 */
public class Main {
    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        new BaseView();
    }
}
