package com.daleyzou.file2db;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.stereotype.Component;

/**
 * CommonStepListener
 * @description TODO
 * @author zoudaifa
 * @date 2021年03月06日 5:54 下午
 */
@Slf4j
@Component
public class CommonStepListener extends StepExecutionListenerSupport {

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        int readCount = stepExecution.getReadCount();
        int filterCount = stepExecution.getFilterCount();
        int commitCount = stepExecution.getCommitCount();
        int writeCount = stepExecution.getWriteCount();
        log.info("------------- CommonStepListener ----------------------" + " read:" + readCount + ", filter:"
                + filterCount + ",commit:" + commitCount + ",write:" + writeCount);

        return stepExecution.getExitStatus();
    }
}
