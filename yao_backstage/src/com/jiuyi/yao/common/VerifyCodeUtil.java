package com.jiuyi.yao.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @description 验证码工具类
 * @author zhb
 * @createTime 2015年10月10日
 */
public class VerifyCodeUtil {
    private final static char[] characters = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    /**
     * @description 获取随机颜色
     * @param fc
     * @param bc
     * @return
     */
    protected static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    /**
     * @description 获取验证码图片
     * @param width
     *            图片宽度
     * @param height
     *            图片高度
     * @param left
     *            左边距
     * @param top
     *            上边距
     * @param size
     *            字体大小
     * @param verifyCode
     *            验证码
     * @return
     */
    public static BufferedImage getVerifyCodeImage(int width, int height, int left, int top, int size, String verifyCode) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.PLAIN, size));
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        for (int i = 0; i < verifyCode.length(); i++) {
            String str = verifyCode.substring(i, i + 1);
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            if (("W".equals(str) || "M".equals(str)) && i == verifyCode.length() - 1) {
                g.drawString(str, width / verifyCode.length() * i + left - 3, top);
            } else {
                g.drawString(str, width / verifyCode.length() * i + left, top);
            }
        }
        g.dispose();
        return image;
    }

    /**
     * @description 获取验证码
     * @param length
     * @return
     */
    public static String getVerifyCode(int length) {
        if (length < 1) {
            return null;
        }
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(characters[random.nextInt(characters.length)]);
        }
        return sb.toString();
    }
}