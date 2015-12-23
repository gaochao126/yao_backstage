package com.jiuyi.yao.common;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @description 图片处理工具类
 * @author zhb
 * @createTime 2015年11月16日
 */
public class ImageUtil {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\1234.jpg");
        Rectangle rect = new Rectangle(0, 0, 600, 600);
        cut(file, 3000, 3000, rect);
    }

    /**
     * @Description: 将srcImageFile裁剪后生成destImageFile
     * @param srcImageFile
     *            原始图
     * @param destImageFile
     *            目标图
     * @param width
     *            原始图预处理后width
     * @param height
     *            原始图预处理后height
     * @param rect
     *            目标图输出的格式(rect.x, rect.y, rect.width, rect.height)
     * @throws IOException
     * @author Sun Yanjun
     */
    public static void cut(File file, int width, int height, Rectangle rect) throws IOException {
        String fileExt = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        Image image = ImageIO.read(file);
        BufferedImage bImage = makeThumbnail(image, width, height);
        ImageIO.write(bImage, fileExt, file);
        saveSubImage(bImage, rect, file);
    }

    /**
     * @Description: 将srcImageFile裁剪后生成destImageFile
     * @param srcImageFile
     *            原始图
     * @param destImageFile
     *            目标图
     * @param width
     *            原始图预处理后width
     * @param height
     *            原始图预处理后height
     * @param rect
     *            目标图输出的格式(rect.x, rect.y, rect.width, rect.height)
     * @throws IOException
     * @author Sun Yanjun
     */
    public static void cut(File srcImageFile, File destImageFile, int width, int height, Rectangle rect) throws IOException {
        Image image = ImageIO.read(srcImageFile);
        BufferedImage bImage = makeThumbnail(image, width, height);
        saveSubImage(bImage, rect, destImageFile);
    }

    /**
     * @Description: 对原始图片根据(x, y, width, height) = (0, 0, width,
     *               height)进行缩放，生成BufferImage
     * @param img
     * @param width
     *            预处理后图片的宽度
     * @param height
     *            预处理后图片高度
     * @return
     * @author Sun Yanjun
     * @throws IOException
     */
    private static BufferedImage makeThumbnail(Image img, int width, int height) throws IOException {
        BufferedImage tag = new BufferedImage(width, height, 1);
        Graphics g = tag.getGraphics();
        g.drawImage(img.getScaledInstance(width, height, 4), 0, 0, null);

        g.dispose();
        return tag;
    }

    /**
     * @Description: 对BufferImage按照(x, y, width, height) = (subImageBounds.x,
     *               subImageBounds.y, subImageBounds.width,
     *               subImageBounds.height)进行裁剪
     *               如果subImageBounds范围过大，则用空白填充周围的区域。
     * 
     * @param image
     * @param subImageBounds
     * @param destImageFile
     * @throws IOException
     * @author Sun Yanjun
     */
    private static void saveSubImage(BufferedImage image, Rectangle subImageBounds, File destImageFile) throws IOException {
        String fileName = destImageFile.getName();
        String formatName = fileName.substring(fileName.lastIndexOf('.') + 1);
        BufferedImage subImage = new BufferedImage(subImageBounds.width, subImageBounds.height, 1);
        Graphics g = subImage.getGraphics();

        if ((subImageBounds.width > image.getWidth()) || (subImageBounds.height > image.getHeight())) {
            int left = subImageBounds.x;
            int top = subImageBounds.y;
            if (image.getWidth() < subImageBounds.width)
                left = (subImageBounds.width - image.getWidth()) / 2;
            if (image.getHeight() < subImageBounds.height)
                top = (subImageBounds.height - image.getHeight()) / 2;
            g.setColor(Color.white);
            g.fillRect(0, 0, subImageBounds.width, subImageBounds.height);
            g.drawImage(image, left, top, null);
            ImageIO.write(image, formatName, destImageFile);
        } else {
            g.drawImage(image.getSubimage(subImageBounds.x, subImageBounds.y, subImageBounds.width, subImageBounds.height), 0, 0, null);
        }
        g.dispose();
        ImageIO.write(subImage, formatName, destImageFile);
    }
}