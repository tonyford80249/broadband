package com.cdoe.services.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  <p>
 *    <b> description </b>  enter description.
 * </p>
 * @author Tony Ford
 */
public class DefaultMonitor implements TaskMonitor {
    private TaskStatus status;
    private String statusDetail;
    private double progress;
    private List<String> progressDescription = new ArrayList<String>();
    private TaskIdentifer taskIdentifer;

    public DefaultMonitor() {
    }

    public synchronized void setStatus(TaskStatus status) {
        this.status = status;
    }

    public synchronized void setProgress(double progress) {
        this.progress = progress;
    }

    public synchronized void setProgressDescription(List<String> progressDescription) {
        this.progressDescription = progressDescription;
    }

    public void setStatusDetail(String statusDetail) {
        this.statusDetail = statusDetail;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public synchronized TaskStatus getStatus() {
        return this.status;
    }

    /**
     * 
     * @return 
     */
    @Override
    public synchronized double getProgress() {
        return this.progress;
    }

    /**
     * 
     * @return 
     */
    @Override
    public synchronized List<String> getProgressDescription() {
      return this.progressDescription;//Collections.unmodifiableList(this.progressDescription);  
    }

    /**
     * 
     * @return 
     */
    @Override
    public String getStatusDetail() {
        return this.statusDetail;
    }

    @Override
    public TaskIdentifer getTaskIdentifer() {
        return taskIdentifer;
    }

    public void setTaskIdentifer(TaskIdentifer taskIdentifer) {
        this.taskIdentifer = taskIdentifer;
    }

   
    
}
