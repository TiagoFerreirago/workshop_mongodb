package br.com.thfe.workshop_mongodb.controller.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class DecodeUrl {

	
	public static String DecodeUrlText(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
	}
}
}
