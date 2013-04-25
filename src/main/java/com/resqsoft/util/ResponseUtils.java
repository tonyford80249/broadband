package com.resqsoft.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ResponseUtils {
	
	public static void toGson(HttpServletResponse response, Object data) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(data);

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}

}
