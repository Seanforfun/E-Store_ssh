package ca.mcmaster.shop.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 1, 2018 5:13:02 PM
 */
public class CheckCodeUtils {
		public static CheckCode drawCheckcode(){
			int height = 30;
			int width = 120;
			BufferedImage image = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics graphic = image.getGraphics();
			graphic.setColor(Color.YELLOW);
			graphic.fillRect(0, 0, width, height);
			String libString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
			graphic.setColor(Color.RED);
			graphic.setFont(new Font(null, Font.BOLD, 20));
			int charStartx = 20;
			int charStarty = 20;
			String verifyCode = "";

			for (int i = 0; i < 4; i++) {
				int randNum = new Random().nextInt(libString.length());
				char c = libString.charAt(randNum);
				graphic.drawString("" + c, charStartx, charStarty);
				charStartx += 20;
				verifyCode = verifyCode + c;
			}

			graphic.setColor(Color.GRAY);
			int[] positions = new int[4];

			for (int i = 0; i < 4; i++) {
				positions[0] = new Random().nextInt(width);
				positions[1] = new Random().nextInt(height);
				positions[2] = new Random().nextInt(width);
				positions[3] = new Random().nextInt(height);
				graphic.drawLine(positions[0], positions[1], positions[2],
						positions[3]);
			}

			return new CheckCode(verifyCode, image);
		}
}
