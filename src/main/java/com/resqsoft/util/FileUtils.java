package com.resqsoft.util;

public class FileUtils {
	
	public static String concat(String path1, String path2) {
		return concat(path1, path2, SystemUtils.getFileSeparator());
	}
	
	public static String concatForWeb(String path1, String path2) {
		path1 = path1.replaceAll("\\\\", "/");
		path2 = path2.replaceAll("\\\\", "/");
		return concat(path1, path2, "/");
	}
	
	public static String concat(String path1, String path2, String separator) {
		path1 = path1.trim();
		path2 = path2.trim();
		
		if (path1.endsWith(separator)) {
			int lastIndexOf = path1.lastIndexOf(separator);
			path1 = path1.substring(0, lastIndexOf);
		}
		if (path2.startsWith(separator)) {
			int indexOf = path2.indexOf(separator);
			path2 = path2.substring(indexOf, path2.length());
		}
		
		StringBuilder path = new StringBuilder();
		path.append(path1);
		path.append(separator);
		path.append(path2);
		
		return path.toString();
	}
	
}
