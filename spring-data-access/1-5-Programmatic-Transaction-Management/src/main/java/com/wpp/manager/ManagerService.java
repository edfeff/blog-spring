package com.wpp.manager;

import com.wpp.service.WorkerService;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author wangpp
 */
public class ManagerService {
    private PlatformTransactionManager manager;

    private WorkerService workerService;

    public PlatformTransactionManager getManager() {
        return manager;
    }

    public void setManager(PlatformTransactionManager manager) {
        this.manager = manager;
    }

    public WorkerService getWorkerService() {
        return workerService;
    }

    public void setWorkerService(WorkerService workerService) {
        this.workerService = workerService;
    }

    public ManagerService(PlatformTransactionManager manager) {
        this.manager = manager;
    }

    public void work() {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setName("Manager Work");
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        definition.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        definition.setReadOnly(false);

        TransactionStatus transaction = manager.getTransaction(definition);

        try {

            workerService.work();

        } catch (Throwable throwable) {
            manager.rollback(transaction);
            throw throwable;
        }

        manager.commit(transaction);
    }

}
