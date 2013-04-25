package com.cdoe.ui.form.elements;

/**
 *
 * @author Tony Ford
 */
public class ProgressMeter {
 private String status;
 private String statusDetail;
 private Integer progress;
 private String task;

    public ProgressMeter(String status, String statusDetail, Integer progress, String task) {
        this.status = status;
        this.statusDetail = statusDetail;
        this.progress = progress;
        this.task = task;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(String statusDetail) {
        this.statusDetail = statusDetail;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
 
 
}
