package com.cdoe.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionTrackingListener implements HttpSessionListener {
	
	private static int sessionCount = 0;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		sessionCount++;

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		if (sessionCount > 0)
			sessionCount--;

	}

}
