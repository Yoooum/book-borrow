package net.yoooum.bms.utils;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/**
 * @author Yoooum
 */
public class ImageScale {
    /**
     * @param path   源图片路径
     * @param width  缩放宽度
     * @param height 缩放高度
     * @return 返回缩放后的图片
     */
    public static ImageIcon coverScaled(String path, int width, int height, boolean isUrl) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image;
        if (isUrl) {
            try {
                image = toolkit.getImage(new URL(path)).getScaledInstance(width, height, Image.SCALE_DEFAULT);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            image = toolkit.getImage(path).getScaledInstance(width, height, Image.SCALE_DEFAULT);
        }
        return new ImageIcon(image);
    }

}
