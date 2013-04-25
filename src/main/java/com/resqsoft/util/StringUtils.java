package com.resqsoft.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils extends org.apache.commons.lang.StringUtils {

	public static boolean isEmpty(String string) {
		boolean isEmpty = true;
		if (string != null && string.trim().length() > 0)
			isEmpty = false;
		return isEmpty;
	}
	
	public static boolean isEmail(String email) {
		Pattern pattern = Pattern.compile("^[\\w-]+(?:\\.[\\w-]+)*@(?:[\\w-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static String getFileExt(String fullFileName) {
		int idx = fullFileName.trim().lastIndexOf(".");
		String ext = "";
		if (idx >= 0) {
			ext = fullFileName.substring(idx + 1, fullFileName.length());
		}
		return ext;
	}
	
	public static String filter(String data) {
		String filtered;
		if (isEmpty(data))
			filtered = "";
		else
			filtered = data.trim();
		return filtered;
	}
	
	public static String trimToSize(String data, int length) {
		String trimmed = filter(data);
		if (trimmed.length() >= length) {
			trimmed = trimmed.substring(0, length);
		}
		return trimmed;
	}
	
}
