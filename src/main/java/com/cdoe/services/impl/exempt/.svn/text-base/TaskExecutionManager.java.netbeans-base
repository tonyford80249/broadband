package com.cdoe.services.impl.exempt;

import com.cdoe.services.exempt.ITaskExecutionManager;
import com.cdoe.services.concurrent.BasicTask;
import com.cdoe.services.concurrent.CompositeTask;
import com.cdoe.services.concurrent.TaskIdentifer;
import com.cdoe.services.concurrent.TaskMonitor;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author Tony Ford
 */
public class TaskExecutionManager implements ApplicationContextAware, ITaskExecutionManager {
    private ApplicationContext applicationContext;
    private Map<TaskIdentifer,Future<TaskMonitor>> futures = new  EnumMap<TaskIdentifer,Future<TaskMonitor>>(TaskIdentifer.class);
    private Map<TaskIdentifer,TaskMonitor> monitors = new  EnumMap<TaskIdentifer,TaskMonitor>(TaskIdentifer.class);
    private ExecutorService executor = null;
    private Integer threadPoolSize;

    /**
     * 
     */
    public TaskExecutionManager() {
    }
    
    
    /**
     * 
     */
    public void init() {
     this.executor = Executors.newFixedThreadPool(threadPoolSize);   
    }
    
    /**
     * 
     * @param taskIdentifer
     * @return 
     */
    @Override
    public BasicTask createTask(TaskIdentifer taskIdentifer) {
     return (BasicTask) applicationContext.getBean(taskIdentifer.getBeanIdentifer());   
    }
   
    @Override
    public BasicTask createCompositeTask(List<BasicTask> tasks,boolean haultOnError) {
     CompositeTask composite = new CompositeTask();
     
     composite.setCompositeOrMode(haultOnError);
     
     for (BasicTask task : tasks)   {            
      composite.getTaskList().add(task);
     }
     
     return composite;   
    }
    
    /**
     * 
     * @param tasks
     * @return 
     */
     @Override
    public BasicTask createCompositeTask(List<BasicTask> tasks) {
     CompositeTask composite = new CompositeTask();          
     
     for (BasicTask task : tasks)   {            
      composite.getTaskList().add(task);
     }
     
     return composite;   
    }
    
   
    @Override
    public BasicTask createCompositeTask(BasicTask[] tasks, boolean haultOnError) {
     CompositeTask composite = new CompositeTask();
     
     composite.setCompositeOrMode(haultOnError);
     
     for (BasicTask task : tasks)   {            
      composite.getTaskList().add(task);
     }
     
     return composite;   
    }
    
    /**
     * 
     * @param tasks
     * @return 
     */
     @Override
    public BasicTask createCompositeTask(BasicTask[] tasks) {
     CompositeTask composite = new CompositeTask();         
     
     for (BasicTask task : tasks)   {            
      composite.getTaskList().add(task);
     }
     
     return composite;   
    }
    
    /**
     * 
     * @param task 
     */
    @Override
    public void submitTask(BasicTask task) {
        TaskIdentifer taskIdentifier = task.getTaskIdentifer();
        
        monitors.put(taskIdentifier, task.getMonitor());
        
        Future<TaskMonitor> future = this.executor.submit(task);   
        
        futures.put(taskIdentifier, future);
    }
    
    /**
     * 
     * @param taskIdentifer 
     */
    @Override
    public TaskMonitor checkProgress(TaskIdentifer taskIdentifer) {
      return monitors.get(taskIdentifer);  
    }
    
    /**
     * 
     * @param taskIdentifer
     * @return 
     */
    @Override
    public boolean isExecuting(TaskIdentifer taskIdentifer) {
     if (!futures.containsKey(taskIdentifer))  {
      return false;   
     } 
     
     return !futures.get(taskIdentifer).isDone();     
    }
    
    
    /**
     * 
     * @param taskIdentifer
     * @return 
     */
    @Override
    public boolean isComplete(TaskIdentifer taskIdentifer) {
     if (!futures.containsKey(taskIdentifer))  {
      return true;   
     } 
     
     return futures.get(taskIdentifer).isDone();     
    }
    
    /**
     * 
     * @param taskIdentifer 
     */
    @Override
    public void clearTask(TaskIdentifer taskIdentifer) {
     if (futures.containsKey(taskIdentifer) && (futures.get(taskIdentifer).isDone() || futures.get(taskIdentifer).isCancelled()))  {
      futures.remove(taskIdentifer);
      monitors.remove(taskIdentifer);
     }    
    }
    
    /**
     * 
     * @param applicationContext
     * @throws BeansException 
     */    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 
     * @param threadPoolSize 
     */
    public void setThreadPoolSize(Integer threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
    }
    
    
    
}
