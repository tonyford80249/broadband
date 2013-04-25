package com.cdoe.services.exempt;

import com.cdoe.services.concurrent.BasicTask;
import com.cdoe.services.concurrent.TaskIdentifer;
import com.cdoe.services.concurrent.TaskMonitor;
import java.util.List;

/**
 *
 * @author Tony Ford
 */
public interface ITaskExecutionManager {

    /**
     *
     * @param taskIdentifer
     */
    TaskMonitor checkProgress(TaskIdentifer taskIdentifer);

    /**
     *
     * @param taskIdentifer
     */
    void clearTask(TaskIdentifer taskIdentifer);

    /**
     *
     * @param taskIdentifers
     * @return
     */
    BasicTask createCompositeTask(List<BasicTask> tasks);
    
    /**
     * 
     * @param tasks
     * @param haultOnError
     * @return 
     */
    BasicTask createCompositeTask(List<BasicTask> tasks,boolean haultOnError);
    
    /**
     * 
     * @param tasks
     * @return 
     */
     BasicTask createCompositeTask(BasicTask[] tasks);
     
     /**
      * 
      * @param tasks
      * @param haultOnError
      * @return 
      */
     BasicTask createCompositeTask(BasicTask[] tasks, boolean haultOnError);

    /**
     *
     * @param taskIdentifer
     * @return
     */
    BasicTask createTask(TaskIdentifer taskIdentifer);

    /**
     *
     * @param taskIdentifer
     * @return
     */
    boolean isComplete(TaskIdentifer taskIdentifer);

    /**
     *
     * @param taskIdentifer
     * @return
     */
    boolean isExecuting(TaskIdentifer taskIdentifer);

    /**
     *
     * @param task
     */
    void submitTask(BasicTask task);
    
}
