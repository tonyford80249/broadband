package com.cdoe.services.concurrent;

import java.util.concurrent.Callable;

/**
 * <p>
 *    <b> description </b>  common interface for all tasks.
 * </p>
 *
 * @author Tony Ford
 */
public interface BasicTask extends Callable<TaskMonitor> {
 public abstract TaskMonitor getMonitor();  
 public abstract TaskIdentifer getTaskIdentifer();
}
