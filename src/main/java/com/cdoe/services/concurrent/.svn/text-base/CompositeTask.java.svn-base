package com.cdoe.services.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 *  <p>
 *    <b> description </b>  enter description.
 * </p>
 * @author Tony Ford
 */
public class CompositeTask implements BasicTask {
    public class CompositeMonitor implements TaskMonitor {

        public CompositeMonitor() {
        }

        @Override
        public TaskStatus getStatus() {
          if (CompositeTask.this.taskList.isEmpty())  {
           return TaskStatus.NOT_STARTED;   
          }
          
          for (BasicTask task : CompositeTask.this.taskList) {
           if (TaskStatus.NOT_STARTED.equals(task.getMonitor().getStatus()) || TaskStatus.CANCELED.equals(task.getMonitor().getStatus()) || TaskStatus.FAILURE.equals(task.getMonitor().getStatus()) || TaskStatus.INPROGRESS.equals(task.getMonitor().getStatus())) {
            return task.getMonitor().getStatus();   
           }   
          }    
          
          return TaskStatus.SUCCESS;
        }

        @Override
        public String getStatusDetail() {
          if (CompositeTask.this.taskList.isEmpty())  {
           return TaskStatus.NOT_STARTED.name();   
          }
          
          for (BasicTask task : CompositeTask.this.taskList) {
           if (TaskStatus.NOT_STARTED.equals(task.getMonitor().getStatus()) || TaskStatus.CANCELED.equals(task.getMonitor().getStatus()) || TaskStatus.FAILURE.equals(task.getMonitor().getStatus()) || TaskStatus.INPROGRESS.equals(task.getMonitor().getStatus())) {
            return task.getMonitor().getStatusDetail();
           }   
          }    
          
          return TaskStatus.SUCCESS.name();
        }

        @Override
        public double getProgress() {
             if (CompositeTask.this.taskList.isEmpty())  {
           return 0.0;   
          }
          
          int size = CompositeTask.this.taskList.size();
          double sum = 0.0;
          for (BasicTask task : CompositeTask.this.taskList) {
           sum += (task.getMonitor().getProgress()/size);
           
           if (TaskStatus.NOT_STARTED.equals(task.getMonitor().getStatus()) || TaskStatus.CANCELED.equals(task.getMonitor().getStatus()) || TaskStatus.FAILURE.equals(task.getMonitor().getStatus()) || TaskStatus.INPROGRESS.equals(task.getMonitor().getStatus())) {
            return sum;
           }   
          }    
          
          return 1.0;
        }

        @Override
        public List<String> getProgressDescription() {
          List<String> result = new ArrayList<String>();
          
           if (CompositeTask.this.taskList.isEmpty())  {
           return Collections.singletonList(TaskStatus.NOT_STARTED.name());   
          }
          
          for (BasicTask task : CompositeTask.this.taskList) {
            result.addAll(task.getMonitor().getProgressDescription());  
            
           if (TaskStatus.NOT_STARTED.equals(task.getMonitor().getStatus()) || TaskStatus.CANCELED.equals(task.getMonitor().getStatus()) || TaskStatus.FAILURE.equals(task.getMonitor().getStatus()) || TaskStatus.INPROGRESS.equals(task.getMonitor().getStatus())) {
            return result;
           }   
          }    
          
          result.add(TaskStatus.SUCCESS.name());
          
          return result;
        }

        @Override
        public TaskIdentifer getTaskIdentifer() {
           return CompositeTask.this.getTaskIdentifer();
        }
        
    }
    
    private static final Logger LOGGER = Logger.getLogger(CompositeTask.class);    
    private List<BasicTask> taskList = new ArrayList<BasicTask>();
    private boolean compositeOrMode;

    /**
     * 
     */
    public CompositeTask() {
    }
        
    /**
     * 
     * @return 
     */
    @Override
    public TaskMonitor getMonitor() {
        return new CompositeMonitor();
    }

    /**
     * 
     * @return 
     */
    @Override
    public TaskIdentifer getTaskIdentifer() {
     return taskList.iterator().next().getTaskIdentifer();  
    }

    public List<BasicTask> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<BasicTask> taskList) {
        this.taskList = taskList;
    }

    public boolean isCompositeOrMode() {
        return compositeOrMode;
    }

    public void setCompositeOrMode(boolean compositeOrMode) {
        this.compositeOrMode = compositeOrMode;
    }

    /**
     * 
     * @return
     * @throws Exception 
     */
    @Override
    public TaskMonitor call() throws Exception {
        try {
         for (BasicTask task : taskList) {
          TaskMonitor result = task.call();   
          
          if (!compositeOrMode && (TaskStatus.FAILURE.equals(result.getStatus()) || TaskStatus.CANCELED.equals(result.getStatus()))) {
           break;                    
          }
         }  
        }
        catch(Exception e) {
         LOGGER.error("Exception occurred during compond task execution.", e);   
        }
       
        
        return new CompositeMonitor();
    }
    
}
