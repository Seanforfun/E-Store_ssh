package ca.mcmaster.shop.utils;

import java.awt.image.BufferedImage;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 1, 2018 5:22:49 PM
 */
public class CheckCode {
	private String checkCode;
	private BufferedImage bufferedImage;

	public CheckCode(String checkCode, BufferedImage bufferedImage) {
		super();
		this.checkCode = checkCode;
		this.bufferedImage = bufferedImage;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}
}
