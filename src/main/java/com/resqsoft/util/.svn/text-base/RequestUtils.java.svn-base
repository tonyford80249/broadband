package com.resqsoft.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.google.gson.Gson;

public class RequestUtils {

	public static String getContextPath(HttpServletRequest request) {
		StringBuilder path = new StringBuilder();
		path.append(request.getScheme());
		path.append("://");
		path.append(request.getServerName());
		path.append(":");
		path.append(request.getServerPort());

		String contextPath = request.getContextPath();
		if (!StringUtils.isEmpty(contextPath)) {
			path.append(contextPath);
		}

		return path.toString();
	}

	public static int getParam(HttpServletRequest request, String param, int defaultValue) {
		try {
			String value = request.getParameter(param);
			return Integer.parseInt(value);
		} catch (Exception e) {
		}
		return defaultValue;
	}

	public static long getParamLong(HttpServletRequest request, String param, long defaultValue) {
		try {
			String value = request.getParameter(param);
			return Long.parseLong(value);
		} catch (Exception e) {
		}
		return defaultValue;
	}

	public static String getParam(HttpServletRequest request, String param, String defaultValue) {
		String value = request.getParameter(param);
		if (value != null) {
			value = value.trim();
		}
		return (StringUtils.isEmpty(value)) ? defaultValue : value;
	}

	public static String[] getParamValues(HttpServletRequest request, String param) {
		return request.getParameterValues(param);
	}

	public static Integer[] getParamValuesInt(HttpServletRequest request, String param) {
		String[] values = getParamValues(request, param);
		Integer[] intValues = new Integer[0];
		if (values != null) {
			intValues = new Integer[values.length];
			for (int i = 0; i < values.length; i++) {
				int val = 0;
				try {
					val = Integer.parseInt(values[i]);
				} catch (NumberFormatException e) {
				}
				intValues[i] = val;
			}
		}
		return intValues;
	}
	
	public static void outputJson(HttpServletResponse response, Map<?, ?> map) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(map);
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}
	
	public static void outputJson(HttpServletResponse response, Object data) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(data);
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}
	
	public static String getMessage(HttpServletRequest request, String code, Object[] args) {
		WebApplicationContext context = RequestContextUtils.getWebApplicationContext(request);
		Locale locale = RequestContextUtils.getLocale(request);
		return context.getMessage(code, args, locale);
	}

}
