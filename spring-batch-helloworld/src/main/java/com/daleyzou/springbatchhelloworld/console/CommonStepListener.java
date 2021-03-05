package com.daleyzou.springbatchhelloworld.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.stereotype.Component;

/**
 * CommonStepListener
 * @description 通用作业步监听
 * @author daleyzou
 * @date 2021年03月05日 8:21 下午
 */
@Component
@Slf4j
public class CommonStepListener extends StepExecutionListenerSupport {
    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        int readCount = stepExecution.getReadCount();
        int writeCount = stepExecution.getWriteCount();
        int commitCount = stepExecution.getCommitCount();
        int filterCount = stepExecution.getFilterCount();
        log.debug("readCount:{}, filterCount, {}, commitCount: {}, writeCount:{}", readCount, filterCount, commitCount,
                writeCount);
        return stepExecution.getExitStatus();
    }
}
