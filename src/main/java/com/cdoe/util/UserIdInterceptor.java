package com.cdoe.util;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class UserIdInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 1L;

	private static ThreadLocal<String> user = new ThreadLocal<String>();

	public static void setUser(String userId) {
		user.set(userId);
	}

	public static String getUser() {
		return user.get();
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		return updateUser(currentState, propertyNames);
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		return updateUser(state, propertyNames);
	}

	private boolean updateUser(Object[] currentState, String[] propertyNames) {
		boolean changed = false;

		for (int i = 0; i < propertyNames.length; i++) {
			if (propertyNames[i].equalsIgnoreCase("userId")) {
				currentState[i] = getUser() != null ? getUser() : "<tnyf>";
				changed = true;
			}
			if (propertyNames[i].equalsIgnoreCase("updateTimestamp")) {
				currentState[i] = new Date();
				changed = true;
			}
		}
		return changed;
	}

}
