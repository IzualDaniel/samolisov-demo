package name.samolisov.demo.spring.workmanager.services;

import commonj.work.Work;
import commonj.work.WorkEvent;
import commonj.work.WorkException;
import commonj.work.WorkListener;
import commonj.work.WorkManager;

public class BlankRunnableService implements RunnableService {

    private WorkManager workManager;
    
    private Runnable task;
    
    private int taskCount;
    
    public void setWorkManager(WorkManager workManager) {
        this.workManager = workManager;
    }
    
    public void setTask(Runnable task) {
        this.task = task;
    }
    
    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }
    
    @Override
    public void doIt() {
        try {
            for (int i = 0; i < taskCount; i++) {
                workManager.schedule(
                    new Work() {
                        @Override
                        public void run() {
                            task.run();
                        }
                
                        @Override
                        public void release() {
                            System.out.println("$work.release(" + hashCode() + ")");
                        }
                
                        @Override
                        public boolean isDaemon() {
                            return false;
                        }
                    }, 
                    new WorkListener() {
                        @Override
                        public void workStarted(WorkEvent event) {
                            System.out.println("$worklistener.workStarted, status: " + 
                                    event.getWorkItem().getStatus() + ", " + 
                                    event.getWorkItem().toString() + ", thread: " + 
                                    Thread.currentThread().getName());
                            sleep();
                        }
                        
                        @Override
                        public void workRejected(WorkEvent event) {
                            System.out.println("$worklistener.workRejected, status: " + 
                                    event.getWorkItem().getStatus() + ", " + 
                                    event.getWorkItem().toString() + ", thread: " + 
                                    Thread.currentThread().getName());
                            sleep();
                        }
                        
                        @Override
                        public void workCompleted(WorkEvent event) {
                            System.out.println("$worklistener.workCompleted, status: " + 
                                    event.getWorkItem().getStatus() + ", " + 
                                    event.getWorkItem().toString() + ", thread: " + 
                                    Thread.currentThread().getName());
                            sleep();
                        }
                        
                        @Override
                        public void workAccepted(WorkEvent event) {
                            System.out.println("$worklistener.workAccepted, status: " + 
                                    event.getWorkItem().getStatus()+ ", " + 
                                    event.getWorkItem().toString() + ", thread: " + 
                                    Thread.currentThread().getName());
                            sleep();
                        }
                    });
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (WorkException e) {
            e.printStackTrace();
        }
    }
    
    private static void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
