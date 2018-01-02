package ca.mcmaster.shop.utils;

import java.util.UUID;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 1, 2018 8:23:25 PM
 */
public class UUIDUtils {
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
